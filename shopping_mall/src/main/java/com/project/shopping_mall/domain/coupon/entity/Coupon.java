package com.project.shopping_mall.domain.coupon.entity;


import com.project.shopping_mall.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    private String title;

    private String description;

    private Integer discount;

    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

}
