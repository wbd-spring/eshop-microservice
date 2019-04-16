package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.CategoryMapper;
import com.wbd.eshop.product.model.Category;
import com.wbd.eshop.product.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	public void addCategory(Category category) {

		categoryMapper.add(category);
	}

	public void updateCategory(Category category) {

		categoryMapper.update(category);
	}

	public void removeCategoryById(Integer id) {

		categoryMapper.deleteCategoryById(id);
	}

	public Category getCategoryById(Integer id) {
		return categoryMapper.findCategoryById(id);
	}

}
