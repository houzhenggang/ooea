package com.obc.common.utils;

import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;

public class XMLUtils {
	
	/**
	 * 
	 * <br>方法名： createXML
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年6月21日 下午4:38:30 
	 * @param os IO
	 * @param className 对象名
	 * @param val 对象值
	 * @throws ClassNotFoundException
	 */
	public static <E> void createXML ( OutputStream os ,
	                                   String className ,
	                                   E val ) throws ClassNotFoundException {
		XStream xs = new XStream();
		xs.processAnnotations(Class.forName(className).getClass());// 应用Person类的注解
		xs.autodetectAnnotations(true);// 自动检测注解
		xs.toXML(val, os);
	}
	
}
