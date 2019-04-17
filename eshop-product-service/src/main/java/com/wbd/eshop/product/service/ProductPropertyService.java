package com.wbd.eshop.product.service;

import com.wbd.eshop.product.model.ProductProperty;

public interface ProductPropertyService {

	public void addProductProperty(ProductProperty productProperty);

	public void updateProductProperty(ProductProperty productProperty);

	public void removeProductPropertyById(Integer id);

	public ProductProperty getProductPropertyById(Integer id);
}
