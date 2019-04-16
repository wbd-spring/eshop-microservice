package com.wbd.eshop.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {

	//获取配置文件中的 服务端口号
	@Value("${server.port}")
	private String port;
	
	
	@RequestMapping("/say")
	@HystrixCommand(fallbackMethod = "sayHelloFallback")
	public String sayHello(String name) {
		
		return "name=="+name+"\t"+"port=="+port;
	}
	
	
	public String sayHelloFallback(String name) {
		return "HystrixCommand...error"+name;
		
	}
}
