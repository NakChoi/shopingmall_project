package com.project.shopping_mall.domain.coupon.service;

import com.project.shopping_mall.domain.coupon.entity.Coupon;
import com.project.shopping_mall.domain.coupon.repository.CouponRepository;
import com.project.shopping_mall.exception.CustomException;
import com.project.shopping_mall.exception.ExceptionCode;
import com.project.shopping_mall.utils.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    private final CustomBeanUtils customBeanUtils;

    public Coupon postCoupon(Coupon coupon){
        verifyCouponByTitle(coupon); // title 이 일련 번호로도 쓰인다. 타이틀로 중복 검사.

        Coupon savedCoupon = couponRepository.save(coupon);

        return savedCoupon;
    }

    public Coupon patchCoupon(Coupon coupon) {
        Coupon verifiedCoupon = verifyCouponById(coupon.getCouponId());

        customBeanUtils.copyNonNullProperties(coupon, verifiedCoupon);

        return verifiedCoupon;
    }

    private void verifyCouponByTitle(Coupon coupon){
        couponRepository.findByTitle(coupon.getTitle()).ifPresent( verifiedCoupon -> {
            throw new CustomException(ExceptionCode.COUPON_EXIST);
        });
    }

    private Coupon verifyCouponById(Long id) {
        Coupon coupon = couponRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionCode.COUPON_NOT_EXIST));

        return coupon;
    }

}
