package com.project.shopping_mall.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class CategoryDto {

    @Getter
    public static class Post{

        @NotBlank
        private String name;

        @NotBlank
        private Integer seq;
    }

    @Getter
    public static class Patch{

        private String name;

        private Integer seq;
    }


    @AllArgsConstructor
    @Getter
    public static class Response{

        private String name;

        private Integer seq;
    }
}
