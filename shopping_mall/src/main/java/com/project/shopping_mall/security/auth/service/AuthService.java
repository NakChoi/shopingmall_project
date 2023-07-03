package com.project.shopping_mall.security.auth.service;

import com.project.shopping_mall.domain.member.entity.Member;
import com.project.shopping_mall.domain.member.repository.MemberRepository;
import com.project.shopping_mall.exception.CustomException;
import com.project.shopping_mall.exception.ExceptionCode;
import com.project.shopping_mall.redis.repository.RefreshTokenRepository;
import com.project.shopping_mall.security.jwt.JwtTokenizer;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenizer jwtTokenizer;
    private final RefreshTokenRepository refreshTokenRepository;
    private final MemberRepository memberRepository;


    public String regenerateAccessToken(String refreshToken){
            String username = (String) jwtTokenizer.getClaims(refreshToken).getBody().get("sub");

            String updateAccessToken = delegateAccessToken(username);
            return updateAccessToken;


    }

    private String delegateAccessToken(String username) {

        verifyRefreshTokenJws(username);

        Member member = memberRepository.findByEmail(username).orElseThrow();

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", member.getEmail());
        claims.put("memberId", member.getMemberId());
        claims.put("roles", member.getRoles());

        String subject = member.getEmail();
        Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getAccessTokenExpirationMinutes());

        String base64EncodedSecretKey = jwtTokenizer.encodedBase64SecretKey(jwtTokenizer.getSecretKey());

        String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        return accessToken;
    }

    private void verifyRefreshTokenJws(String username) {

            refreshTokenRepository.findById(username).orElseThrow(() -> new CustomException(ExceptionCode.REFRESHTOKEN_EXPIRATION));
    }


}
