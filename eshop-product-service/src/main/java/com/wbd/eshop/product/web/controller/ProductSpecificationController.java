package com.wbd.eshop.product.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbd.eshop.product.model.ProductSpecification;
import com.wbd.eshop.product.service.ProductSpecificationService;

@RestController
@RequestMapping("/product-specification")
public class ProductSpecificationController {

	@Autowired
	private ProductSpecificationService pss;

	@RequestMapping("/add")
	public String add(ProductSpecification productSpecification) {
		try {

			pss.addProductSpecification(productSpecification);

		} catch (Exception e) {
			e.printStackTrace();
			return "add productSpecification failure";
		}

		return "add productSpecification success";
	}

	@RequestMapping("/update")
	public String update(ProductSpecification productSpecification) {
		try {
			pss.updateProductSpecification(productSpecification);
		} catch (Exception e) {
			return "update productSpecification failure";
		}
		return "update productSpecification success";
	}

	@RequestMapping("/delete")
	public String deleteProductSpecification(Integer id) {

		try {
			pss.removeProductSpecificationById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return "delete productSpecification failure";
		}
		return "delete productSpecification success";
	}
	
	@RequestMapping("/findById")
	public ProductSpecification findSpecificationById(Integer id) {
		return pss.getProductSpecificationById(id);
	}
}
