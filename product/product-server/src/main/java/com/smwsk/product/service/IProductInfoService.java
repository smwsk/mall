package com.smwsk.product.service;

import com.smwsk.product.dataobject.ProductInfoEntity;

import java.util.List;

public interface IProductInfoService {

	List<ProductInfoEntity> findUpAllProductInfo();

}
