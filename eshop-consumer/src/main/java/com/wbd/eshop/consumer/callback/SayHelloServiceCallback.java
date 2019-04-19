package com.wbd.eshop.consumer.callback;

import com.wbd.eshop.consumer.service.SayHelloService;

public class SayHelloServiceCallback implements SayHelloService {

	@Override
	public String sayHello(String name) {
		
		return "hystrix......error"+name;
	}

}
