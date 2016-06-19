package com.obc.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * <br>类名： XssHttpServletRequestWrapper 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:34:51 
 * @author FC
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
	 * <br>方法名： cleanXSS
	 * 
	 * <br>描述：【清除特殊字符】 
	 * <br>创建时间： 2016年5月31日 上午2:34:59 
	 * @param value
	 * @return
	 */
	private String cleanXSS ( String value ) {
		value = value.replaceAll("<", "＜").replaceAll(">", "＞");
		return value;
	}

}