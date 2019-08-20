package com.smwsk.product.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "product_image_info", schema = "spring-cloud-mall", catalog = "")
public class ProductImageInfoEntity {
	private int tid;
	private String imageUrl;
	private String productId;
	private Integer imageIndex;
	private Byte isMainImage;
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
	@Column(name = "image_url")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
	@Column(name = "image_index")
	public Integer getImageIndex() {
		return imageIndex;
	}

	public void setImageIndex(Integer imageIndex) {
		this.imageIndex = imageIndex;
	}

	@Basic
	@Column(name = "is_main_image")
	public Byte getIsMainImage() {
		return isMainImage;
	}

	public void setIsMainImage(Byte isMainImage) {
		this.isMainImage = isMainImage;
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
		ProductImageInfoEntity that = (ProductImageInfoEntity) o;
		return tid == that.tid &&
				Objects.equals(imageUrl, that.imageUrl) &&
				Objects.equals(productId, that.productId) &&
				Objects.equals(imageIndex, that.imageIndex) &&
				Objects.equals(isMainImage, that.isMainImage) &&
				Objects.equals(createTime, that.createTime) &&
				Objects.equals(updateTime, that.updateTime);
	}

	@Override
	public int hashCode() {

		return Objects.hash(tid, imageUrl, productId, imageIndex, isMainImage, createTime, updateTime);
	}
}
