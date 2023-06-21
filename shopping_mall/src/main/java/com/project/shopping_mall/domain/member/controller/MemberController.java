package com.project.shopping_mall.domain.member.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {


    @PostMapping("/signUp")
    public ResponseEntity<?> postMember(){
        return null;
    }
}
