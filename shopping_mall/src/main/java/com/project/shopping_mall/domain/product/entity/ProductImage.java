package com.project.shopping_mall.domain.product.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productImageId;

    private String url;

    private String seq;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
