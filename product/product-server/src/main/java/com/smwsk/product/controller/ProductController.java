package com.smwsk.product.controller;

import com.smwsk.mall.common.utils.PageMsg;
import com.smwsk.mall.common.utils.RespMsg;
import com.smwsk.product.dataobject.ProductInfoEntity;
import com.smwsk.product.service.IProductInfoService;
import com.smwsk.product.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {

	@Autowired
	IProductInfoService productInfoService;


	@GetMapping(value = "listProductPage")
	public PageMsg listProductPage(PageMsg pageMsg){
		Pageable pageable = PageRequest.of(pageMsg.getCurrentPage(),pageMsg.getPageSize());
		Page<ProductVo> entityPage = productInfoService.listProductPage(pageable);
		return pageMsg.msg(entityPage);
	}

	@GetMapping(value = "/findUpAllProductInfo")
	public RespMsg findUpAllProductInfo(){
		return RespMsg.success(productInfoService.findUpAllProductInfo());
	}

}
