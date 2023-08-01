package com.project.shopping_mall.domain.order.entity;


import com.project.shopping_mall.domain.coupon.entity.Coupon;
import com.project.shopping_mall.domain.member.entity.Member;
import com.project.shopping_mall.domain.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderId;

    private String zipCode;

    private String address;

    private String address2;

    private String receiver;

    private String phoneNumber;

    private String message;

    private OrderStatus orderStatus = OrderStatus.PREPARING_ORDER;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member; // 조회할때 필요할듯..

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "ORDER_PRODUCT_ID")
    private OrderProduct orderProduct;

    @ManyToOne
    @JoinColumn(name = "COUPON_ID")
    private Coupon coupon;


    public enum OrderStatus{

        PREPARING_ORDER("주문 접수 중"),
        PREPARING_DELIVERY("배송 준비 중"),
        ON_ITS_WAY("배송 중"),
        DELIVERED("배송 완료");

        @Getter
        private String status;

        OrderStatus(String status){
            this.status = status;
        }
    }
}
