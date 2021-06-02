package com.smwsk.product.vo;

import com.smwsk.product.dataobject.ProductInfoEntity;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Author: Wang Shao Kui
 * Create date: 2021/6/1 - 15:48
 * Description:
 */
@Data
@Entity
public class ProductVo extends ProductInfoEntity {

	private String imageUrl;

	private Boolean isMainImage;

}
