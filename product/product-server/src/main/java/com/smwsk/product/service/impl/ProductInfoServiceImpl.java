package com.smwsk.product.service.impl;

import com.smwsk.product.dataobject.ProductInfoEntity;
import com.smwsk.product.enums.ProductStatusEnum;
import com.smwsk.product.repository.ProductInfoRepository;
import com.smwsk.product.service.IProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductInfoServiceImpl implements IProductInfoService {

	@Autowired
	ProductInfoRepository productInfoRepository;

	@Override
	public List<ProductInfoEntity> findUpAllProductInfo() {
		List<ProductInfoEntity> upAllProductInfo = productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
		return upAllProductInfo;
	}
}
