package com.project.shopping_mall.domain.member.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class EmailConfirmRequestDto {

    @NotBlank(message = "이메일을 입력해 주세요.")
    @Email
    private String email;

}