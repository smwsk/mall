package com.smwsk.product.exception;

import com.smwsk.product.enums.ResultEnum;

public class ProductionException extends RuntimeException{

	private Integer code;
	private String message;

	public ProductionException(Integer code, String message){
		super(message);
		this.code = code;
	}

	public ProductionException(ResultEnum resultEnum){
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}

}
