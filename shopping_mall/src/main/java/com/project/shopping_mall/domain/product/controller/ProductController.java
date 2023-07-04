package com.project.shopping_mall.domain.product.controller;


import com.project.shopping_mall.domain.product.dto.ProductDto;
import com.project.shopping_mall.domain.product.entity.Product;
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
@RequestMapping("/products")
@Valid
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity postProduct(@Valid @RequestBody ProductDto.Post productDto) {

        Product product = productMapper.productDtoToProduct(productDto);

        Product createdProduct = productService.createProduct(product);

        return ResponseEntity.created(URI.create("/product"+ createdProduct)).build();
    }

    @GetMapping("/{product-id}")
    public ResponseEntity getProduct(@PathVariable("product-id") @Positive Long productId){

        Product product = productService.findProduct(productId);

        ProductDto.Response findProduct = productMapper.productToProductResponse(product);

        return new ResponseEntity<>(new SingleResponseDto<>(findProduct), HttpStatus.OK);
    }

    @PatchMapping("/{product-id}")
    public ResponseEntity patchProduct(@PathVariable("product-id") @Positive Long productId,
                                       @RequestBody ProductDto.Patch productPatchDto){

        Product product = productMapper.productPatchDtoToProduct(productPatchDto);
        product.setProductId(productId);

        Product updateProduct = productService.updateProduct(product);

        ProductDto.PatchResponse response = productMapper.productToProductPatchDto(updateProduct);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }


    @DeleteMapping("/{product-id}")
    public ResponseEntity deleteProduct(@PathVariable("product-id") @Positive Long productId) {

        productService.deleteProduct(productId);

        return ResponseEntity.ok().build();
    }

}
