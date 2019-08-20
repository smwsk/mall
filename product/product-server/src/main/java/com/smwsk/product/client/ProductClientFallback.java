package com.smwsk.product.client;

import com.smwsk.mall.common.product.output.ProductInfoOutput;

import java.util.List;

public class ProductClientFallback implements ProductClient{
	@Override
	public String getMsg() {
		return "this is product service msg";
	}

	@Override
	public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
		return null;
	}
}