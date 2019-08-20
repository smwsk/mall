package com.smwsk.product.controller;

import com.smwsk.mall.common.utils.RespMsg;
import com.smwsk.product.service.IProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/productInfo/")
public class ProductInfoController {

	@Autowired
	IProductInfoService productInfoService;


	@ResponseBody
	@RequestMapping(value = "/findUpAllProductInfo")
	public RespMsg findUpAllProductInfo(){
		return RespMsg.success(productInfoService.findUpAllProductInfo());
	}

}
