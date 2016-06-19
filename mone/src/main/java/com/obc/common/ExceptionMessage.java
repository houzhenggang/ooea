package com.obc.common;

public class ExceptionMessage {
	public String CuePhrases;// 提示语
	public Boolean IsBool;//

	public static ExceptionMessage newInstance ( ) {
		return new ExceptionMessage();
	}

	public ExceptionMessage addCuePhrases ( String CuePhrases ) {
		this.CuePhrases = CuePhrases;
		return this;
	}

	public ExceptionMessage addIsBool ( Boolean IsBool ) {
		this.IsBool = IsBool;
		return this;
	}
}
