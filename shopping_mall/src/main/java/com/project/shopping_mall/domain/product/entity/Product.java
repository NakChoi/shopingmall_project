package com.project.shopping_mall.domain.product.entity;


import com.project.shopping_mall.audit.Auditable;
import com.project.shopping_mall.domain.order.entity.OrderProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    @NotBlank
    private String price;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ProductCategory> productCategory = new ArrayList<>();

    @OneToMany(mappedBy = "product",  orphanRemoval = true)
    private List<ProductDetail> productDetail = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<ProductSize> productSize = new ArrayList<>();

    //@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ProductImage> productImage = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ProductReview> productReview = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<ProductOption> productOption = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProduct = new ArrayList<>();

}
