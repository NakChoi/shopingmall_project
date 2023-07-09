package com.project.shopping_mall.domain.member.controller;


import com.project.shopping_mall.domain.member.dto.MemberDto;
import com.project.shopping_mall.domain.member.entity.Member;
import com.project.shopping_mall.domain.member.mapper.MemberMapper;
import com.project.shopping_mall.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;


@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post memberPostDto){

        Member member = memberMapper.memberPostToMember(memberPostDto);

        Member createdMember = memberService.createMember(member);

        return ResponseEntity.created(URI.create("/member"+ createdMember.getMemberId())).build();
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity checkUniqueId(@PathVariable String id) {
        memberService.checkUserId(id);


        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive Long memberId) {
        memberService.deleteMember(memberId);

        return ResponseEntity.noContent().build();
    }
}



