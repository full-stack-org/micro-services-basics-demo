package com.zuul.gate.way.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZuulGateWayFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		log.info("********* Should Filter Called **********");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
		log.info("Request is -> {} , Request uri -> {}", httpServletRequest, httpServletRequest.getRequestURI());

		return null;
	}

	@Override
	public String filterType() {
		log.info("**** Filter Type Called ********");
		return "pre";
	}

	@Override
	public int filterOrder() {
		log.info("********* Filter Order Called **********");
		return 1;
	}

}
