package com.wbd.eshop.us.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.eshop.us.mapper.UserMapper;
import com.wbd.eshop.us.model.User;
import com.wbd.eshop.us.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> selectAllUser() {
		return userMapper.findAllUser();
	}

}
