package com.smwsk.product.repository;

import com.smwsk.product.ProductApplicationTest;
import com.smwsk.product.dataobject.ProductInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ProductInfoRepositoryTest extends ProductApplicationTest {

	@Autowired
	ProductInfoRepository productInfoRepository;

	@Test
	public void findByProductStatus() {
		List<ProductInfoEntity> all = productInfoRepository.findAll();
		log.info("长度" + all.size());
	}
}