package com.obc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.obc.common.enumeration.DateFormat;

public class DateUtils {
	
	public static String dateToStr ( Date date ,
	                                 DateFormat format ) {
		SimpleDateFormat sdf = new SimpleDateFormat(format.getFormat());
		return sdf.format(date);
	}
	
	public static Date addMonth ( Date date ,
	                              int days ) {
		Calendar alendar = Calendar.getInstance();
		alendar.setTime(date);
		alendar.add(Calendar.MONTH, days);
		return alendar.getTime();
	}
	
	public static Date addDays ( Date date ,
	                             int days ) {
		Calendar alendar = Calendar.getInstance();
		alendar.setTime(date);
		alendar.add(Calendar.DAY_OF_MONTH, days);
		return alendar.getTime();
	}
	
	public static Date addHour ( Date date ,
	                             int days ) {
		Calendar alendar = Calendar.getInstance();
		alendar.setTime(date);
		alendar.add(Calendar.HOUR_OF_DAY, days);
		return alendar.getTime();
	}
	
}
