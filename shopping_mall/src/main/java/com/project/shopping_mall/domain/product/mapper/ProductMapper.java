package com.project.shopping_mall.domain.product.mapper;


import com.project.shopping_mall.domain.product.dto.ProductDetailDto;
import com.project.shopping_mall.domain.product.dto.ProductDto;
import com.project.shopping_mall.domain.product.entity.Product;
import com.project.shopping_mall.domain.product.entity.ProductDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // Product Mapper
    Product productDtoToProduct(ProductDto.Post productDto);

    Product productPatchDtoToProduct(ProductDto.Patch productPatchDto);

    ProductDto.Response productToProductResponse(Product product);

    List<ProductDto.Response> productsToProductResponse(List<Product> product);

    ProductDto.PatchResponse productToProductPatchDto(Product product);


    // Product Detail Mapper
    @Mapping(source = "product", target = "product.productId")
    ProductDetail productDetailDtoToProductDetail(ProductDetailDto.Post productDetailDto);

    ProductDetail productDetailPatchDtoToProductDetail(ProductDetailDto.Patch productDetailPatchDto);

    @Mapping(source = "product.productId", target = "product")
    ProductDetailDto.Response productDetailToProductDetailPatchResponse(ProductDetail ProductDetail);

    ProductDetailDto.Response productDetailToProductDetailResponse(ProductDetailDto ProductDetail);

}
