package com.smwsk.product.client;

import com.smwsk.mall.common.product.output.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(name = "product")
public interface ProductClient {

	@GetMapping(value = "/msg")
	String getMsg();

	@PostMapping(value = "/product/listForOrder")
	List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

}
