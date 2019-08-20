package com.smwsk.mall.apigateway.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * 跨域
 * @author wangshaokui
 */
@Configuration
public class CorsConfig{

	@Bean
	public CorsFilter corsFilter(){

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);/*设置是否支持cookie跨域*/
		configuration.setAllowedOrigins(Arrays.asList("*"));/*设置原始域 http://www.a.com*/
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setMaxAge(300l);//设置缓存时间
		source.registerCorsConfiguration("/**",configuration);
		return new CorsFilter();
	}



}
