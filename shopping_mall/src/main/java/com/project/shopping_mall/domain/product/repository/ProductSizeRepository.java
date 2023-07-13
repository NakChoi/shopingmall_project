package com.project.shopping_mall.domain.product.repository;

import com.project.shopping_mall.domain.product.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {

    List<ProductSize> findByProduct_ProductId(Long id);

}
