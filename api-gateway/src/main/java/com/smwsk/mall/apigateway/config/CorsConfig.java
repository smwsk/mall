package com.smwsk.mall.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 跨域
 * @author wangshaokui
 */
@Configuration
public class CorsConfig{

	@Bean
	public CorsFilter corsFilter(){

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);/*设置是否支持cookie跨域*/
		configuration.setAllowedOrigins(Arrays.asList("*"));/*设置原始域 http://www.a.com*/
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setMaxAge(18000L);//设置缓存时间
		source.registerCorsConfiguration("/**",configuration);
		return new CorsFilter(source);
	}



}
