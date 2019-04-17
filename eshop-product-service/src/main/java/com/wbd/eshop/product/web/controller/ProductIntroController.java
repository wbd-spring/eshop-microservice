package com.wbd.eshop.product.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbd.eshop.product.model.ProductIntro;
import com.wbd.eshop.product.service.ProductIntroService;

@RestController
@RequestMapping("/product-intro")
public class ProductIntroController {

	@Autowired
	private ProductIntroService pis;

	@RequestMapping("/add")
	public String add(ProductIntro productIntro) {
		try {

			pis.addProductIntro(productIntro);

		} catch (Exception e) {
			return "add productIntro failure";
		}

		return "add productIntro success";
	}

	@RequestMapping("/update")
	public String update(ProductIntro productIntro) {
		try {
			pis.updateProductIntro(productIntro);
		} catch (Exception e) {
			return "update productIntro failure";
		}
		return "update productIntro success";
	}

	@RequestMapping("/delete")
	public String deleteProductIntro(Integer id) {

		try {
			pis.removeProductIntroById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return "delete productIntro failure";
		}
		return "delete productIntro success";
	}
	
	@RequestMapping("/findById")
	public ProductIntro findProductIntroById(Integer id) {
		return pis.getProductIntroById(id);
	}
}
