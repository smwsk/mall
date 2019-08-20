package com.smwsk.mall.order.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	SUCCESS_MESSAGE(1000,"操作成功"),
	FAIL_MESSAGE(1001,"操作失败")
	;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	private Integer code;
	private String message;
}
