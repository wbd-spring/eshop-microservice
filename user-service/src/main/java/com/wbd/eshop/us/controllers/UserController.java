package com.wbd.eshop.us.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbd.eshop.us.model.User;
import com.wbd.eshop.us.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/getAllUser")
	public List<User> getAllUser(){
		return userService.selectAllUser();
	}
}
