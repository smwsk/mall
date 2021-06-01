package com.smwsk.mall.apigateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

@Component
public class ZuulConfig {

	@ConfigurationProperties("zull")
	@RefreshScope
	public ZuulProperties zuulProperties(){
		return new ZuulProperties();
	}

}
