package com.project.shopping_mall.domain.order.repository;

import com.project.shopping_mall.domain.order.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
