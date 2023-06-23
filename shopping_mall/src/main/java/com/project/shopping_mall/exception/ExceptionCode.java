package com.project.shopping_mall.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "Member Not Found"),
    MEMBER_EXIST(HttpStatus.CONFLICT, "Member Exist");


    @Getter
    private HttpStatus httpStatus;

    @Getter
    private String message;

    ExceptionCode(HttpStatus status, String message) {
        this.httpStatus = status;
        this.message = message;
    }
}



