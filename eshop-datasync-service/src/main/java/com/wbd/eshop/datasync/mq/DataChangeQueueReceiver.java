package com.wbd.eshop.datasync.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.wbd.eshop.datasync.feign.service.ProductService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 数据同步服务，就是获取各种原子数据的变更消息
 * 
 * （1）然后通过spring cloud fegion调用eshop-product-service服务的各种接口， 获取数据
 * （2）将原子数据在redis中进行增删改 （3）将维度数据变化消息写入rabbitmq中另外一个queue，供数据聚合服务来消费
 * 
 * @author Administrator
 */
@Component
@RabbitListener(queues = "data-change-queue")
public class DataChangeQueueReceiver {

	@Autowired
	private ProductService ps;

	@Autowired
	private JedisPool jedisPool;

	@Autowired
	private RabbitMQSender sender;

	@RabbitHandler
	public void process(String message) {

		// mq.send(RabbitQueue.DATA_CHANGE_QUEUE,
		// "{\"event_type\":\"add\",\"data_type\":\"product-property\",\"id\":"+productProperty.getId()+",
		// \"product_id\": "+productProperty.getProductId()+"}");

		// mq sender的消息message进行解析
		JSONObject jsonObject = JSONObject.parseObject(message);
		// 获取data_type
		String dataType = jsonObject.getString("data_type");
		if (dataType.equals("brand")) {
			processBrandDataChangeMesage(jsonObject);

		} else if (dataType.equals("category")) {
			processCategoryDataChangeMesage(jsonObject);

		} else if (dataType.equals("product")) {
			processProductDataChangeMesage(jsonObject);

		} else if (dataType.equals("product-property")) {
			processProductPropertyDataChangeMesage(jsonObject);

		} else if (dataType.equals("product-specification")) {
			processProductSpecificationDataChangeMesage(jsonObject);

		} else if (dataType.equals("product-intro")) {
			processProductIntroDataChangeMesage(jsonObject);

		}

	}

	private void processBrandDataChangeMesage(JSONObject jsonObject) {

		Integer id = jsonObject.getInteger("id");
		String eventType = jsonObject.getString("event_type");
		Jedis jedis = jedisPool.getResource();
		if (eventType.equals("add") || eventType.equals("update")) {
			jedis.set("brand_" + id, ps.findBrandById(id));
		} else if (eventType.equals("delete")) {
			jedis.del("brand_" + id);
		}

		sender.send("aggr-data-change-queue", "{\"dim_type\":\"brand\",\"id\":" + id + "}");

	}

	private void processCategoryDataChangeMesage(JSONObject jsonObject) {
		Integer id = jsonObject.getInteger("id");
		String eventType = jsonObject.getString("event_type");
		Jedis jedis = jedisPool.getResource();
		if (eventType.equals("add") || eventType.equals("update")) {
			jedis.set("category_" + id, ps.findCategoryById(id));
		} else if (eventType.equals("delete")) {
			jedis.del("category_" + id);
		}

		sender.send("aggr-data-change-queue", "{\"dim_type\":\"category\",\"id\":" + id + "}");

	}

	private void processProductDataChangeMesage(JSONObject jsonObject) {

		Integer id = jsonObject.getInteger("id");
		String eventType = jsonObject.getString("event_type");
		Jedis jedis = jedisPool.getResource();
		if (eventType.equals("add") || eventType.equals("update")) {
			jedis.set("product_" + id, ps.findProductById(id));
		} else if (eventType.equals("delete")) {
			jedis.del("product_" + id);
		}

		sender.send("aggr-data-change-queue", "{\"dim_type\":\"product\",\"id\":" + id + "}");

	}

	private void processProductIntroDataChangeMesage(JSONObject jsonObject) {

		Integer id = jsonObject.getInteger("id");
		String eventType = jsonObject.getString("event_type");
		Jedis jedis = jedisPool.getResource();
		if (eventType.equals("add") || eventType.equals("update")) {
			jedis.set("product_intro_" + id, ps.findProductIntroById(id));
		} else if (eventType.equals("delete")) {
			jedis.del("product_intro_" + id);
		}

		sender.send("aggr-data-change-queue", "{\"dim_type\":\"product\",\"id\":" + id + "}");

	}

	private void processProductPropertyDataChangeMesage(JSONObject jsonObject) {

		Integer id = jsonObject.getInteger("id");
		String eventType = jsonObject.getString("event_type");
		Jedis jedis = jedisPool.getResource();
		if (eventType.equals("add") || eventType.equals("update")) {
			jedis.set("product_property_" + id, ps.findProductPropertyById(id));
		} else if (eventType.equals("delete")) {
			jedis.del("product_property_" + id);
		}

		sender.send("aggr-data-change-queue", "{\"dim_type\":\"product\",\"id\":" + id + "}");

	}

	private void processProductSpecificationDataChangeMesage(JSONObject jsonObject) {

		Integer id = jsonObject.getInteger("id");
		String eventType = jsonObject.getString("event_type");
		Jedis jedis = jedisPool.getResource();
		if (eventType.equals("add") || eventType.equals("update")) {
			jedis.set("product_specification_" + id, ps.findSpecificationById(id));
		} else if (eventType.equals("delete")) {
			jedis.del("product_specification_" + id);
		}
		sender.send("aggr-data-change-queue", "{\"dim_type\":\"product\",\"id\":" + id + "}");

	}

}
