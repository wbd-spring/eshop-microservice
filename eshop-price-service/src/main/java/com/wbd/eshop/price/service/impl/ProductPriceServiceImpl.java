package com.wbd.eshop.price.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.price.mapper.ProductPriceMapper;
import com.wbd.eshop.price.model.ProductPrice;
import com.wbd.eshop.price.service.ProductPriceService;
@Service
public class ProductPriceServiceImpl implements ProductPriceService{

	@Autowired
	private ProductPriceMapper productPriceMapper;
	
	public void addProductPrice(ProductPrice productPrice) {
		
		productPriceMapper.add(productPrice);
	}

	public void updateProductPrice(ProductPrice productPrice) {
		
		productPriceMapper.update(productPrice);
		
	}

	public void removeProductPriceById(Integer id) {
		
		productPriceMapper.deleteProductPriceById(id);
		
	}

	public ProductPrice getProductPriceById(Integer id) {
		return productPriceMapper.selectProductPriceById(id);
	}

}
