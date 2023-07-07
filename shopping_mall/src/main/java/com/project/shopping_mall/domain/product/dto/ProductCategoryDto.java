package com.project.shopping_mall.domain.product.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class ProductCategoryDto {


    @Getter
    @Setter
    public static class Post{

        private Long productId;

        private Long categoryId;
    }

    @Getter
    public static class Patch{
        private Long productId;

        private Long categoryId;
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
        private Long productId;

        private Long categoryId;
    }
}
