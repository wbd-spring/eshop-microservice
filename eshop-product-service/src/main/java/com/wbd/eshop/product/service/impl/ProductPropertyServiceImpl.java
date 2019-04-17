package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.ProductPropertyMapper;
import com.wbd.eshop.product.model.ProductProperty;
import com.wbd.eshop.product.service.ProductPropertyService;
@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {
	
	@Autowired
	private ProductPropertyMapper productPropertyMapper;

	public void addProductProperty(ProductProperty productProperty) {

		productPropertyMapper.add(productProperty);
	}

	public void updateProductProperty(ProductProperty productProperty) {

		productPropertyMapper.update(productProperty);
	}

	public void removeProductPropertyById(Integer id) {

		productPropertyMapper.deleteProductPropertyById(id);
	}

	public ProductProperty getProductPropertyById(Integer id) {
		return productPropertyMapper.getProductPropertyById(id);
	}

}
