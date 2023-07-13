package com.project.shopping_mall.domain.product.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ProductSize {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductSizeId;

    private String prod_size;


    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

}
