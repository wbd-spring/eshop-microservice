package com.wbd.eshop.price.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.wbd.eshop.price.mapper.ProductPriceMapper;
import com.wbd.eshop.price.model.ProductPrice;
import com.wbd.eshop.price.service.ProductPriceService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Service
public class ProductPriceServiceImpl implements ProductPriceService{

	@Autowired
	private ProductPriceMapper productPriceMapper;
	
	@Autowired
	private JedisPool jedisPool;
	
	public void addProductPrice(ProductPrice productPrice) {
		
		productPriceMapper.add(productPrice);
		

		Jedis jedis = jedisPool.getResource();
		jedis.set("product_price_id"+productPrice.getProductId(), JSONObject.toJSONString(productPrice));
	}

	public void updateProductPrice(ProductPrice productPrice) {
		
		productPriceMapper.update(productPrice);
		
		Jedis jedis = jedisPool.getResource();
		jedis.set("product_price_id"+productPrice.getProductId(), JSONObject.toJSONString(productPrice));

		
	}

	public void removeProductPriceById(Integer id) {
		
		productPriceMapper.deleteProductPriceById(id);
		
		Jedis jedis = jedisPool.getResource();
		jedis.del("product_price_id"+getProductPriceById(id).getProductId());

		
	}

	public ProductPrice getProductPriceById(Integer id) {
		return productPriceMapper.selectProductPriceById(id);
	}

}
