package com.project.shopping_mall.domain.product.mapper;


import com.project.shopping_mall.domain.product.dto.ProductDto;
import com.project.shopping_mall.domain.product.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productDtoToProduct(ProductDto.Post productDto);

    Product productPatchDtoToProduct(ProductDto.Patch productPatchDto);

    ProductDto.Response productToProductResponse(Product product);


    List<ProductDto.Response> productsToProductResponse(List<Product> product);


    ProductDto.PatchResponse productToProductPatchDto(Product product);

}
