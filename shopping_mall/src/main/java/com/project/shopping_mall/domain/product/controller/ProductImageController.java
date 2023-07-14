package com.project.shopping_mall.domain.product.controller;


import com.project.shopping_mall.domain.product.dto.ProductImageDto;
import com.project.shopping_mall.domain.product.entity.ProductImage;
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
@RequestMapping("/products/images")
public class ProductImageController {

    private final ProductMapper productMapper;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity postProductImage(@RequestBody ProductImageDto.Post dto) {

        ProductImage productImage = productMapper.productImageDtoToProductImage(dto);

        ProductImage savedProductImage = productService.createProductImage(productImage);

        return ResponseEntity.created(URI.create("/products/images/"+savedProductImage.getProductImageId())).build();
    }

    @PatchMapping("/{product-image-id}")
    public ResponseEntity patchProductImage(@PathVariable("product-image-id") @Positive Long productImageId,
                                            @RequestBody ProductImageDto.Patch dto) {

        ProductImage productImage = productMapper.productImagePatchDtoToProductImage(dto);
        productImage.setProductImageId(productImageId);

        ProductImage savedProductImage = productService.updateProductImage(productImage);
        ProductImageDto.Response response = productMapper.productImageToProductImageResponseDto(savedProductImage);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @GetMapping("/single/{product-id}")
    public ResponseEntity getProductImage(@PathVariable("product-id") @Positive Long productId){

        ProductImage productImage = productService.getProductImage(productId);

        ProductImageDto.Response response = productMapper.productImageToProductImageResponseDto(productImage);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @GetMapping("/multiple/{product-id}")
    public ResponseEntity getProductImages(@PathVariable("product-id") @Positive Long productId){

        List<ProductImage> productImage = productService.getProductImages(productId);

        List<ProductImageDto.Response> response = productMapper.productImagesToProductImageResponseDto(productImage);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @DeleteMapping("/{product-image-id}")
    public ResponseEntity deleteProductImage(@PathVariable("product-image-id") @Positive Long productImageId) {

        productService.deleteProductImage(productImageId);
        return ResponseEntity.noContent().build();
    }


}
