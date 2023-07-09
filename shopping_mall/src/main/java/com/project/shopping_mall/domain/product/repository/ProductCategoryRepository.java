package com.project.shopping_mall.domain.product.repository;

import com.project.shopping_mall.domain.product.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    Page<ProductCategory> findByCategory_CategoryId(Long categoryId, Pageable pageable);
}
