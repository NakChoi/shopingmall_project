package com.project.shopping_mall.domain.member.service;

import com.project.shopping_mall.domain.member.entity.Member;
import com.project.shopping_mall.domain.member.repository.MemberRepository;
import com.project.shopping_mall.exception.CustomException;
import com.project.shopping_mall.exception.ExceptionCode;
import com.project.shopping_mall.security.utils.CustomAuthorityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    public Member registerMember(Member member) {
        verifyExistsEmail(member.getEmail());

        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        List<String> roles = authorityUtils.createRoles(member.getEmail());
        member.setRoles(roles);

        Member savedMember = memberRepository.save(member);

        return savedMember;

    }

    public void checkUserId(String id){
        verifyExistsEmail(id);
    }

    @Transactional(readOnly = true)
    public Member findMember(Long memberId){

        return verifyExistsMemberId(memberId);
    }

    public Member updateMember(Member member) {
        Member verifiedMember = verifyExistsMemberId(member.getMemberId());


        Optional.ofNullable(member.getPassword()).ifPresent(password -> verifiedMember.setPassword(password));

        return verifiedMember;
    }

    public void deleteMember(Long memberId) {

        memberRepository.deleteById(memberId);
    }


    private void verifyExistsEmail(String email){
        Optional<Member> member = memberRepository.findByEmail(email);

        if (member.isPresent()) {
            throw new CustomException(ExceptionCode.MEMBER_EXIST);
        }

    }

    private Member verifyExistsMemberId(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new CustomException(ExceptionCode.MEMBER_NOT_FOUND));

        return member;
    }

}





