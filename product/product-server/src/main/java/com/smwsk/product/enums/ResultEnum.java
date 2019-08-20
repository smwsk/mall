package com.smwsk.product.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	PRODUCT_NOT_EXIST(1,"库存不存在"),
	PRODUCT_STOCK_ERROR(2,"库存有误")
	;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	private Integer code;
	private String message;
}
