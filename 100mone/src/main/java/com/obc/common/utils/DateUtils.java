package com.obc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtils
 *
 * @author FC
 * @Description: TODO 【时间工具类】
 * @date 2016年3月21日 下午5:55:00
 */
public class DateUtils {
	/**
	 * 
	 * @Title: dateToStr
	 * 
	 * @author FC
	 * @Description: TODO 【日期转换成字符串格式】
	 * @param date
	 *            日期
	 * @param dateFormat
	 *            返回字符串的格式【yyyy-MM-dd】...
	 * @return
	 * @date 2016年3月21日 下午5:53:35
	 */
	public static String dateToStr (	Date date ,
										String dateFormat ) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		String str = format.format(date);
		return str;
	}
}
