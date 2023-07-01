package com.project.shopping_mall.domain.product.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@Valid
@RequiredArgsConstructor
public class ProductController {


}
