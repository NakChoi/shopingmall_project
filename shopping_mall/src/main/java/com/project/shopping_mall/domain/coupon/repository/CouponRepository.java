package com.project.shopping_mall.domain.coupon.repository;

import com.project.shopping_mall.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Optional<Coupon> findByTitle(String name);
}
