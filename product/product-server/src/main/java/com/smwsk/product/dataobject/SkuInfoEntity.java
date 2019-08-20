package com.smwsk.product.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sku_info", schema = "spring-cloud-mall", catalog = "")
public class SkuInfoEntity {
	private int tid;
	private String spuCode;
	private Double spuPrice;
	private Integer skuStock;
	private String productId;
	private Integer productCategoryId;
	private Integer ruleValueId;
	private Timestamp createTime;
	private Timestamp updateTime;

	@Id
	@Column(name = "tid")
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Basic
	@Column(name = "spu_code")
	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
	}

	@Basic
	@Column(name = "spu_price")
	public Double getSpuPrice() {
		return spuPrice;
	}

	public void setSpuPrice(Double spuPrice) {
		this.spuPrice = spuPrice;
	}

	@Basic
	@Column(name = "sku_stock")
	public Integer getSkuStock() {
		return skuStock;
	}

	public void setSkuStock(Integer skuStock) {
		this.skuStock = skuStock;
	}

	@Basic
	@Column(name = "product_id")
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Basic
	@Column(name = "product_category_id")
	public Integer getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	@Basic
	@Column(name = "rule_value_id")
	public Integer getRuleValueId() {
		return ruleValueId;
	}

	public void setRuleValueId(Integer ruleValueId) {
		this.ruleValueId = ruleValueId;
	}

	@Basic
	@Column(name = "create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Basic
	@Column(name = "update_time")
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SkuInfoEntity that = (SkuInfoEntity) o;
		return tid == that.tid &&
				Objects.equals(spuCode, that.spuCode) &&
				Objects.equals(spuPrice, that.spuPrice) &&
				Objects.equals(skuStock, that.skuStock) &&
				Objects.equals(productId, that.productId) &&
				Objects.equals(productCategoryId, that.productCategoryId) &&
				Objects.equals(ruleValueId, that.ruleValueId) &&
				Objects.equals(createTime, that.createTime) &&
				Objects.equals(updateTime, that.updateTime);
	}

	@Override
	public int hashCode() {

		return Objects.hash(tid, spuCode, spuPrice, skuStock, productId, productCategoryId, ruleValueId, createTime, updateTime);
	}
}
