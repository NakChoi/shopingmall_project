package com.project.shopping_mall.domain.coupon.dto;

import com.project.shopping_mall.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class CouponDto {

    @Getter
    @Setter
    public static class Post{

        private String title;

        private String description;

        private Integer discount;

        private Integer amount;

        private Member member;

    }


    @Getter
    @Setter
    public static class Patch{

        private String title;

        private String description;

        private Integer discount;

    }


    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response{

        private String title;

        private String description;

        private Integer discount;

        private Integer amount;

    }
}
