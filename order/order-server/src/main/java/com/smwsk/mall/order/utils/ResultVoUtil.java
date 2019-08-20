package com.smwsk.mall.order.utils;

import com.smwsk.mall.order.enums.ResultEnum;
import com.smwsk.mall.order.vo.ResultVo;

/**
 * 返回结果工具类
 */
public class ResultVoUtil {

	public static ResultVo success() {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(ResultEnum.SUCCESS_MESSAGE.getCode());
		resultVo.setMsg(ResultEnum.SUCCESS_MESSAGE.getMessage());
		resultVo.setData(null);
		return resultVo;
	}

	public static ResultVo success(Object data) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(ResultEnum.SUCCESS_MESSAGE.getCode());
		resultVo.setMsg(ResultEnum.SUCCESS_MESSAGE.getMessage());
		resultVo.setData(data);
		return resultVo;
	}

	public static ResultVo success(ResultEnum resultEnum, Object data) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(resultEnum.getCode());
		resultVo.setMsg(resultEnum.getMessage());
		resultVo.setData(data);
		return resultVo;
	}

	public static ResultVo fail() {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(ResultEnum.FAIL_MESSAGE.getCode());
		resultVo.setMsg(ResultEnum.FAIL_MESSAGE.getMessage());
		resultVo.setData(null);
		return resultVo;
	}

	public static ResultVo fail(String message) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(ResultEnum.FAIL_MESSAGE.getCode());
		resultVo.setMsg(message);
		resultVo.setData(null);
		return resultVo;
	}

	public static ResultVo fail(ResultEnum resultEnum) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(resultEnum.getCode());
		resultVo.setMsg(resultEnum.getMessage());
		resultVo.setData(null);
		return resultVo;
	}

}
