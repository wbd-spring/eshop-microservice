package com.wbd.eshop.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * spring boot 启动类
 * @author zhuguanghe
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class Applicaction {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Applicaction.class, args);
		
	}

}
