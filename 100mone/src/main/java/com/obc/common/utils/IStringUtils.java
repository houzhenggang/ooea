package com.obc.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.obc.common.constant.Canonical;
import com.obc.common.enumeration.Code;

/**
 * 
 * @ClassName: ObcStringUtils
 *
 * @author FC
 * @Description: TODO 【自定义StringUtils】
 * @date 2016年3月27日 下午6:58:36
 */
public class IStringUtils {

	/**
	 * 
	 * @Title: isValidate
	 * 
	 * @author FC
	 * @Description: TODO 【用户注册登录字符串验证】
	 * @param str
	 * @param validate
	 * @return
	 * @date 2016年3月27日 下午7:05:29
	 */
	public static Boolean isValidate (	String str ,
										Code validate ) {
		Boolean bool = false;
		switch (validate.getDesc()) {
		case "Pass":
			bool = str.matches(Canonical.Pass);
			break;
		case "Card":
			bool = str.matches(Canonical.Card);
			break;
		case "Email":
			bool = str.matches(Canonical.Email);
			break;
		case "Phone":
			bool = str.matches(Canonical.Phone);
			break;
		}
		return bool;
	}

	/**
	 * 
	 * @Title: getLog
	 * 
	 * @author FC
	 * @Description: TODO 【日志】
	 * @param str
	 * @return
	 * @date 2016年3月28日 下午6:04:58
	 */
	public static StringBuilder getLog ( String str ) {
		StringBuilder stringBuilder = new StringBuilder();
		Thread current = Thread.currentThread();
		// 格式化线程号，%#010X--转换成固定长度为10位的16进制，不够长度补0， 前两位固定为0X表示是16进制
		// 格式如：0X00000064
		String threadId = String.format("%#010X", current.getId());
		Subject subject = SecurityUtils.getSubject();
		stringBuilder.append("================================");
		stringBuilder.append("线程号：" + threadId);
		stringBuilder.append("用　户：" + subject);
		stringBuilder.append("================================");
		return stringBuilder;
	}

	/**
	 * 
	 * @Title: getIpAddress
	 * 
	 * @author FC
	 * @Description: TODO 【获得ip地址】
	 * @param request
	 * @return
	 * @date 2016年3月28日 下午6:07:24
	 */
	public static String getIpAddress ( HttpServletRequest request ) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
