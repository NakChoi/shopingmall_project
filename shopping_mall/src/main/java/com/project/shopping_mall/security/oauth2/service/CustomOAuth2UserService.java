package com.project.shopping_mall.security.oauth2.service;

import com.project.shopping_mall.domain.member.entity.Member;
import com.project.shopping_mall.domain.member.repository.MemberRepository;
import com.project.shopping_mall.exception.CustomException;
import com.project.shopping_mall.exception.ExceptionCode;
import com.project.shopping_mall.security.oauth2.attribute.OAuth2Attributes;
import com.project.shopping_mall.security.utils.CustomAuthorityUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final MemberRepository memberRepository;

    private final CustomAuthorityUtils authorityUtils;



    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("CustomOAuth2UserService");
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName(); // 어떤 소셜서비스든 그 서비스에서 각 계정마다의 유니크한 id값을 전달해주는 기능이다.(소셜 서비스 마다 유니크 필드명이 다르기 때문이다.)


        OAuth2Attributes attributes = OAuth2Attributes.of(userNameAttributeName, oAuth2User.getAttributes());

        verifyOAuth2MemberByEmail(attributes.getEmail());

        Member verifiedMember = save(attributes);

        return new PrincipalDetails(verifiedMember, attributes.getAttributes());

    }


    private Member save(OAuth2Attributes attributes){

        Member member = new Member();

        member.setEmail(attributes.getEmail());
        member.setName(attributes.getName());

        member.setRoles(getAuthorities(member.getEmail()));

        return memberRepository.save(member);
    }


    private List<String> getAuthorities(String email){

        return authorityUtils.createRoles(email);
    }

    private Optional<Member> verifyOAuth2MemberByEmail(String email){

        Optional<Member> verifiedByEmail = memberRepository.findByEmail(email);
        if (verifiedByEmail.isPresent()) {
            throw new CustomException(ExceptionCode.MEMBER_NOT_FOUND);
        }else {
            return verifiedByEmail;
        }

    }

    private final class PrincipalDetails implements UserDetails, OAuth2User {
        private Member member;
        private Map<String, Object> attributes;

        public PrincipalDetails(Member member){
            this.member = member;
        }

        public PrincipalDetails(Member member, Map<String, Object> attributes){
            this.member = member;
            this.attributes = attributes;
        }
        @Override
        public String getPassword() {
            return member.getPassword();
        }

        @Override
        public String getUsername() {
            return member.getEmail();
        }

        // 해당 유저의 권한을 리턴하는 method
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> authorities = this.member.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_"+ role))
                    .collect(Collectors.toList());

            return authorities;
        }

        @Override
        // 만료 여부
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        // 잠금 여부
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        // 만료 여부
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        // 회원 사용 여부
        public boolean isEnabled() {
            return true;
        }

        @Override
        public Map<String, Object> getAttributes() {
            return attributes;
        }

        @Override
        public <A> A getAttribute(String name) {
            return OAuth2User.super.getAttribute(name);
        }

        @Override
        public String getName() {
            return member.getEmail();
        }
    }

}
