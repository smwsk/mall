package com.smwsk.mall.user.service;

import com.smwsk.mall.user.entity.AdminRoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAdminRoleService {
	Page listPageInfo(Pageable pageable);

	List<AdminRoleEntity> listEntityInfos();

	AdminRoleEntity getEntityInfoById(Integer id);

	void updateEntityInfo(AdminRoleEntity adminRoleEntity);

	void deleteEntityInfo(Integer id);

}
