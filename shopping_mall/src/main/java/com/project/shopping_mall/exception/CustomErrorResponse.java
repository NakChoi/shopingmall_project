package com.project.shopping_mall.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomErrorResponse {

    private CustomErrorResponse.CustomErrors customErrors;


    public CustomErrorResponse(CustomErrorResponse.CustomErrors customErrors) {
        this.customErrors = customErrors;
    }

    public static CustomErrorResponse of(ExceptionCode exceptionCode){
        return new CustomErrorResponse(CustomErrorResponse.CustomErrors.of(exceptionCode));
    }

    @Getter
    public static class CustomErrors{

        private HttpStatus httpStatus;
        private String message;

        private CustomErrors(HttpStatus httpStatus, String message) {
            this.httpStatus = httpStatus;
            this.message = message;
        }

        public static CustomErrorResponse.CustomErrors of(ExceptionCode exceptionCode){

            CustomErrorResponse.CustomErrors customErrors = new CustomErrorResponse.CustomErrors(exceptionCode.getHttpStatus(), exceptionCode.getMessage());

            return customErrors;

        }
    }
}


