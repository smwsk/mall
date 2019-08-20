package com.smwsk.mall.order.controller;

import com.smwsk.product.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ClientController {

	@Autowired
	private ProductClient productClient;

	@RequestMapping(value = "/getProductMsg")
	public String getProductMsg(){
		String msg = productClient.getMsg();
		log.info("receive msg:{}",msg);
		return msg;
	}
}
