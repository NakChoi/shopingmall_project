package com.project.shopping_mall.domain.product.controller;


import com.project.shopping_mall.domain.product.dto.ProductReviewDto;
import com.project.shopping_mall.domain.product.entity.ProductReview;
import com.project.shopping_mall.domain.product.mapper.ProductMapper;
import com.project.shopping_mall.domain.product.service.ReviewService;
import com.project.shopping_mall.globalDto.MultiResponseDto;
import com.project.shopping_mall.globalDto.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products/reviews")
public class ProductReviewController {

    private final ProductMapper productMapper;

    private final ReviewService reviewService;


    @PostMapping
    public ResponseEntity postProductReview(@RequestBody ProductReviewDto.Post dto) {
        ProductReview productReview = productMapper.productReviewDtoToProductReview(dto);

        ProductReview savedProductReview = reviewService.postProductReview(productReview);

        return ResponseEntity.created(URI.create("/products/reviews/" + savedProductReview.getProductReviewId())).build();
    }

    @PatchMapping("/{product-review-id}")
    public ResponseEntity patchProductReview(@RequestBody ProductReviewDto.Patch dto,
                                             @PathVariable("product-review-id") @Positive Long productReviewId){
        ProductReview productReview = productMapper.productReviewPatchDtoToProductReview(dto);

        productReview.setProductReviewId(productReviewId);

        reviewService.patchProductReview(productReview);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{product-review-id}/review")
    public ResponseEntity getProductReview(@PathVariable("product-review-id") @Positive Long productReviewId){

        ProductReview productReview = reviewService.getProductReview(productReviewId);

        ProductReviewDto.Response response = productMapper.productReviewToProductReviewResponseDto(productReview);
        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @GetMapping("/list/{product-id}")
    public ResponseEntity getProductReviews(@PathVariable("product-id") @Positive Long productReviewId,
                                            @RequestParam int page,
                                            @RequestParam int size){

        Page<ProductReview> productReviews = reviewService.getProductReviews(productReviewId, page - 1, size);

        List<ProductReview> productReviewList = productReviews.getContent();

        List<ProductReviewDto.Response> responses = productMapper.productReviewsToProductReviewResponseDto(productReviewList);

        return new ResponseEntity(new MultiResponseDto<>(responses, productReviews), HttpStatus.OK);
    }

    @DeleteMapping("/{product-review-id}")
    public ResponseEntity patchProductReview(@PathVariable("product-review-id") @Positive Long productReviewId) {

        reviewService.deleteProductReview(productReviewId);

        return ResponseEntity.ok().build();
    }
}
