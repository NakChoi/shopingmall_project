package com.project.shopping_mall.domain.member.controller;


import com.project.shopping_mall.domain.member.dto.MemberDto;
import com.project.shopping_mall.domain.member.entity.Member;
import com.project.shopping_mall.domain.member.mapper.MemberMapper;
import com.project.shopping_mall.domain.member.service.MemberService;
import com.project.shopping_mall.globalDto.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/my-profiles")
public class MyProfileController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive Long memberId) {
        Member member = memberService.findMember(memberId);
        MemberDto.Response response = memberMapper.memberToMemberResponse(member);

        return new ResponseEntity(new SingleResponseDto(response), HttpStatus.OK);
    }


    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive Long memberId,
                                      @Valid @RequestBody MemberDto.Patch memberPatchDto){

        Member member = memberMapper.memberPatchToMember(memberPatchDto);
        member.setMemberId(memberId);

        Member updatedMember = memberService.updateMember(member);
        MemberDto.Response response = memberMapper.memberToMemberResponse(updatedMember);

        return new ResponseEntity(new SingleResponseDto(response), HttpStatus.OK);
    }


}
