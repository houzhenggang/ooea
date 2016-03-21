package com.obc.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

/**
 * 
 * @ClassName: DisableUrlSessionFilter
 *
 * @author FC
 * @Description: TODO 【这里用一句话描述这个类的作用】
 * @date 2016年3月21日 下午5:48:10
 */
public class DisableUrlSessionFilter implements Filter {

	public void init ( FilterConfig config ) throws ServletException {
	}

	public void doFilter (	ServletRequest request ,
							ServletResponse response ,
							FilterChain chain )	throws IOException ,
												ServletException {
		// skip non-http requests
		if (!(request instanceof HttpServletRequest)) {
			chain.doFilter(request, response);
			return;
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// clear session if session id in URL
		if (httpRequest.isRequestedSessionIdFromURL()) {
			HttpSession session = httpRequest.getSession();
			if (session != null)
				session.invalidate();
		}
		// wrap response to remove URL encoding
		HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpResponse) {
			@Override
			public String encodeRedirectUrl ( String url ) {
				return url;
			}

			public String encodeRedirectURL ( String url ) {
				return url;
			}

			public String encodeUrl ( String url ) {
				return url;
			}

			public String encodeURL ( String url ) {
				return url;
			}
		};
		// process next request in chain
		chain.doFilter(request, wrappedResponse);
	}

	public void destroy ( ) {
	}
}