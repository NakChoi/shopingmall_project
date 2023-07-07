package com.project.shopping_mall.domain.product.mapper;


import com.project.shopping_mall.domain.product.dto.CategoryDto;
import com.project.shopping_mall.domain.product.dto.ProductCategoryDto;
import com.project.shopping_mall.domain.product.entity.Category;
import com.project.shopping_mall.domain.product.entity.ProductCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryDtoToCategory(CategoryDto.Post dto);

    Category categoryPatchDtoToCategory(CategoryDto.Patch dto);

    CategoryDto.Response categoryToCategoryResponseDto(Category category);

    ProductCategoryDto.Response productCategoryToProductCategoryDto(ProductCategory productCategory);

    ProductCategory productCategoryDtoToProductCategory(ProductCategoryDto.Post dto);

    ProductCategory productCategoryPatchDtoToProductCategory(ProductCategoryDto.Patch dto);

    List<ProductCategoryDto.Response> categoryProductsToCategoryProductDto(List<ProductCategory> productCategoryList);
}
