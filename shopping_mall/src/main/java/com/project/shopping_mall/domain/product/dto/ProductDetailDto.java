package com.project.shopping_mall.domain.product.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ProductDetailDto {

    @Setter
    @Getter
    public static class Post{

        private Long product;

        private String description;

        private Integer seq;
    }

    @Setter
    @Getter
    public static class Patch{

        //private Long product;

        private String description;

        private Integer seq;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Response{

        private Long product;

        private String description;

        private Integer seq;
    }

}
