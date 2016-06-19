package com.obc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <br>类名： DateUtils 
 *
 * <br>公司名称： 【】
 * <br>描述：【时间工具类】
 * <br>创建时间： 2016年5月31日 上午2:40:53 
 * @author FC
 */
public class DateUtils {

	/**
	 * 
	 * <br>方法名： dateToStr
	 * 
	 * <br>描述：【日期转换成字符串格式】 
	 * <br>创建时间： 2016年5月31日 上午2:41:01 
	 * @param date 日期
	 * @param dateFormat 返回字符串的格式【yyyy-MM-dd】...
	 * @return
	 */
	public static String dateToStr (	Date date ,
										String dateFormat ) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		String str = format.format(date);
		return str;
	}
}
