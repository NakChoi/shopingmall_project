package com.project.shopping_mall.domain.product.controller;


import com.project.shopping_mall.domain.product.dto.ProductSizeDto;
import com.project.shopping_mall.domain.product.entity.ProductSize;
import com.project.shopping_mall.domain.product.mapper.ProductMapper;
import com.project.shopping_mall.domain.product.service.ProductService;
import com.project.shopping_mall.globalDto.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Valid
@RequestMapping("/products/sizes")
public class ProductSizeController {

    private final ProductMapper productMapper;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity postProductSize(@RequestBody ProductSizeDto.Post dto) {

        ProductSize productSize = productMapper.productSizeDtoToProductSize(dto);

        ProductSize savedProductSize = productService.createProductSize(productSize);

        return ResponseEntity.created(URI.create("/sizes/" + savedProductSize.getProductSizeId())).build();

    }

    @PatchMapping("/{product-size-id}")
    public ResponseEntity patchProductSize(@PathVariable("product-size-id") @Positive Long productSizeId,
                                           @RequestBody ProductSizeDto.Patch dto){

        ProductSize productSize = productMapper.productSizePatchDtoToProductSize(dto);
        productSize.setProductSizeId(productSizeId);

        ProductSize savedProductSize = productService.updateProductSize(productSize);

        ProductSizeDto.Response response = productMapper.productSizeToProductSizeResponseDto(savedProductSize);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @GetMapping("/{product-id}")
    public ResponseEntity getProductSizes(@PathVariable("product-id") @Positive Long id){

         List<ProductSize> productSizeList = productService.getProductSize(id);

         List<ProductSizeDto.Response> responses = productMapper.productSizesToProductSizeResponseDto(productSizeList);

        return new ResponseEntity(new SingleResponseDto<>(responses), HttpStatus.OK);
    }

    @DeleteMapping("/{product-size-id}")
    public ResponseEntity deleteProductSize(@PathVariable("product-size-id") @Positive Long id){
        productService.deleteProductSize(id);

        return ResponseEntity.noContent().build();
    }
}
