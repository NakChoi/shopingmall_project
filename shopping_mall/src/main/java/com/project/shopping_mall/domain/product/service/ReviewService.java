package com.project.shopping_mall.domain.product.service;


import com.project.shopping_mall.domain.product.entity.ProductReview;
import com.project.shopping_mall.domain.product.repository.ReviewRepository;
import com.project.shopping_mall.exception.CustomException;
import com.project.shopping_mall.exception.ExceptionCode;
import com.project.shopping_mall.utils.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final CustomBeanUtils customBeanUtils;


    public ProductReview postProductReview(ProductReview productReview){

        ProductReview savedProductReview = reviewRepository.save(productReview);

        return savedProductReview;
    }

    public void patchProductReview(ProductReview productReview){
        ProductReview verifiedProductReview = verifyProductReview(productReview.getProductReviewId());

        customBeanUtils.copyNonNullProperties(productReview, verifiedProductReview);

    }

    public ProductReview getProductReview(Long productReviewId){
        ProductReview verifiedProductReview = verifyProductReview(productReviewId);

        return verifiedProductReview;
    }

    public Page<ProductReview> getProductReviews(long productId, int page, int size){
        Page<ProductReview> verifiedProductReview = reviewRepository.findByProduct_ProductId(productId, PageRequest.of(page, size, Sort.by("product.productId").descending()));
        System.out.println("===============================================");
        return verifiedProductReview;
    }



    public void deleteProductReview(Long productReviewId){
        ProductReview productReview = verifyProductReview(productReviewId);

        reviewRepository.delete(productReview);
    }

    private ProductReview verifyProductReview(Long productReviewId){

        ProductReview productReview = reviewRepository.findById(productReviewId).orElseThrow(() -> new CustomException(ExceptionCode.REVIEW_NOT_EXIST));

        return productReview;
    }

}
