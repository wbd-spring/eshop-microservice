package com.wbd.eshop.inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.wbd.eshop.inventory.mapper.ProductInventoryMapper;
import com.wbd.eshop.inventory.model.ProductInventory;
import com.wbd.eshop.inventory.service.ProductInventoryService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {
	
	@Autowired
	private ProductInventoryMapper productInventoryMapper;
	
	@Autowired
	private JedisPool jedisPool;

	public void addProductInventory(ProductInventory productInventory) {

		productInventoryMapper.add(productInventory);
		
		
		Jedis jedis = jedisPool.getResource();
		jedis.set("product_inventory_id"+productInventory.getProductId(), JSONObject.toJSONString(productInventory));
		
	}

	public void updateProductInventory(ProductInventory productInventory) {
		productInventoryMapper.update(productInventory);
		Jedis jedis = jedisPool.getResource();
		jedis.set("product_inventory_id"+productInventory.getProductId(), JSONObject.toJSONString(productInventory));
	}

	public void removeProductInventoryById(Integer id) {
		productInventoryMapper.deleteProductInventoryById(id);
		Jedis jedis = jedisPool.getResource();
		jedis.del("product_inventory_id"+getProductInventoryById(id).getProductId());
	}

	public ProductInventory getProductInventoryById(Integer id) {
		return productInventoryMapper.selectProductInventoryById(id);
	}

}
