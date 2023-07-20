package com.project.shopping_mall.domain.coupon.mapper;


import com.project.shopping_mall.domain.coupon.dto.CouponDto;
import com.project.shopping_mall.domain.coupon.entity.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CouponMapper {

    @Mapping(source = "member", target = "member.memberId")
    Coupon couponPostDtoToCoupon(CouponDto.Post couponPostDto);

    Coupon couponPatchDtoToCoupon(CouponDto.Patch couponPostDto);

    CouponDto.Response couponToCouponResponseDto(Coupon coupon);

    List<CouponDto.Response> couponToCouponResponseDto(List<Coupon> coupon);
}
