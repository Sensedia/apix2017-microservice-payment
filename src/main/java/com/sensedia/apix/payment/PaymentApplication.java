package com.sensedia.apix.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.sensedia.apix.payment.entity.ApiClientKeys;

import io.swagger.client.api.OrderManagementApi;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.sensedia")
public class PaymentApplication {
	
	@Bean
	public ApiClientKeys apiClientKeys() {
		return new ApiClientKeys();
	}
	
	@Bean
	public OrderManagementApi orderManagementApi() {
		return new OrderManagementApi();
	}
	
	@Bean
	public TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(100);
		scheduler.setThreadNamePrefix("payment-consumer-");
		return scheduler;
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}
}
