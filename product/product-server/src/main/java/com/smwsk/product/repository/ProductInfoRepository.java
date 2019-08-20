package com.smwsk.product.repository;

import com.smwsk.product.dataobject.ProductInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wangshaokui
 * @date 2019/06/18
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfoEntity,String> {

	List<ProductInfoEntity> findByProductStatus(Integer productStatus);


}
