package com.project.shopping_mall.domain.product.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ProductSizeDto {

    @Getter
    @Setter
    public static class Post{


        private Long product;

        private String prod_size;

    }


    @Getter
    @Setter
    public static class Patch{

        private Long product;

        private String prod_size;

    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Response{

        private Long product;

        private String prod_size;

    }
}
