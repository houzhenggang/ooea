package com.obc.common.filter.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.obc.common.utils.MoneStringUtils;

/**
 * 
 * <br>类名： ControllerInterceptor 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:23:04 
 * @author FC
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
			StringBuilder logInfo = MoneStringUtils.getLog("start@");
			logInfo.append("请求：" + servletPath + ";");
			logInfo.append("IP：" + MoneStringUtils.getIpAddress(arg0) + ";");
			log.info(logInfo.toString());
		}
		return true;
	}

}
