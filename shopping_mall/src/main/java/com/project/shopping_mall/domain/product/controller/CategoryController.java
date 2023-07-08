package com.project.shopping_mall.domain.product.controller;


import com.project.shopping_mall.domain.product.dto.CategoryDto;
import com.project.shopping_mall.domain.product.dto.ProductCategoryDto;
import com.project.shopping_mall.domain.product.entity.Category;
import com.project.shopping_mall.domain.product.entity.ProductCategory;
import com.project.shopping_mall.domain.product.mapper.CategoryMapper;
import com.project.shopping_mall.domain.product.service.CategoryService;
import com.project.shopping_mall.globalDto.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    final private CategoryMapper categoryMapper;
    final private CategoryService categoryService;

    @PostMapping
    public ResponseEntity postCategory(@RequestBody CategoryDto.Post categoryDto){

        Category category = categoryMapper.categoryDtoToCategory(categoryDto);

        Category savedCategory = categoryService.createCategory(category);

        return ResponseEntity.created(URI.create("/category/"+ savedCategory.getCategoryId())).build();
    }

    @PatchMapping("/{category-id}")
    public ResponseEntity updateCategory(@PathVariable("category-id") @Positive Long categoryId,
                                          @RequestBody CategoryDto.Patch categoryDto){

        Category category = categoryMapper.categoryPatchDtoToCategory(categoryDto);
        category.setCategoryId(categoryId);

        Category updateCategory = categoryService.updateCategory(category);
        CategoryDto.Response response = categoryMapper.categoryToCategoryResponseDto(updateCategory);

        return new ResponseEntity(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @DeleteMapping("/{category-id}")
    public ResponseEntity deleteCategory(@PathVariable("category-id") @Positive Long categoryId){

        categoryService.deleteCategory(categoryId);

        return ResponseEntity.noContent().build();
    }



}
