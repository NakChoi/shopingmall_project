package com.project.shopping_mall.domain.product.mapper;


import com.project.shopping_mall.domain.product.dto.*;
import com.project.shopping_mall.domain.product.entity.*;
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

    // Product Size Mapper
    @Mapping(source = "product", target = "product.productId")
    ProductSize productSizeDtoToProductSize(ProductSizeDto.Post productSizeDto);

    @Mapping(source = "product", target = "product.productId")
    ProductSize productSizePatchDtoToProductSize(ProductSizeDto.Patch productSizeDto);

    @Mapping(source = "product.productId", target = "product")
    ProductSizeDto.Response productSizeToProductSizeResponseDto(ProductSize productSize);

    List<ProductSizeDto.Response> productSizesToProductSizeResponseDto(List<ProductSize> productSize);

    // Product Image Mapper
    @Mapping(source = "product", target = "product.productId")
    ProductImage productImageDtoToProductImage(ProductImageDto.Post productImageDto);

    @Mapping(source = "product", target = "product.productId")
    ProductImage productImagePatchDtoToProductImage(ProductImageDto.Patch productImagePatchDto);

    @Mapping(source = "product.productId", target = "product")
    ProductImageDto.Response productImageToProductImageResponseDto(ProductImage productImage);

    List<ProductImageDto.Response> productImagesToProductImageResponseDto(List<ProductImage> productImages);

    // Product Review Mapper
    @Mapping(source = "product", target = "product.productId")
    @Mapping(source = "member", target = "member.memberId")
    ProductReview productReviewDtoToProductReview(ProductReviewDto.Post ProductReviewDto);

    ProductReview productReviewPatchDtoToProductReview(ProductReviewDto.Patch ProductReviewPatchDto);


    ProductReviewDto.Response productReviewToProductReviewResponseDto(ProductReview productReview);

    List<ProductReviewDto.Response> productReviewsToProductReviewResponseDto(List<ProductReview> productReviews);

}
