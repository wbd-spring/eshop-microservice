package com.wbd.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.product.mapper.CategoryMapper;
import com.wbd.eshop.product.model.Category;
import com.wbd.eshop.product.mq.RabbitMQSender;
import com.wbd.eshop.product.mq.RabbitQueue;
import com.wbd.eshop.product.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private RabbitMQSender  mq;
	
	public void addCategory(Category category) {

		categoryMapper.add(category);
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"add\",\"data_type\":\"category\",\"id\":"+category.getId()+"}");
	}

	public void updateCategory(Category category) {

		categoryMapper.update(category);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"update\",\"data_type\":\"category\",\"id\":"+category.getId()+"}");
	}

	public void removeCategoryById(Integer id) {

		categoryMapper.deleteCategoryById(id);
		
		mq.send(RabbitQueue.DATA_CHANGE_QUEUE, "{\"event_type\":\"delete\",\"data_type\":\"category\",\"id\":"+id+"}");

	}

	public Category getCategoryById(Integer id) {
		return categoryMapper.findCategoryById(id);
	}

}
