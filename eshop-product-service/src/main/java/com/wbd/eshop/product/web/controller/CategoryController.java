package com.wbd.eshop.product.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbd.eshop.product.model.Category;
import com.wbd.eshop.product.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService cs;
	
	@RequestMapping("/add")
	public String addCategory(Category category) {
		
		try {
			cs.addCategory(category);
		} catch (Exception e) {
			return "add category error";
		}
		
		return "success";
	}
	
	@RequestMapping("/update")
	public String updateCategory(Category category) {
		
		try {
			cs.updateCategory(category);
		} catch (Exception e) {
			return "update category error";
		}
		
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteCategoryById(Integer id) {
		
		try {
			cs.removeCategoryById(id);
		} catch (Exception e) {
			return "remove category error";
		}
		
		return "success";
	}
	
	@RequestMapping("/findById")
	public Category findCategoryById(Integer id) {
		
		try {
			return cs.getCategoryById(id);
		} catch (Exception e) {
		}
		
		return new Category();
	}
	

}
