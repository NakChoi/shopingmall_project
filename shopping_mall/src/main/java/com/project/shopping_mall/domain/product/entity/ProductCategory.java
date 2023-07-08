package com.project.shopping_mall.domain.product.entity;


import com.project.shopping_mall.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ProductCategory extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductCategoryId;


    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID") // Category에 ProductCategory를 어떤 컬럼명으로 설정할 것인지 나타내기 위함.
    private Category category;


    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
