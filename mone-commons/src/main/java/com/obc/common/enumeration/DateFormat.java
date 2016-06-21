package com.obc.common.enumeration;

public enum DateFormat {
    /**
     * yyyyMMdd<br>
     * 20160621
     */
	f01 ( "yyyyMMdd" ) , //
	/**
	 * HH:mm:ss<br>
	 * 20:53:51
	 */
	f03 ( "HH:mm:ss" ) ,//
	/**
	 * yyyy-MM-dd HH:mm:ss a<br>
	 * 2016-06-21 20:53:51 下午
	 */
	f04 ( "yyyy-MM-dd HH:mm:ss a" ) ,//
	/**
	 * yyyy-MM-dd HH:mm:ss<br>
	 * 2016-06-21 20:53:51
	 */
	f02 ( "yyyy-MM-dd HH:mm:ss" );//
	private String format;
	
	private DateFormat ( String format ) {
		this.format = format;
	}
	
	public String getFormat ( ) {
		return format;
	}
}
