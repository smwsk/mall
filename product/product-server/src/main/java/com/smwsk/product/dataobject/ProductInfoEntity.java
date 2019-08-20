package com.smwsk.product.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "product_info", schema = "spring-cloud-mall", catalog = "")
public class ProductInfoEntity {
	@Id
	private String tid;
	private String productName;
	private Integer productStock;
	private String productDescription;
	private String productIcon;
	private Integer productStatus;
	private Integer productType;
	private Timestamp createTime;
	private Timestamp updateTime;
}
