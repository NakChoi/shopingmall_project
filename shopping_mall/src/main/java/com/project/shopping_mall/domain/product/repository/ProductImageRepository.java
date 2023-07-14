package com.project.shopping_mall.domain.product.repository;

import com.project.shopping_mall.domain.product.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    ProductImage findByProduct_ProductIdAndSeq(Long productId, String seq);


    List<ProductImage> findByProduct_ProductId(Long productId);
}
