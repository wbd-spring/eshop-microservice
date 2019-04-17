package com.wbd.eshop.product.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbd.eshop.product.model.Product;
import com.wbd.eshop.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	
	@RequestMapping("/add")
	public String add(Product product) {
		try {

			ps.addProduct(product);

		} catch (Exception e) {
			return "add Product failure";
		}

		return "add Product success";
	}

	@RequestMapping("/update")
	public String update(Product product) {
		try {
			ps.updateProduct(product);
		} catch (Exception e) {
			// TODO: handle exception
			return "update Product failure";
		}
		return "update Product success";
	}

	@RequestMapping("/delete")
	public String deleteProductById(Integer id) {

		try {
			ps.removeProductById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return "delete Product failure";
		}
		return "delete Product success";
	}
	
	@RequestMapping("/findById")
	public Product findProductById(Integer id) {
		return ps.getProductById(id);
	}

}
