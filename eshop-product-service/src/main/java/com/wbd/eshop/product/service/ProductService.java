package com.wbd.eshop.product.service;

import com.wbd.eshop.product.model.Product;

public interface ProductService {

	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void removeProductById(Integer id);
	
	public Product getProductById(Integer id);
}
