package com.project.shopping_mall.domain.product.entity;


import com.project.shopping_mall.domain.order.entity.OrderProduct;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productOptionId;

    private Integer quantity;

    private String color;

    private String size;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @OneToMany(mappedBy = "productOption")
    private List<OrderProduct> orderProduct = new ArrayList<>();
}
