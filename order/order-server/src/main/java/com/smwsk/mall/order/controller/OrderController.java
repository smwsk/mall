package com.smwsk.mall.order.controller;

import com.smwsk.mall.order.utils.ResultVoUtil;
import com.smwsk.mall.order.vo.ResultVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping
@RefreshScope
public class OrderController extends BaseController{
	@Value("${env}")
	private String env;

	@RequestMapping(value = "/print")
	@ResponseBody
	public ResultVo print(){
		return ResultVoUtil.success(env);
	}


}
