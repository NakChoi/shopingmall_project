package com.project.shopping_mall.domain.product.repository;

import com.project.shopping_mall.domain.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {


    //@Query("SELECT p FROM ProductCategory p JOIN FETCH p.category JOIN FETCH p.product WHERE p.category.id = ?1")
    @Query("SELECT p FROM ProductCategory p JOIN FETCH p.product WHERE p.category.id = ?1")
    List<ProductCategory> findByCategory_CategoryId(Long id);
}
