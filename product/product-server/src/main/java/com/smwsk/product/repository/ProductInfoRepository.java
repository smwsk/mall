package com.smwsk.product.repository;

import com.smwsk.product.dataobject.ProductInfoEntity;
import com.smwsk.product.vo.ProductVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author wangshaokui
 * @date 2019/06/18
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfoEntity,String> {

	List<ProductInfoEntity> findByProductStatus(Integer productStatus);


	@Query(nativeQuery=true, value="select * from product_info p left join product_image_info pi on p.product_id = pi.product_id and pi.is_main_image = 1")
	Page<ProductVo> findProductVoPage(Pageable pageable);

}
