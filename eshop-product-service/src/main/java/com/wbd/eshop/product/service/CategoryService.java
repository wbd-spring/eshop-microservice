package com.wbd.eshop.product.service;

import com.wbd.eshop.product.model.Category;

public interface CategoryService {

	  public void addCategory(Category category);
	  
	  public  void updateCategory(Category category);
	  
	  public void removeCategoryById(Integer id);
	  
	  public Category getCategoryById(Integer id);
	  
}
