
package com.wbd.eshop.consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * spring boot 启动类
 * @author zhuguanghe
 *
 */
@EnableHystrixDashboard //开启hystrix dashboard 仪表盘
@EnableCircuitBreaker  //开启circuitbreaker
@EnableHystrix         //开启hystrix
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = { "com.wbd.eshop.consumer.service" })  //开启客户端访问服务的负载均衡功能
public class Applicaction {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Applicaction.class, args);
		
	}

}
