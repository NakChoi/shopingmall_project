package com.project.shopping_mall.domain.product.service;


import com.project.shopping_mall.domain.product.entity.Product;
import com.project.shopping_mall.domain.product.entity.ProductDetail;
import com.project.shopping_mall.domain.product.entity.ProductImage;
import com.project.shopping_mall.domain.product.entity.ProductSize;
import com.project.shopping_mall.domain.product.repository.ProductDetailRepository;
import com.project.shopping_mall.domain.product.repository.ProductImageRepository;
import com.project.shopping_mall.domain.product.repository.ProductRepository;
import com.project.shopping_mall.domain.product.repository.ProductSizeRepository;
import com.project.shopping_mall.exception.CustomException;
import com.project.shopping_mall.exception.ExceptionCode;
import com.project.shopping_mall.utils.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductDetailRepository  productDetailRepository;
    private final ProductSizeRepository productSizeRepository;

    private final ProductImageRepository productImageRepository;
    private final CustomBeanUtils customBeanUtils;

    public Product createProduct(Product product){

        verifyProductByName(product.getName());

        Product saveProduct = productRepository.save(product);

        return saveProduct;
    }

    public ProductDetail createProductDetail(ProductDetail productDetail){

        verifyProductById(productDetail.getProduct().getProductId());

        ProductDetail saveProductDetail = productDetailRepository.save(productDetail);

        return saveProductDetail;
    }

    public ProductSize createProductSize(ProductSize productSize){

        verifyProductById(productSize.getProduct().getProductId());

        ProductSize saveProductSize = productSizeRepository.save(productSize);

        return saveProductSize;
    }

    public ProductImage createProductImage(ProductImage productImage) {
        verifyProductById(productImage.getProduct().getProductId());

        ProductImage savedProductImage = productImageRepository.save(productImage);

        return savedProductImage;
    }

    public Product getProduct(Long productId){

        Product product = productRepository.findById(productId).orElseThrow(() -> new CustomException(ExceptionCode.PRODUCT_NOT_FOUND));

        return product;
    }

    @Transactional(readOnly = true)
    public List<ProductSize> getProductSize(Long productId){

        verifyProductById(productId);

        List<ProductSize> productSizeList = productSizeRepository.findByProduct_ProductId(productId);
        System.out.println("==========================================================");
        if(productSizeList.isEmpty()){
            throw new CustomException(ExceptionCode.PRODUCT_SIZE_NOT_FOUND);
        }

        return productSizeList;
    }

    public ProductImage getProductImage(Long productId) {
        verifyProductById(productId);


        // 가장 메인 사진 하나!(seq 1번)
        ProductImage productImage = productImageRepository.findByProduct_ProductIdAndSeq(productId, "1");

        return productImage;
    }

    public List<ProductImage> getProductImages(Long productId) {
        verifyProductById(productId);

        List<ProductImage> productImage = productImageRepository.findByProduct_ProductId(productId);

        if(productImage.isEmpty()){
            throw new CustomException(ExceptionCode.PRODUCT_IMAGE_NOT_FOUND);
        }

        return productImage;
    }

    public Product updateProduct(Product product) {

        Product verifiedProduct = verifyProductById(product.getProductId());

        customBeanUtils.copyNonNullProperties(product, verifiedProduct);
        /*Optional.ofNullable(product.getDescription()).ifPresent(description -> verifiedProduct.setDescription(product.getDescription()));
        Optional.ofNullable(product.getName()).ifPresent(name -> verifiedProduct.setName(product.getName()));
        Optional.ofNullable(product.getPrice()).ifPresent(description -> verifiedProduct.setPrice(product.getPrice()));
*/
        return verifiedProduct;
    }

    public ProductDetail updateProductDetail(ProductDetail productDetail){
        ProductDetail updateProductDetail = verifyProductDetailById(productDetail.getProductDetailId());

        customBeanUtils.copyNonNullProperties(productDetail, updateProductDetail);

        return updateProductDetail;
    }


    public ProductSize updateProductSize(ProductSize productSize){
        ProductSize updateProductSize = verifyProductSizeById(productSize.getProductSizeId());

        customBeanUtils.copyNonNullProperties(productSize, updateProductSize);

        return updateProductSize;
    }

    public ProductImage updateProductImage(ProductImage productImage) {
        ProductImage verifiedProductImage = verifyProductImageById(productImage.getProductImageId());

        customBeanUtils.copyNonNullProperties(productImage, verifiedProductImage);

        return verifiedProductImage;
    }

    public void deleteProduct(Long productId){
        Product product = verifyProductById(productId);

        productRepository.delete(product);
    }

    public void deleteProductSize(Long productSizeId) {
        ProductSize productSize = verifyProductSizeById(productSizeId);

        productSizeRepository.delete(productSize);
    }


    public void deleteProductDetail(Long productDetailId){
        ProductDetail productDetail = verifyProductDetailById(productDetailId);

        productDetailRepository.delete(productDetail);
    }

    public void deleteProductImage(Long productImageId) {
        ProductImage productImage = verifyProductImageById(productImageId);

        productImageRepository.delete(productImage);
    }


    private Product verifyProductById(Long id){

        Product verifiedProduct = productRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionCode.PRODUCT_NOT_FOUND));

        return verifiedProduct;
    }

    private void verifyProductByName(String name){

       if(productRepository.findByName(name).isPresent()){
            new CustomException(ExceptionCode.PRODUCT_NAME_EXIST);
        }
    }

    private ProductDetail verifyProductDetailById(Long id){
        return productDetailRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionCode.PRODUCT_DETAIL_NOT_FOUND));
    }

    private ProductSize verifyProductSizeById(Long id) {
        return productSizeRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionCode.PRODUCT_SIZE_NOT_FOUND));
    }

    private ProductImage verifyProductImageById(Long id) {
        return productImageRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionCode.PRODUCT_IMAGE_NOT_FOUND));
    }

}
