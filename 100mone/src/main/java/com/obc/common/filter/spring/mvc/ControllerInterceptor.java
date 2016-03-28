package com.obc.common.filter.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.obc.common.utils.IStringUtils;

/**
 * 
 * @ClassName: ControllerInterceptor
 *
 * @author FC
 * @Description: TODO 【 SpringMVC 中的Interceptor 拦截请求是通过HandlerInterceptor来实现的。
 *               在SpringMVC中定义一个Interceptor非常简单，主要有两种方式，
 * 
 *               第一种方式是要定义的Interceptor类要实现了Spring的HandlerInterceptor接口，
 *               或者是这个类继承实现了HandlerInterceptor接口的类， 比如Spring
 *               已经提供的实现了HandlerInterceptor接口的抽象类HandlerInterceptorAdapter；
 * 
 *               第二种方式是实现Spring的WebRequestInterceptor接口，
 *               或者是继承实现了WebRequestInterceptor的类。】
 * @date 2016年3月28日 下午6:12:44
 */
public class ControllerInterceptor implements HandlerInterceptor {

	private static Logger log = Logger.getLogger(ControllerInterceptor.class);

	/**
	 * 将在整个请求结束之后
	 */
	@Override
	public void afterCompletion (	HttpServletRequest arg0 ,
									HttpServletResponse arg1 ,
									Object arg2 ,
									Exception arg3 ) throws Exception {

	}

	/**
	 * 将在当前请求进行处理之后
	 */
	@Override
	public void postHandle (	HttpServletRequest arg0 ,
								HttpServletResponse arg1 ,
								Object arg2 ,
								ModelAndView arg3 ) throws Exception {

	}

	/**
	 * 将在请求处理之前进行调用
	 */
	@Override
	public boolean preHandle (	HttpServletRequest arg0 ,
								HttpServletResponse arg1 ,
								Object arg2 ) throws Exception {
		String servletPath = arg0.getServletPath();
		if (servletPath.toLowerCase().matches(".*?(\\.do)$")) {
			StringBuilder logInfo = IStringUtils.getLog("start@");
			logInfo.append("请求：" + servletPath + ";");
			logInfo.append("IP：" + IStringUtils.getIpAddress(arg0) + ";");
			log.info(logInfo.toString());
		}
		return true;
	}

}
