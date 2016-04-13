package com.obc.common.utils;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.obc.common.constant.Canonical;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerUtils {

	/**
	 * 
	 * @Title: getFreeMarkerCFG
	 * 
	 * @author FC
	 * @Description: TODO 【获取freemarker的配置】
	 * @return
	 * @date 2016年4月13日 下午5:57:16
	 */
	private static Configuration getFreeMarkerCFG ( ) {
		Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		configuration.setClassForTemplateLoading(FreemarkerUtils.class, "/");
		configuration.setDefaultEncoding("UTF-8");
		return configuration;
	}

	/**
	 * 
	 * @Title: genStrFormTemplate
	 * 
	 * @author FC
	 * @Description: TODO 【输出模板信息】
	 * @param templateFileName 模板名称
	 * @param values 模板需要替换内容
	 * @return
	 * @date 2016年4月13日 下午5:59:00
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
