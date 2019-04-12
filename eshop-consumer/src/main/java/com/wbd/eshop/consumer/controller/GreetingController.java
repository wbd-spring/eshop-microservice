package com.wbd.eshop.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbd.eshop.consumer.service.SayHelloService;

@RestController
public class GreetingController {

	// 注入 feign 声明的接口
	@Autowired
	private SayHelloService  ss;
	
	
	@RequestMapping("/greeting")
	public String testGreeting(String name) {
		return ss.sayHello(name);
	}
	
	@RequestMapping("/greeting2")
	public String testGreeting2(String name) {
		return "hello world========="+name;
	}
}
