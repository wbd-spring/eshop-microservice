package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.ProductPropertyMapper;
import com.wbd.eshop.product.model.ProductProperty;
import com.wbd.eshop.product.mq.RabbitMQSender;
import com.wbd.eshop.product.mq.RabbitQueue;
import com.wbd.eshop.product.service.ProductPropertyService;
@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {
	
	@Autowired
	private ProductPropertyMapper productPropertyMapper;
	
	@Autowired
	private RabbitMQSender  mq;

	public void addProductProperty(ProductProperty productProperty) {

		productPropertyMapper.add(productProperty);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\",\"data_type\":\"product-property\",\"id\":"+productProperty.getId()+"}");

	}

	public void updateProductProperty(ProductProperty productProperty) {

		productPropertyMapper.update(productProperty);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"update\",\"data_type\":\"product-property\",\"id\":"+productProperty.getId()+"}");

	}

	public void removeProductPropertyById(Integer id) {

		productPropertyMapper.deleteProductPropertyById(id);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"delete\",\"data_type\":\"product-property\",\"id\":"+id+"}");

	}

	public ProductProperty getProductPropertyById(Integer id) {
		return productPropertyMapper.getProductPropertyById(id);
	}

}
