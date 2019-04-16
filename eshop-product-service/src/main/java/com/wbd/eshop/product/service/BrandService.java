package com.wbd.eshop.product.service;

import com.wbd.eshop.product.model.Brand;

public interface BrandService {


	public void addBrand(Brand brand);
	
	public void updateBrand(Brand brand);
	
	public void removeBrandById(Integer id);
	
	public Brand getBrandById(Integer id);
}
