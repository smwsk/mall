package com.smwsk.mall.user.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Author: Wang Shao Kui
 * Create date: 2021/7/5 - 10:41
 * Description:
 */
@Entity
@Table(name = "admin_role")
@Data
public class AdminRoleEntity {
	@Id
	private int adminRoleId;
	private String adminRoleName;
	private String remark;
	private Timestamp createTime;
	private Timestamp updateTime;
}
