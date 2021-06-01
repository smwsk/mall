package com.smwsk.product.service;

import com.smwsk.product.dataobject.ProductInfoEntity;
import com.smwsk.product.vo.ProductVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductInfoService {

	Page<ProductVo> listProductPage(Pageable pageable);

	List<ProductInfoEntity> findUpAllProductInfo();

}
