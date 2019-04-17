package com.wbd.eshop.inventory.service;

import com.wbd.eshop.inventory.model.ProductInventory;

public interface ProductInventoryService {

	
	    public void addProductInventory(ProductInventory productInventory);
		
		public void updateProductInventory(ProductInventory productInventory);
		
		public void removeProductInventoryById(Integer id);
		
		public ProductInventory getProductInventoryById(Integer id);
}
