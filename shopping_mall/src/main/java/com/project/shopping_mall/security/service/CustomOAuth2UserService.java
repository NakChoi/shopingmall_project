package com.project.shopping_mall.security.service;

import com.project.shopping_mall.domain.member.entity.Member;
import com.project.shopping_mall.domain.member.repository.MemberRepository;
import com.project.shopping_mall.exception.CustomException;
import com.project.shopping_mall.exception.ExceptionCode;
import com.project.shopping_mall.security.oauth2.service.PrincipalDetails;
import com.project.shopping_mall.security.oauth2.attribute.OAuth2Attributes;
import com.project.shopping_mall.security.utils.CustomAuthorityUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();



        OAuth2Attributes attributes = OAuth2Attributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());


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
}
