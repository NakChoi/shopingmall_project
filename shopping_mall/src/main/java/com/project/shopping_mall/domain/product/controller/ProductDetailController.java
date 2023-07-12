package com.project.shopping_mall.domain.product.controller;


import com.project.shopping_mall.domain.product.dto.ProductDetailDto;
import com.project.shopping_mall.domain.product.entity.ProductDetail;
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

@RestController
@Valid
@RequestMapping("/products/details")
@RequiredArgsConstructor
public class ProductDetailController {

    private final ProductMapper productMapper;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity postProductDetail(@RequestBody ProductDetailDto.Post dto){

        ProductDetail productDetail = productMapper.productDetailDtoToProductDetail(dto);

        ProductDetail saveProductDetail = productService.createProductDetail(productDetail);

        return ResponseEntity.created(URI.create("/product-detail/"+ saveProductDetail.getProductDetailId())).build();
    }

    @PatchMapping("{product-detail-id}")
    public ResponseEntity patchProductDetail(@RequestBody ProductDetailDto.Patch productDetailDto,
                                             @PathVariable("product-detail-id") Long productDetailId){

        ProductDetail productDetail = productMapper.productDetailPatchDtoToProductDetail(productDetailDto);
        productDetail.setProductDetailId(productDetailId);

        ProductDetail updateProductDetail = productService.updateProductDetail(productDetail);

        ProductDetailDto.Response response = productMapper.productDetailToProductDetailPatchResponse(updateProductDetail);

        return new ResponseEntity(new SingleResponseDto<>(response) , HttpStatus.OK);
    }

    @DeleteMapping("{product-detail-id}")
    public ResponseEntity deleteProductDetail(@PathVariable @Positive Long productDetailId){

        productService.deleteProduct(productDetailId);

        return ResponseEntity.noContent().build();
    }


}
