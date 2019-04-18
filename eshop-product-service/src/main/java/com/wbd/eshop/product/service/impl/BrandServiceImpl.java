package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.BrandMapper;
import com.wbd.eshop.product.model.Brand;
import com.wbd.eshop.product.mq.RabbitMQSender;
import com.wbd.eshop.product.mq.RabbitQueue;
import com.wbd.eshop.product.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandMapper brandMapper;
	
	@Autowired
	private RabbitMQSender  mq;

	public void addBrand(Brand brand) {
		brandMapper.add(brand);
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\",\"data_type\":\"brand\",\"id\":"+brand.getId()+"}");
	}

	public void updateBrand(Brand brand) {

		brandMapper.update(brand);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"update\",\"data_type\":\"brand\",\"id\":"+brand.getId()+"}");
	}

	public void removeBrandById(Integer id) {

		brandMapper.deleteBrandById(id);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"delete\",\"date_type\":\"brand\",\"id\":"+id+"}");

	}

	public Brand getBrandById(Integer id) {
		return brandMapper.findBrandById(id);
	}

}
