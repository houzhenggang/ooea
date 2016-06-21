package com.obc.common.enumeration;

public enum DateFormat {
	f01 ( "yyyyMMdd" ) , f02 ( "yyyyMMddHH:mm:ss" );
	private String format;
	
	private DateFormat ( String format ) {
		this.format = format;
	}
	
	public String getFormat ( ) {
		return format;
	}
}
