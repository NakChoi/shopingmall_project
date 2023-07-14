package com.project.shopping_mall.domain.product.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productReviewId;

    private String title;

    private String content;

    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @OneToMany(mappedBy = "product_review")
    private List<ProductReviewImage> productReviewImage = new ArrayList<>();
}
