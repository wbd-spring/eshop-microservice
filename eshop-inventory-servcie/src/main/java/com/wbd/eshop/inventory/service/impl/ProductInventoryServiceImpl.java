package com.wbd.eshop.inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.inventory.mapper.ProductInventoryMapper;
import com.wbd.eshop.inventory.model.ProductInventory;
import com.wbd.eshop.inventory.service.ProductInventoryService;
@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {
	
	@Autowired
	private ProductInventoryMapper productInventoryMapper;

	public void addProductInventory(ProductInventory productInventory) {

		productInventoryMapper.add(productInventory);
	}

	public void updateProductInventory(ProductInventory productInventory) {
		productInventoryMapper.update(productInventory);
	}

	public void removeProductInventoryById(Integer id) {
		productInventoryMapper.deleteProductInventoryById(id);
	}

	public ProductInventory getProductInventoryById(Integer id) {
		return productInventoryMapper.selectProductInventoryById(id);
	}

}
