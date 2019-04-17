package com.wbd.eshop.product.service;

import com.wbd.eshop.product.model.ProductSpecification;

public interface ProductSpecificationService {

	public void addProductSpecification(ProductSpecification productSpecification);

	public void updateProductSpecification(ProductSpecification productSpecification);

	public void removeProductSpecificationById(Integer id);

	public ProductSpecification getProductSpecificationById(Integer id);
}
