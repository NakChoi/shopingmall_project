package com.project.shopping_mall.domain.product.entity;


import com.project.shopping_mall.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.util.annotation.Nullable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer price;

}
