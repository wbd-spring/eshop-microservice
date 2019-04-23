package com.wbd.eshop.dataaggr.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
@RabbitListener(queues = "aggr-data-change-queue")
public class AggrDataChangeQueueReceiver {

	@Autowired
	private JedisPool jedisPool;

	// sender.send("aggr-data-change-queue", "{\"dim_type\":\"brand\",\"id\":" + id
	// + "}");

	@RabbitHandler
	public void processMessage(String message) {

		JSONObject jsonObject = JSONObject.parseObject(message);

		String dimType = jsonObject.getString("dim_type");

		if (dimType.equals("brand")) {
			processBrandData(jsonObject);

		} else if (dimType.equals("product")) {
			processProductData(jsonObject);
		} else if (dimType.equals("category")) {
			processCategoryData(jsonObject);
		} else if (dimType.equals("product_intro")) {
			processProductIntroData(jsonObject);
		}
	}

	private void processBrandData(JSONObject jsonObject) {
		Integer id = jsonObject.getInteger("id");
		Jedis jedis = jedisPool.getResource();
		jedis.set("dim_brand_"+id, jedis.get("brand_"+id));
	}

	private void processProductData(JSONObject jsonObject) {
		Integer id = jsonObject.getInteger("id");
		Jedis jedis = jedisPool.getResource();
		String projectJson = jedis.get("product_"+id);
		JSONObject json = JSONObject.parseObject(projectJson);
		String propertyJson = jedis.get("product_property_"+id);
		json.put("product_property_", propertyJson);
		
		String specificationJson = jedis.get("product_specification_"+id);
		
		json.put("product_specification_", specificationJson);
		
		jedis.set("dim_product_" + id, json.toJSONString());
		
	}
	
	private void processCategoryData(JSONObject jsonObject) {
		Integer id = jsonObject.getInteger("id");
		Jedis jedis = jedisPool.getResource();
		jedis.set("dim_category_"+id, jedis.get("category_"+id));
	}

	private void processProductIntroData(JSONObject jsonObject) {
		Integer id = jsonObject.getInteger("id");
		Jedis jedis = jedisPool.getResource();
		jedis.set("dim_product_intro_"+id, jedis.get("product_intro_"+id));
	}

}
