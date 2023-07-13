package com.project.shopping_mall.domain.product.service;


import com.project.shopping_mall.domain.product.entity.Product;
import com.project.shopping_mall.domain.product.entity.ProductDetail;
import com.project.shopping_mall.domain.product.entity.ProductSize;
import com.project.shopping_mall.domain.product.repository.ProductDetailRepository;
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

    public Product findProduct (Long productId){

        Product product = productRepository.findById(productId).orElseThrow(() -> new CustomException(ExceptionCode.PRODUCT_NOT_FOUND));

        return product;
    }

    @Transactional(readOnly = true)
    public List<ProductSize> findProductSize(Long productId){

        verifyProductById(productId);

        List<ProductSize> productSizeList = productSizeRepository.findByProduct_ProductId(productId);
        System.out.println("==========================================================");
        if(productSizeList.isEmpty()){
            throw new CustomException(ExceptionCode.PRODUCT_SIZE_NOT_FOUND);
        }

        return productSizeList;
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
}
