package com.project.shopping_mall.domain.product.mapper;


import com.project.shopping_mall.domain.product.dto.CategoryDto;
import com.project.shopping_mall.domain.product.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryDtoToCategory(CategoryDto.Post dto);

    Category categoryPatchDtoToCategory(CategoryDto.Patch dto);

    CategoryDto.Response categoryToCategoryResponseDto(Category category);
}
