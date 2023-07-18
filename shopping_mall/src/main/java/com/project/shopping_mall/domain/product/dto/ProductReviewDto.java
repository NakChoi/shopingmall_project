package com.project.shopping_mall.domain.product.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ProductReviewDto {


    @Getter
    @Setter
    public static class Post{

        private Long member;

        private Long product;

        private String title;

        private String content;

        private Integer rating;
    }

    @Getter
    @Setter
    public static class Patch{

        private String title;

        private String content;

        private Integer rating;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response{

        private String title;

        private String content;

        private Integer rating;
    }
}
