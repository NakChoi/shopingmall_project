package com.project.shopping_mall.domain.product.entity;


import com.project.shopping_mall.domain.member.entity.Member;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "productReview") // mappedBy = "product_review" 로 하니까 매핑 오류났음.
    private List<ProductReviewImage> productReviewImage = new ArrayList<>();

}
