package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.ProductIntroMapper;
import com.wbd.eshop.product.model.ProductIntro;
import com.wbd.eshop.product.service.ProductIntroService;

@Service
public class ProductIntroServiceImpl implements ProductIntroService {

	@Autowired
	private ProductIntroMapper  productIntroMapper;
	
	public void addProductIntro(ProductIntro productIntro) {
		productIntroMapper.add(productIntro);
	}

	public void updateProductIntro(ProductIntro productIntro) {

		productIntroMapper.update(productIntro);
	}

	public void removeProductIntroById(Integer id) {

		productIntroMapper.deleteProductIntroById(id);
	}

	public ProductIntro getProductIntroById(Integer id) {
		return productIntroMapper.getProductIntroById(id);
	}

}
