package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.ProductSpecificationMapper;
import com.wbd.eshop.product.model.ProductSpecification;
import com.wbd.eshop.product.mq.RabbitMQSender;
import com.wbd.eshop.product.mq.RabbitQueue;
import com.wbd.eshop.product.service.ProductSpecificationService;

@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

	@Autowired
	private ProductSpecificationMapper  productSpecificationMapper ;
	
	@Autowired
	private RabbitMQSender  mq;
	
	public void addProductSpecification(ProductSpecification productSpecification) {

		productSpecificationMapper.add(productSpecification);
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\",\"data_type\":\"product-specification\",\"id\":"+productSpecification.getId()+", \"product_id\": "+productSpecification.getProductId()+"}");

	}

	public void updateProductSpecification(ProductSpecification productSpecification) {

		productSpecificationMapper.update(productSpecification);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"update\",\"data_type\":\"product-specification\",\"id\":"+productSpecification.getId()+", \"product_id\": "+productSpecification.getProductId()+"}");

	}

	public void removeProductSpecificationById(Integer id) {

		productSpecificationMapper.deleteProductSpecificationById(id);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"delete\",\"data_type\":\"product-specification\",\"id\":"+id+", \"product_id\": "+getProductSpecificationById(id).getProductId()+"}");

	}

	public ProductSpecification getProductSpecificationById(Integer id) {
		return productSpecificationMapper.getProductSpecificationById(id);
	}

}
