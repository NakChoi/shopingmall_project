package com.project.shopping_mall.domain.product.service;


import com.project.shopping_mall.domain.product.entity.Category;
import com.project.shopping_mall.domain.product.entity.Product;
import com.project.shopping_mall.domain.product.entity.ProductCategory;
import com.project.shopping_mall.domain.product.repository.CategoryRepository;
import com.project.shopping_mall.domain.product.repository.ProductCategoryRepository;
import com.project.shopping_mall.domain.product.repository.ProductRepository;
import com.project.shopping_mall.exception.CustomException;
import com.project.shopping_mall.exception.ExceptionCode;
import com.project.shopping_mall.utils.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    final private CategoryRepository categoryRepository;
    final private CustomBeanUtils customBeanUtils;

    final private ProductCategoryRepository productCategoryRepository;
    final private ProductRepository productRepository;

    public Category createCategory(Category category){

        verifyCategoryName(category.getName());
        Category saveCategory = categoryRepository.save(category);

        return saveCategory;
    }

    public ProductCategory createProductCategory(ProductCategory productCategory){


         ProductCategory saveProductCategory = productCategoryRepository.save(productCategory);

        return saveProductCategory;
    }


    public Category updateCategory(Category category){
        Category verifiedCategory = verifyCategoryId(category.getCategoryId());

        customBeanUtils.copyNonNullProperties(category, verifiedCategory);

        return verifiedCategory;
    }


    public List<Product> getProductCategory(Long id){

        List<ProductCategory> productCategoryList = productCategoryRepository.findByCategory_CategoryId(id);

        if(productCategoryList.isEmpty()){
            throw new CustomException(ExceptionCode.PRODUCT_NOT_FOUND);
        }

        List<Product> products = new ArrayList<>();

        System.out.println("=====================================================");
        System.out.println("=====================================================");
        System.out.println("=====================================================");

        for(ProductCategory productCategory : productCategoryList){
            Product product = productCategory.getProduct();
            products.add(product);
        }

        return products;
    }

    public ProductCategory updateProductCategory(ProductCategory productCategory){
        ProductCategory verifiedCategory = verifyProductCategoryId(productCategory.getProductCategoryId());

        customBeanUtils.copyNonNullProperties(productCategory, verifiedCategory);

        return verifiedCategory;
    }

    public void deleteCategory(Long id){
        Category category = verifyCategoryId(id);

        categoryRepository.delete(category);
    }

    public void deleteProductCategory(Long id){
        ProductCategory productCategory = verifyProductCategoryId(id);

        productCategoryRepository.delete(productCategory);
    }

    private void verifyCategoryName(String name){
        if(categoryRepository.findByName(name).isPresent()){
            new CustomException(ExceptionCode.CATEGORY_NAME_EXIST);
        }
    }

    private Category verifyCategoryId(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionCode.CATEGORY_NOT_EXIST));

        return category;
    }

    private ProductCategory verifyProductCategoryId(Long id) {

        ProductCategory productCategory = productCategoryRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionCode.CATEGORY_NOT_EXIST));

        return productCategory;
    }
}
