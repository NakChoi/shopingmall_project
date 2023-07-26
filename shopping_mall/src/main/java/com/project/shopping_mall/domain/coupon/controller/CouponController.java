package com.project.shopping_mall.domain.coupon.controller;


import com.project.shopping_mall.domain.coupon.dto.CouponDto;
import com.project.shopping_mall.domain.coupon.entity.Coupon;
import com.project.shopping_mall.domain.coupon.mapper.CouponMapper;
import com.project.shopping_mall.domain.coupon.repository.CouponRepository;
import com.project.shopping_mall.domain.coupon.service.CouponService;
import com.project.shopping_mall.globalDto.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
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

    @PatchMapping("/{coupon-id}")
    public ResponseEntity patchCoupon(@RequestBody CouponDto.Patch dto){

        Coupon coupon = couponMapper.couponPatchDtoToCoupon(dto);

        Coupon updateCoupon = couponService.patchCoupon(coupon);

        CouponDto.Response response = couponMapper.couponToCouponResponseDto(updateCoupon);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @GetMapping("/{coupon-id}")           // 쿠폰을 단일로 가져올 일은 없지 않을까?
    public ResponseEntity getCoupon(@PathVariable("coupon-id") Long id){

        Coupon coupon = couponService.getCoupon(id);

        CouponDto.Response response = couponMapper.couponToCouponResponseDto(coupon);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }


    @GetMapping("/{member-id}")           // 쿠폰을 단일로 가져올 일은 없지 않을까?
    public ResponseEntity getCoupons(){

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{coupon-id}")
    public ResponseEntity deleteCoupon(@PathVariable("coupon-id") @Positive Long couponId){

        couponService.deleteCoupon(couponId);

        return ResponseEntity.noContent().build();
    }
}
