package com.wbd.eshop.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wbd.eshop.consumer.callback.SayHelloServiceCallback;

/**
 * 声明feign接口，调用服务提供者的方法
 * @author zhuguanghe
 *
 */
@FeignClient(value = "eureka-client",fallback=SayHelloServiceCallback.class)
public interface SayHelloService {

	//这里其实去调用服务提供者的方法
	@RequestMapping(value="/say",method= RequestMethod.GET)
	public String sayHello(@RequestParam("name") String name);
}
