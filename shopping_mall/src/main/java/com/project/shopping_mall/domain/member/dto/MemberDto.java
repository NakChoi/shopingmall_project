package com.project.shopping_mall.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Pattern;

public class MemberDto {

    @Getter
    public static class Post{
        @Pattern(regexp = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", message = "유효한 이메일 주소가 아닙니다.")
        private String email;

        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", message = "비밀번호는 영문과 특수문자, 숫자를 포함하여 8자 이상이고 20자 이하여야 합니다.")
        private String password;

        @Pattern(regexp = "^(?=.*[a-z가-힣])[a-z가-힣]{2,10}$", message = "이름은 2자 이상 10자 이하, 영어 또는 한글로 구성해야 합니다.")
        private String name;

        @Pattern(regexp = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", message = "올바른 한국 핸드폰 번호를 입력해주세요.")
        private String phoneNumber;


    }

    @Getter
    @AllArgsConstructor
    public static class Response{

        private String memberId;

        private String email;

        private String name;

        private String phoneNumber;
    }
}


