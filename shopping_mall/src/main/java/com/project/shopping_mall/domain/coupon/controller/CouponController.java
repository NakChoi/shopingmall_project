package com.project.shopping_mall.domain.coupon.controller;


import com.project.shopping_mall.domain.coupon.dto.CouponDto;
import com.project.shopping_mall.domain.coupon.entity.Coupon;
import com.project.shopping_mall.domain.coupon.mapper.CouponMapper;
import com.project.shopping_mall.domain.coupon.repository.CouponRepository;
import com.project.shopping_mall.domain.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupons")
public class CouponController {

    private final CouponMapper couponMapper;

    private final CouponService couponService;

    @PostMapping
    public ResponseEntity postCoupon(@RequestBody CouponDto.Post dto){

        Coupon coupon = couponMapper.couponPostDtoToCoupon(dto);

        Coupon savedCoupon = couponService.postCoupon(coupon);

        return ResponseEntity.created(URI.create("/coupons/"+ savedCoupon.getCouponId())).build();
    }

    @PatchMapping
    public ResponseEntity patchCoupon(){

        return ResponseEntity.ok().build();
    }

    @GetMapping           // 쿠폰을 단일로 가져올 일은 없지 않을까?
    public ResponseEntity getCoupons(){

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteCoupon(){

        return ResponseEntity.ok().build();
    }
}
