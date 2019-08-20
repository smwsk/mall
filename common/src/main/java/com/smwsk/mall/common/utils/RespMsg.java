package com.smwsk.mall.common.utils;

import com.smwsk.mall.common.enums.RespMsgEnum;
import lombok.Data;

@Data
public class RespMsg<T> {

	private Integer code;

	private String message;

	private T data;

	public static RespMsg success(){
		RespMsg respMsg =  new RespMsg();
		respMsg.setCode(RespMsgEnum.SUCCESS.getCode());
		respMsg.setMessage(RespMsgEnum.SUCCESS.getMessage());
		return respMsg;
	}
	public static RespMsg success(Object data){
		RespMsg respMsg =  new RespMsg();
		respMsg.setCode(RespMsgEnum.SUCCESS.getCode());
		respMsg.setMessage(RespMsgEnum.SUCCESS.getMessage());
		respMsg.setData(data);
		return respMsg;
	}

	public static RespMsg fail(){
		RespMsg respMsg =  new RespMsg();
		respMsg.setCode(RespMsgEnum.FAIL.getCode());
		respMsg.setMessage(RespMsgEnum.FAIL.getMessage());
		return respMsg;
	}

	public static RespMsg fail(String message){
		RespMsg respMsg =  new RespMsg();
		respMsg.setCode(RespMsgEnum.FAIL.getCode());
		respMsg.setMessage(message);
		return respMsg;
	}

}
