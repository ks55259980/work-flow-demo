package com.haiyang.flowable.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class CorrelationFilter implements Filter {

//	private static final String CORRELATION_ID_HEADER_NAME = "X-Correlation-Id";
	private static final String CORRELATION_ID_LOG_VAR_NAME = "correlationId";
	private static final Logger logger = LoggerFactory.getLogger(CorrelationFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			logger.info("Request Info: {}", RequestUtil.requestInfo((HttpServletRequest) request));
			chain.doFilter(request, response);
		} finally {
			MDC.remove(CORRELATION_ID_LOG_VAR_NAME);
		}
	}

//	private String getCorrelationIdFromHeader(final HttpServletRequest request) {
//		String correlationId = request.getHeader(CORRELATION_ID_HEADER_NAME);
//		if (StringUtils.isEmpty(correlationId)) {
//			correlationId = generateUniqueCorrelationId();
//		}
//
//		return correlationId;
//	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
