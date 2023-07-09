package com.project.shopping_mall.domain.product.mapper;


import com.project.shopping_mall.domain.product.dto.ProductDto;
import com.project.shopping_mall.domain.product.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productDtoToProduct(ProductDto.Post productDto);

    Product productPatchDtoToProduct(ProductDto.Patch productPatchDto);

    ProductDto.Response productToProductResponse(Product product);

    ProductDto.PatchResponse productToProductPatchDto(Product product);

}
