
package com.wbd.eshop.consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * spring boot 启动类
 * @author zhuguanghe
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients  //开启客户端访问服务的负载均衡功能
public class Applicaction {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Applicaction.class, args);
		
	}

}
