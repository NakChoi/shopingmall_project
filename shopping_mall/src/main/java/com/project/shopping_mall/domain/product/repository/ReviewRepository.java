package com.project.shopping_mall.domain.product.repository;

import com.project.shopping_mall.domain.product.entity.ProductReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ProductReview, Long> {


    Page<ProductReview> findByProduct_ProductId(long productId, Pageable pageable);
}
