package com.project.shopping_mall.domain.product.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productDetailId;

    private String description;

    private String seq;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
