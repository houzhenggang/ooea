package com.obc.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.obc.common.constant.Canonical;
import com.obc.common.enumeration.Code;

/**
 * 
 * <br>类名： IStringUtils 
 *
 * <br>公司名称： 【自定义StringUtils】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:35:50 
 * @author FC
 */
public class MoneStringUtils extends StringUtils {

	/**
	 * 
	 * <br>方法名： isValidate
	 * 
	 * <br>描述：【用户注册登录字符串验证】 
	 * <br>创建时间： 2016年5月31日 上午2:37:49 
	 * @param str
	 * @param validate
	 * @return
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
	 * <br>方法名： getLog
	 * 
	 * <br>描述：【日志】 
	 * <br>创建时间： 2016年5月31日 上午2:38:03 
	 * @param str
	 * @return
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
	 * <br>方法名： getIpAddress
	 * 
	 * <br>描述：【获得ip地址】 
	 * <br>创建时间： 2016年5月31日 上午2:38:17 
	 * @param request
	 * @return
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
	 * <br>方法名： replaceK
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:38:26 
	 * @param str
	 * @return
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
	 * <br>方法名： replaceV
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:38:31 
	 * @param str
	 * @return
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
