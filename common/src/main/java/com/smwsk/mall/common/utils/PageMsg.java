package com.smwsk.mall.common.utils;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Author: Wang Shao Kui
 * Create date: 2021/6/1 - 11:45
 * Description:
 */
@Data
public class PageMsg<T> {
	/**
	 * 当前页数
	 */
	private int currentPage = 1;

	/**
	 * 当前数量
	 */
	private int pageSize = 10;

	private int totalPage = 1;

	/**
	 * 总数量
	 */
	private long totalNumber;

	/**
	 * 消息内容
	 */
	private List<T> data;

	public PageMsg<T> msg(Page<T> entityPage){
		List<T> content = entityPage.getContent();
		this.setData(content);
		this.setTotalPage(entityPage.getTotalPages());
		this.setTotalNumber(entityPage.getTotalElements());
		return this;
	}


	public int getCurrentPage(){
		return Math.abs(this.currentPage - 1);
	}
}
