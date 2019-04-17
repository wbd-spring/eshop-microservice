package com.wbd.eshop.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbd.eshop.price.model.ProductPrice;
import com.wbd.eshop.price.service.ProductPriceService;

@RestController
@RequestMapping("/product-price")
public class ProductPriceController {
	
	@Autowired
	private ProductPriceService pps;
	
	
	@RequestMapping("/add")
	public String add(ProductPrice productPrice) {
		try {

			pps.addProductPrice(productPrice);

		} catch (Exception e) {
			return "add productPrice failure";
		}

		return "add productPrice success";
	}

	@RequestMapping("/update")
	public String update(ProductPrice productPrice) {
		try {
			pps.updateProductPrice(productPrice);
		} catch (Exception e) {
			// TODO: handle exception
			return "update productPrice failure";
		}
		return "update productPrice success";
	}

	@RequestMapping("/delete")
	public String deleteProductPriceById(Integer id) {

		try {
			pps.removeProductPriceById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return "delete productPrice failure";
		}
		return "delete productPrice success";
	}
	
	@RequestMapping("/findById")
	public ProductPrice findProductPriceById(Integer id) {
		return pps.getProductPriceById(id);
	}

}
