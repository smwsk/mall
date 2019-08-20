package com.smwsk.product.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "category_rule", schema = "spring-cloud-mall", catalog = "")
public class CategoryRuleEntity {
	private int tid;
	private Integer categoryId;
	private Integer ruleId;
	private Integer parentId;
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
	@Column(name = "category_id")
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Basic
	@Column(name = "rule_id")
	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	@Basic
	@Column(name = "parent_id")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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
		CategoryRuleEntity that = (CategoryRuleEntity) o;
		return tid == that.tid &&
				Objects.equals(categoryId, that.categoryId) &&
				Objects.equals(ruleId, that.ruleId) &&
				Objects.equals(parentId, that.parentId) &&
				Objects.equals(createTime, that.createTime) &&
				Objects.equals(updateTime, that.updateTime);
	}

	@Override
	public int hashCode() {

		return Objects.hash(tid, categoryId, ruleId, parentId, createTime, updateTime);
	}
}
