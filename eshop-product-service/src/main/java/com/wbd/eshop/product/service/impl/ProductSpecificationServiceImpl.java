package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.ProductSpecificationMapper;
import com.wbd.eshop.product.model.ProductSpecification;
import com.wbd.eshop.product.service.ProductSpecificationService;

@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

	@Autowired
	private ProductSpecificationMapper  productSpecificationMapper ;
	
	public void addProductSpecification(ProductSpecification productSpecification) {

		productSpecificationMapper.add(productSpecification);
	}

	public void updateProductSpecification(ProductSpecification productSpecification) {

		productSpecificationMapper.update(productSpecification);
	}

	public void removeProductSpecificationById(Integer id) {

		productSpecificationMapper.deleteProductSpecificationById(id);
	}

	public ProductSpecification getProductSpecificationById(Integer id) {
		return productSpecificationMapper.getProductSpecificationById(id);
	}

}
