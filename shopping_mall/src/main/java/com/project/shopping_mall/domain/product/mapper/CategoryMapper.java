package com.project.shopping_mall.domain.product.mapper;


import com.project.shopping_mall.domain.product.dto.CategoryDto;
import com.project.shopping_mall.domain.product.dto.ProductCategoryDto;
import com.project.shopping_mall.domain.product.entity.Category;
import com.project.shopping_mall.domain.product.entity.ProductCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Category Dto

    Category categoryDtoToCategory(CategoryDto.Post dto);

    Category categoryPatchDtoToCategory(CategoryDto.Patch dto);

    CategoryDto.Response categoryToCategoryResponseDto(Category category);


    // Product Category Dto

    ProductCategory productCategoryDtoToProductCategory(ProductCategoryDto.Post dto);

    ProductCategory productCategoryPatchDtoToProductCategory(ProductCategoryDto.Patch dto);

    ProductCategoryDto.Response productCategoryToProductCategoryDto(ProductCategory productCategory);

    List<ProductCategoryDto.Response> categoryProductsToCategoryProductDto(List<ProductCategory> productCategoryList);
}
