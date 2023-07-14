package com.project.shopping_mall.domain.product.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class ProductReviewImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productReviewImageId;

    private String url;

    private Integer seq;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_REVIEW")
    private ProductReview productReview;
}
