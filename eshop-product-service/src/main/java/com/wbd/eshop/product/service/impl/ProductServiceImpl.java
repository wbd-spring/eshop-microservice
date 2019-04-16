package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.ProductMapper;
import com.wbd.eshop.product.model.Product;
import com.wbd.eshop.product.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	
	public void addProduct(Product product) {

		productMapper.add(product);
	}

	public void updateProduct(Product product) {

		productMapper.update(product);
	}

	public void removeProductById(Integer id) {

		productMapper.deleteProductById(id);
	}

	public Product getProductById(Integer id) {
		return productMapper.findProductById(id);
	}

}
