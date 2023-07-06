package com.project.shopping_mall.domain.product.service;


import com.project.shopping_mall.domain.product.entity.Category;
import com.project.shopping_mall.domain.product.repository.CategoryRepository;
import com.project.shopping_mall.exception.CustomException;
import com.project.shopping_mall.exception.ExceptionCode;
import com.project.shopping_mall.utils.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    final private CategoryRepository categoryRepository;
    final private CustomBeanUtils customBeanUtils;

    public Category createPost(Category category){

        verifyCategoryName(category.getName());
        Category saveCategory = categoryRepository.save(category);

        return saveCategory;
    }

    public Category updateCategory(Category category){
        Category verifiedCategory = verifyCategoryId(category.getCategoryId());

        customBeanUtils.copyNonNullProperties(category, verifiedCategory);

        return verifiedCategory;
    }

    public void deleteCategory(Long id){
        Category category = verifyCategoryId(id);

        categoryRepository.delete(category);
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
}
