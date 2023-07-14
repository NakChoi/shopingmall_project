package com.project.shopping_mall.domain.product.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ProductImageDto {

    @Getter
    @Setter
    public static class Post{

        private Long product;

        private String url;

        private String seq;

    }

    @Getter
    @Setter
    public static class Patch{
        private Long product;

        private String url;

        private String seq;
    }


    @AllArgsConstructor
    @Getter
    @Setter
    public static class Response{

        private Long product;

        private String url;

        private String seq;

    }
}
