package com.smwsk.mall.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.smwsk.mall.apigateway.exception.RateLimitException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * 令牌桶限流
 */
@Component
public class RateLimitFilter extends ZuulFilter {
	/**每秒100个令牌**/
	private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return SERVLET_DETECTION_FILTER_ORDER - 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		if(!RATE_LIMITER.tryAcquire()){
			throw new RateLimitException();
		}

		return null;
	}
}
