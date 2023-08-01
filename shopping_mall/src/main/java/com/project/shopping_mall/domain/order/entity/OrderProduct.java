package com.project.shopping_mall.domain.order.entity;


import com.project.shopping_mall.domain.member.entity.Member;
import com.project.shopping_mall.domain.product.entity.Product;
import com.project.shopping_mall.domain.product.entity.ProductOption;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderProductId;

    private Integer quantity;


    @OneToMany(mappedBy = "orderProduct")
    private List<Order> order = new ArrayList<>();

    @ManyToOne
    private Product product;

    @ManyToOne
    private Member member;

    @ManyToOne
    private ProductOption productOption;
}
