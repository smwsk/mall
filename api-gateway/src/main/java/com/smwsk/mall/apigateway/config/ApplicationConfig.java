package com.smwsk.mall.apigateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Author: Wang Shao Kui
 * Create date: 2021/6/2 - 14:46
 * Description:
 */
@Configuration
@ConfigurationProperties("config")
public class ApplicationConfig {
	private List<String> whiteList;

	public List<String> getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(List<String> whiteList) {
		this.whiteList = whiteList;
	}
}
