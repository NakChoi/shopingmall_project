package com.project.shopping_mall.domain.order.repository;

import com.project.shopping_mall.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
