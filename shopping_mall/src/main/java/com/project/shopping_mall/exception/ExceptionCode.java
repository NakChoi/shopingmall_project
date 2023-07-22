package com.project.shopping_mall.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "Member Not Found"),
    MEMBER_EXIST(HttpStatus.CONFLICT, "Member Exist"),
    PASSWORD_NOT_MATCH(HttpStatus.UNAUTHORIZED, "Password is Not Matched"),
    ACCESSTOKEN_EXPIRATION(HttpStatus.UNAUTHORIZED, "AceessToken is Expired"),
    PRODUCT_NAME_EXIST(HttpStatus.CONFLICT, "Product Name Exists"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "Product Not Found"),
    PRODUCT_DETAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "Product Detail Not Found"),
    PRODUCT_SIZE_NOT_FOUND(HttpStatus.NOT_FOUND, "Product Size Not Found"),
    PRODUCT_IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "Product Image Not Found"),
    CATEGORY_NAME_EXIST(HttpStatus.CONFLICT, "Category Name Exists"),
    CATEGORY_NOT_EXIST(HttpStatus.CONFLICT, "Category Not Exists"),
    REVIEW_NOT_EXIST(HttpStatus.CONFLICT, "Review Not Exists"),
    COUPON_EXIST(HttpStatus.CONFLICT, "Coupon Exist"),
    COUPON_NOT_EXIST(HttpStatus.NOT_FOUND, "Coupon Not Exist"),
    REFRESHTOKEN_EXPIRATION(HttpStatus.UNAUTHORIZED, "Refresh Token is Expired");


    @Getter
    private HttpStatus httpStatus;

    @Getter
    private String message;

    ExceptionCode(HttpStatus status, String message) {
        this.httpStatus = status;
        this.message = message;
    }
}



