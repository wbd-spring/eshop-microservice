package com.wbd.eshop.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbd.eshop.inventory.model.ProductInventory;
import com.wbd.eshop.inventory.service.ProductInventoryService;
@RestController
@RequestMapping("/product-inventory")
public class ProductInventoryContorller {

	@Autowired
	private ProductInventoryService pis;
	
	
	@RequestMapping("/add")
	public String add(ProductInventory ProductInventory) {
		try {

			pis.addProductInventory(ProductInventory);

		} catch (Exception e) {
			return "add ProductInventory failure";
		}

		return "add ProductInventory success";
	}

	@RequestMapping("/update")
	public String update(ProductInventory ProductInventory) {
		try {
			pis.updateProductInventory(ProductInventory);
		} catch (Exception e) {
			// TODO: handle exception
			return "update ProductInventory failure";
		}
		return "update ProductInventory success";
	}

	@RequestMapping("/delete")
	public String deleteProductInventoryById(Integer id) {

		try {
			pis.removeProductInventoryById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return "delete ProductInventory failure";
		}
		return "delete ProductInventory success";
	}
	
	@RequestMapping("/findById")
	public ProductInventory findProductInventoryById(Integer id) {
		return pis.getProductInventoryById(id);
	}
}
