package com.wbd.eshop.product.service;

import com.wbd.eshop.product.model.ProductIntro;

public interface ProductIntroService {

     public void addProductIntro(ProductIntro productIntro);
	
	public void updateProductIntro(ProductIntro productIntro);
	
	public void removeProductIntroById(Integer id);
	
	public ProductIntro getProductIntroById(Integer id);
}
