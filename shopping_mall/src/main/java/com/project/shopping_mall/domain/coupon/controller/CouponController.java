package com.project.shopping_mall.domain.coupon.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupons")
public class CouponController {


    @PostMapping
    public ResponseEntity postCoupon(){

        return ResponseEntity.ok().build();
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
