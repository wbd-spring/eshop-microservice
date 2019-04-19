package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.ProductIntroMapper;
import com.wbd.eshop.product.model.ProductIntro;
import com.wbd.eshop.product.mq.RabbitMQSender;
import com.wbd.eshop.product.mq.RabbitQueue;
import com.wbd.eshop.product.service.ProductIntroService;

@Service
public class ProductIntroServiceImpl implements ProductIntroService {

	@Autowired
	private ProductIntroMapper  productIntroMapper;
	
	@Autowired
	private RabbitMQSender  mq;
	
	public void addProductIntro(ProductIntro productIntro) {
		productIntroMapper.add(productIntro);
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\",\"data_type\":\"product-intro\",\"id\":"+productIntro.getId()+", \"product_id\": "+productIntro.getProductId()+"}");

	}

	public void updateProductIntro(ProductIntro productIntro) {

		productIntroMapper.update(productIntro);
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"update\",\"data_type\":\"product-intro\",\"id\":"+productIntro.getId()+", \"product_id\": "+productIntro.getProductId()+"}");

	}

	public void removeProductIntroById(Integer id) {

		productIntroMapper.deleteProductIntroById(id);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"delete\",\"data_type\":\"product-intro\",\"id\":"+id+", \"product_id\": "+getProductIntroById(id).getProductId()+"}");

	}

	public ProductIntro getProductIntroById(Integer id) {
		return productIntroMapper.getProductIntroById(id);
	}

}
