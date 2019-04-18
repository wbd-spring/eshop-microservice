package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.ProductMapper;
import com.wbd.eshop.product.model.Product;
import com.wbd.eshop.product.mq.RabbitMQSender;
import com.wbd.eshop.product.mq.RabbitQueue;
import com.wbd.eshop.product.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private RabbitMQSender  mq;
	
	public void addProduct(Product product) {

		productMapper.add(product);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\",\"data_type\":\"product\",\"id\":"+product.getId()+"}");

	}

	public void updateProduct(Product product) {

		productMapper.update(product);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"update\",\"data_type\":\"product\",\"id\":"+product.getId()+"}");

	}

	public void removeProductById(Integer id) {

		productMapper.deleteProductById(id);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"delete\",\"data_type\":\"product\",\"id\":"+id+"}");

	}

	public Product getProductById(Integer id) {
		return productMapper.findProductById(id);
	}

}
