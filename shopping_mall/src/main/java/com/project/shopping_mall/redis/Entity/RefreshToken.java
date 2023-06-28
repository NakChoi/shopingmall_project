package com.project.shopping_mall.redis.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash(value = "refreshToken", timeToLive = 180)
@Getter
@AllArgsConstructor
public class RefreshToken {

    @Id
    private String userId;

    private String refreshToken;

    private String accessToken;

}
