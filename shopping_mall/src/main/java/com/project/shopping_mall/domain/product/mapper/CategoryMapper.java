package com.project.shopping_mall.domain.product.mapper;


import com.project.shopping_mall.domain.product.dto.CategoryDto;
import com.project.shopping_mall.domain.product.dto.ProductCategoryDto;
import com.project.shopping_mall.domain.product.entity.Category;
import com.project.shopping_mall.domain.product.entity.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Category Dto

    Category categoryDtoToCategory(CategoryDto.Post dto);

    Category categoryPatchDtoToCategory(CategoryDto.Patch dto);

    CategoryDto.Response categoryToCategoryResponseDto(Category category);


    // Product Category Dto

    @Mapping(source = "category", target = "category.categoryId")
    @Mapping(source = "product", target = "product.productId")
    ProductCategory productCategoryDtoToProductCategory(ProductCategoryDto.Post dto);

    ProductCategory productCategoryPatchDtoToProductCategory(ProductCategoryDto.Patch dto);


    @Mapping(source = "category.categoryId", target = "category")
    @Mapping(source = "product.productId", target = "product")
    ProductCategoryDto.Response productCategoryToProductCategoryDto(ProductCategory productCategory);

    List<ProductCategoryDto.Response> categoryProductsToCategoryProductDto(List<ProductCategory> productCategoryList);
}
