package com.wbd.eshop.product.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbd.eshop.product.model.ProductProperty;
import com.wbd.eshop.product.service.ProductPropertyService;

@RestController
@RequestMapping("/product-property")
public class ProductPropertyController {

	@Autowired
	private ProductPropertyService pps;

	@RequestMapping("/add")
	public String add(ProductProperty productProperty) {
		try {

			pps.addProductProperty(productProperty);

		} catch (Exception e) {
			return "add productProperty failure";
		}

		return "add productProperty success";
	}

	@RequestMapping("/update")
	public String update(ProductProperty productProperty) {
		try {
			pps.updateProductProperty(productProperty);
		} catch (Exception e) {
			return "update productProperty failure";
		}
		return "update productProperty success";
	}

	@RequestMapping("/delete")
	public String deleteProductProperty(Integer id) {

		try {
			pps.removeProductPropertyById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return "delete productProperty failure";
		}
		return "delete productProperty success";
	}
	
	@RequestMapping("/findById")
	public ProductProperty findProductPropertyById(Integer id) {
		return pps.getProductPropertyById(id);
	}
}
