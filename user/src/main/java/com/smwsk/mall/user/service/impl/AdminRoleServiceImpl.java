package com.smwsk.mall.user.service.impl;

import com.smwsk.mall.user.entity.AdminRoleEntity;
import com.smwsk.mall.user.repository.AdminRoleRepository;
import com.smwsk.mall.user.service.IAdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Wang Shao Kui
 * Create date: 2021/7/5 - 11:01
 * Description:
 */
@Service
public class AdminRoleServiceImpl implements IAdminRoleService {

	@Autowired
	AdminRoleRepository adminRoleRepository;

	public List<AdminRoleEntity> adminRoleEntityList(){
		return adminRoleRepository.findAll();
	}


	@Override
	public Page listPageInfo(Pageable pageable) {
		Page<AdminRoleEntity> entityPage = adminRoleRepository.findAll(pageable);
		return entityPage;
	}

	@Override
	public List<AdminRoleEntity> listEntityInfos() {
		return adminRoleRepository.findAll();
	}

	@Override
	public AdminRoleEntity getEntityInfoById(Integer id) {
		return adminRoleRepository.getOne(id);
	}

	@Override
	public void updateEntityInfo(AdminRoleEntity adminRoleEntity) {
		adminRoleRepository.save(adminRoleEntity);
	}

	@Override
	public void deleteEntityInfo(Integer id) {
		adminRoleRepository.deleteById(id);
	}

}
