package com.project.shopping_mall.security.auth.controller;


import com.project.shopping_mall.security.auth.service.RefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {


    private final RefreshService refreshService;

    @PostMapping("/refresh")
    public ResponseEntity validateRefreshToken(HttpServletRequest request){

        String refreshToken = request.getHeader("Refresh");

        String updateAccessToken = refreshService.regenerateAccessToken(refreshToken);

        return ResponseEntity.noContent()
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+ updateAccessToken)
                .build();
    }

}
