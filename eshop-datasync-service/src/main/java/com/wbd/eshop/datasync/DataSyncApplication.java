package com.wbd.eshop.datasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DataSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataSyncApplication.class, args);

	}
	
	/**
	 *  声明bean
	 *   jedis pool 
	 * @return
	 */
	@Bean
	public JedisPool jedis() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000 * 100);
		config.setTestOnBorrow(true);
		return new JedisPool(config, "118.190.71.215", 6379);
	}

}
