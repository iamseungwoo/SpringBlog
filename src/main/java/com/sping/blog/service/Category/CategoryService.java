package com.sping.blog.service.Category;

import com.sping.blog.dto.Category.CategoryDto;
import com.sping.blog.entity.Category;

import javax.transaction.Transactional;

@Transactional
public class CategoryService {
    public void createCategory(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());

    }
}
