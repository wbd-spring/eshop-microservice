package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.BrandMapper;
import com.wbd.eshop.product.model.Brand;
import com.wbd.eshop.product.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandMapper brandMapper;

	public void addBrand(Brand brand) {
		brandMapper.add(brand);
	}

	public void updateBrand(Brand brand) {

		brandMapper.update(brand);
	}

	public void removeBrandById(Integer id) {

		brandMapper.deleteBrandById(id);
	}

	public Brand getBrandById(Integer id) {
		return brandMapper.findBrandById(id);
	}

}
