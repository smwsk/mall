package com.smwsk.product.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "product_category", schema = "spring-cloud-mall", catalog = "")
public class ProductCategoryEntity {
	@Id
	private int tid;
	private String categoryName;
	private Integer categoryCode;
	private Integer parentId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer indexId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductCategoryEntity that = (ProductCategoryEntity) o;
		return tid == that.tid &&
				Objects.equals(categoryName, that.categoryName) &&
				Objects.equals(categoryCode, that.categoryCode) &&
				Objects.equals(parentId, that.parentId) &&
				Objects.equals(createTime, that.createTime) &&
				Objects.equals(updateTime, that.updateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tid, categoryName, categoryCode, parentId, createTime, updateTime);
	}
}
