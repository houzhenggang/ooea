package com.obc.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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

	/**
	 * 
	 * @Title: codeReplaceVK
	 * 
	 * @author FC
	 * @Description: TODO 【这里用一句话描述这个方法的作用】
	 * @param str
	 * @return
	 * @date 2016年3月29日 下午7:33:37
	 */
	public static String replaceK ( String str ) {
		StringBuffer buffer = new StringBuffer();
		String codes[] = str.split("");
		for (int i = 0; i < codes.length; i++) {
			String code = codes[i];
			if (code.matches(Canonical.codeRegex)) {
				code = Canonical.cvk.get(code);
			}
			buffer.append(code);
		}
		return buffer.toString();
	}

	/**
	 * 
	 * @Title: codeReplaceKV
	 * 
	 * @author FC
	 * @Description: TODO 【这里用一句话描述这个方法的作用】
	 * @param str
	 * @return
	 * @date 2016年3月29日 下午7:33:41
	 */
	public static String replaceV ( String str ) {
		StringBuffer buffer = new StringBuffer();
		String codes[] = str.split("");
		for (int i = 0; i < codes.length; i++) {
			String code = codes[i];
			if (code.matches(Canonical.codeRegex)) {
				code = Canonical.ckv.get(code);
			}
			buffer.append(code);
		}
		return buffer.toString();
	}

	/**
	 * 
	 * @Title: log
	 * 
	 * @author FC
	 * @Description: TODO 【异常休息输出格式】
	 * @param e
	 * @return
	 * @date 2016年3月29日 下午8:33:57
	 */
	public static void log (	Exception e ,
								Class<?> clazz ) {
		Logger log = Logger.getLogger(clazz);
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(e.getMessage());
		builder.append("]");
		log.info(builder.toString());
	}

	/**
	 * 
	 * @Title: log
	 * 
	 * @author FC
	 * @Description: TODO 【这里用一句话描述这个方法的作用】 
	 * @param str
	 * @param clazz 
	 * @date 2016年3月30日 下午5:59:20
	 */
	public static void log (	String str ,
								Class<?> clazz ) {
		Logger log = Logger.getLogger(clazz);
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(str);
		builder.append("]");
		log.info(builder.toString());
	}
}
