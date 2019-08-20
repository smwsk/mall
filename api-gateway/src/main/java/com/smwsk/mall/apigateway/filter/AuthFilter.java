package com.smwsk.mall.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 限权拦截(拦截买家和卖家)
 */
@Component
public class AuthFilter extends ZuulFilter {

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
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();

		return null;
	}
}
