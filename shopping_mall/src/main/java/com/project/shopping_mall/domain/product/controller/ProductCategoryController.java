package com.project.shopping_mall.domain.product.controller;


import com.project.shopping_mall.domain.product.dto.ProductCategoryDto;
import com.project.shopping_mall.domain.product.dto.ProductDto;
import com.project.shopping_mall.domain.product.entity.Product;
import com.project.shopping_mall.domain.product.entity.ProductCategory;
import com.project.shopping_mall.domain.product.mapper.CategoryMapper;
import com.project.shopping_mall.domain.product.mapper.ProductMapper;
import com.project.shopping_mall.domain.product.service.CategoryService;
import com.project.shopping_mall.globalDto.MultiResponseDto;
import com.project.shopping_mall.globalDto.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
@RequestMapping("/product-category")
public class ProductCategoryController {

    final private CategoryMapper categoryMapper;
    final private ProductMapper productMapper;
    final private CategoryService categoryService;


    @PostMapping
    public ResponseEntity postProductCategory(@RequestBody ProductCategoryDto.Post productCategoryDto){

        ProductCategory productCategory = categoryMapper.productCategoryDtoToProductCategory(productCategoryDto);

        ProductCategory saveProductCategory = categoryService.createProductCategory(productCategory);

        return ResponseEntity.created(URI.create("/categories/"+ saveProductCategory.getCategory() + "/products/" + saveProductCategory.getProduct())).build();
    }

    @GetMapping("/{category-id}")
    public ResponseEntity getProductCategories(@PathVariable("category-id") @Positive Long id){

        List<Product> productCategoryPage = categoryService.getProductCategory(id);

        List<ProductDto.Response> response = productMapper.productsToProductResponse(productCategoryPage);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }


    @PatchMapping("/{product-category-id}")
    public ResponseEntity patchProductCategory(@PathVariable("product-category-id") @Positive Long productCategoryId,
                                               @RequestBody ProductCategoryDto.Patch dto){

        ProductCategory productCategory = categoryMapper.productCategoryPatchDtoToProductCategory(dto);
        productCategory.setProductCategoryId(productCategoryId);

        ProductCategory saveProductCategory = categoryService.updateProductCategory(productCategory);
        ProductCategoryDto.Response response = categoryMapper.productCategoryToProductCategoryDto(saveProductCategory);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @DeleteMapping("/{product-category-id}")
    public ResponseEntity deleteProductCategory(@PathVariable("product-category-id") @Positive Long productCategoryId){

        categoryService.deleteProductCategory(productCategoryId);
        return ResponseEntity.noContent().build();
    }
}
