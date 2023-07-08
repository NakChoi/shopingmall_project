package com.project.shopping_mall.domain.product.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;

    private Integer seq;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ProductCategory> productCategories = new ArrayList<>();

}
