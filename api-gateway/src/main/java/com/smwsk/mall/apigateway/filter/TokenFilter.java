package com.smwsk.mall.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.smwsk.mall.apigateway.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * token检验
 */
@Component
public class TokenFilter extends ZuulFilter {

	@Autowired
	ApplicationConfig applicationConfig;

	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	/**
	 * 过滤值越小,执行优先级越高
	 * @return
	 */
	@Override
	public int filterOrder() {
		//减一，自定义的过滤器就会在PRE_DECORATION_FILTER_ORDER过滤器之前执行
		return PRE_DECORATION_FILTER_ORDER -1;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String requestURI = request.getRequestURI();
		for (String whiteUrl : applicationConfig.getWhiteList()) {
			if(whiteUrl.contains(requestURI)){
				return false;
			}
		}
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();

		// 从url参数里获取，也可以从cookie，header里获取
		String token = request.getParameter("token");
		if(StringUtils.isEmpty(token)){
			//token为空，限权校验不通过
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
		}
		return null;
	}
}
