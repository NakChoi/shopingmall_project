package com.project.shopping_mall.domain.member.service;

import com.project.shopping_mall.domain.member.entity.Member;
import com.project.shopping_mall.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Member registerMember(Member member) {
        verifyExistsEmail(member.getEmail());
        System.out.println(member.getPhoneNumber());

        Member savedMember = memberRepository.save(member);

        return savedMember;

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
            throw new IllegalArgumentException();
        }

    }

    private Member verifyExistsMemberId(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException());

        return member;
    }


}





