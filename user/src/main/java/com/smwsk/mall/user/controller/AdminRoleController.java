package com.smwsk.mall.user.controller;

import com.smwsk.mall.common.utils.PageMsg;
import com.smwsk.mall.common.utils.RequestMsg;
import com.smwsk.mall.common.utils.RespMsg;
import com.smwsk.mall.user.entity.AdminRoleEntity;
import com.smwsk.mall.user.service.IAdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Wang Shao Kui
 * Create date: 2021/7/5 - 10:47
 * Description:
 */
@RestController
@RequestMapping(value = "adminRole")
public class AdminRoleController {

	@Autowired
	IAdminRoleService adminRoleService;

	/**
	 * 分页接口
	 * @param pageMsg
	 * @return
	 */
	@GetMapping(value = "listInfoPage")
	public RespMsg listProductPage(PageMsg pageMsg){
		Pageable pageable = PageRequest.of(pageMsg.getCurrentPage(),pageMsg.getPageSize());
		Page page = adminRoleService.listPageInfo(pageable);
		return RespMsg.success(pageMsg.msg(page));
	}

	/**
	 * 列表接口
	 * @return
	 */
	@GetMapping(value = "listInfos")
	public RespMsg listInfos(){
		List<AdminRoleEntity> adminRoleEntities = adminRoleService.listEntityInfos();
		return RespMsg.success(adminRoleEntities);
	}

	/**
	 * 根据ID获取信息
	 * @return
	 */
	@GetMapping(value = "getInfoById")
	public RespMsg getInfoById(@RequestBody RequestMsg requestMsg){
		AdminRoleEntity adminRoleEntity = adminRoleService.getEntityInfoById(requestMsg.getId());
		return RespMsg.success(adminRoleEntity);
	}

	/**
	 * 更新保存信息
	 * @param adminRoleEntity
	 * @return
	 */
	@PostMapping(value = "saveInfo")
	public RespMsg saveInfo(@RequestBody AdminRoleEntity adminRoleEntity){
		adminRoleService.updateEntityInfo(adminRoleEntity);
		return RespMsg.success();
	}

	/**
	 * 根据ID删除信息
	 * @return
	 */
	@GetMapping(value = "deleteById")
	public RespMsg deleteById(@RequestBody RequestMsg requestMsg){
		adminRoleService.deleteEntityInfo(requestMsg.getId());
		return RespMsg.success();
	}

}
