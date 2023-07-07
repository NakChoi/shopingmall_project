package com.project.shopping_mall.domain.product.service;


import com.project.shopping_mall.domain.product.entity.Category;
import com.project.shopping_mall.domain.product.entity.ProductCategory;
import com.project.shopping_mall.domain.product.repository.CategoryRepository;
import com.project.shopping_mall.domain.product.repository.ProductCategoryRepository;
import com.project.shopping_mall.exception.CustomException;
import com.project.shopping_mall.exception.ExceptionCode;
import com.project.shopping_mall.utils.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    final private CategoryRepository categoryRepository;
    final private CustomBeanUtils customBeanUtils;

    final private ProductCategoryRepository productCategoryRepository;

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


    public Page<ProductCategory> getProductCategory(Long id, int page, int size){

        Page<ProductCategory> productCategoryPage = productCategoryRepository.findByCategory_CategoryId(id , PageRequest.of(page-1, size, Sort.by("createdAt").ascending()) );

        return productCategoryPage;
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
