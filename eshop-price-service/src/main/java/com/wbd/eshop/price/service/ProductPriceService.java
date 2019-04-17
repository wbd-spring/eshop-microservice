package com.wbd.eshop.price.service;

import com.wbd.eshop.price.model.ProductPrice;

public interface ProductPriceService {

     public void addProductPrice(ProductPrice productPrice);
	
	public void updateProductPrice(ProductPrice productPrice);
	
	public void removeProductPriceById(Integer id);
	
	public ProductPrice getProductPriceById(Integer id);
}
