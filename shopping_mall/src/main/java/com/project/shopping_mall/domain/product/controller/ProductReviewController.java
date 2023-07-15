package com.project.shopping_mall.domain.product.controller;


import com.project.shopping_mall.domain.product.mapper.ProductMapper;
import com.project.shopping_mall.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products/reviews")
public class ProductReviewController {

    private final ProductMapper productMapper;

    private final ProductService productService;


    @PostMapping
    public ResponseEntity postProductReview() {

        return ResponseEntity.ok().build();
    }

}
