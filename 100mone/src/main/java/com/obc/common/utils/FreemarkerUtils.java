package com.obc.common.utils;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.obc.common.constant.Canonical;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 * <br>类名： FreemarkerUtils 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:39:33 
 * @author FC
 */
public class FreemarkerUtils {

	/**
	 * 
	 * <br>方法名： getFreeMarkerCFG
	 * 
	 * <br>描述：【获取freemarker的配置】 
	 * <br>创建时间： 2016年5月31日 上午2:38:55 
	 * @return
	 */
	private static Configuration getFreeMarkerCFG ( ) {
		Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		configuration.setClassForTemplateLoading(FreemarkerUtils.class, "/");
		configuration.setDefaultEncoding("UTF-8");
		return configuration;
	}

	/**
	 * 
	 * <br>方法名： genStrFormTemplate
	 * 
	 * <br>描述：【输出模板信息】 
	 * <br>创建时间： 2016年5月31日 上午2:39:06 
	 * @param templateFileName 模板名称
	 * @param values 模板需要替换内容
	 * @return
	 */
	public static String genStrFormTemplate (	String templateFileName ,
												Object values ) {
		String retValue;
		try {
			Template t = getFreeMarkerCFG().getTemplate(templateFileName, "UTF-8");
			Writer out = new StringWriter();
			t.process(values, out);
			retValue = out.toString();
			out.flush();
			out.close();
		}
		catch (Exception e) {
			throw new RuntimeException("生成freemarker模板内容出错：" + e.getMessage());
		}

		return retValue;
	}

	public static void main ( String[] args ) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("addressee", "201692131@qq.com");
		param.put("validateCode", ValidateCode.createCode(Canonical.num4));
		String msg = FreemarkerUtils.genStrFormTemplate("freemarker/email/register.ftl", param);

		System.out.println(msg);
	}

}
