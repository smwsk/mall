package com.smwsk.product.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rule_info", schema = "spring-cloud-mall", catalog = "")
public class RuleInfoEntity {
	private int tid;
	private String ruleCode;
	private String ruleName;
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
	@Column(name = "rule_code")
	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	@Basic
	@Column(name = "rule_name")
	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
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
		RuleInfoEntity that = (RuleInfoEntity) o;
		return tid == that.tid &&
				Objects.equals(ruleCode, that.ruleCode) &&
				Objects.equals(ruleName, that.ruleName) &&
				Objects.equals(createTime, that.createTime) &&
				Objects.equals(updateTime, that.updateTime);
	}

	@Override
	public int hashCode() {

		return Objects.hash(tid, ruleCode, ruleName, createTime, updateTime);
	}
}
