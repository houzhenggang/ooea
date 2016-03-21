package com.obc.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * @ClassName: XssHttpServletRequestWrapper
 *
 * @author FC
 * @Description: TODO 【这里用一句话描述这个类的作用】
 * @date 2016年3月21日 下午5:48:35
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWrapper ( HttpServletRequest servletRequest ) {
		super(servletRequest);
	}

	@Override
	public String[] getParameterValues ( String parameter ) {
		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = cleanXSS(values[i]);
		}
		return encodedValues;
	}

	@Override
	public String getParameter ( String parameter ) {
		String value = super.getParameter(parameter);
		if (value == null) {
			return null;
		}
		return cleanXSS(value);
	}

	@Override
	public String getHeader ( String name ) {
		String value = super.getHeader(name);
		if (value == null)
			return null;
		return cleanXSS(value);
	}

	/**
	 * 
	 * @Title: cleanXSS
	 * 
	 * @author FC
	 * @Description: TODO 【清除特殊字符】
	 * @param value
	 * @return
	 * @date 2016年3月21日 下午5:49:08
	 */
	private String cleanXSS ( String value ) {
		value = value.replaceAll("<", "＜").replaceAll(">", "＞");
		return value;
	}

}