package com.smwsk.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启feign通讯
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class);
	}

}
