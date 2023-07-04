package com.project.shopping_mall.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ProductDto {


    @Getter
    public static class Post{

        @NotBlank
        private String name;

        @NotBlank
        private String description;

        @NotBlank
        private String price;
    }

    @Getter
    public static class Patch{

        private String name;

        private String description;

        private String price;

    }

    @Getter
    @AllArgsConstructor
    public static class Response{

        private String name;

        private String description;

        private String price;
    }

    @Getter
    @AllArgsConstructor
    public static class PatchResponse{

        private String name;

        private String description;

        private String price;
    }


}
