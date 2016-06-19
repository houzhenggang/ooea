package com.obc.common.exception;

import com.obc.common.enumeration.Code;

public class JsonException extends RuntimeException {


	/** 
	 * <br>创建时间： 2016年5月31日 上午2:22:35 
	 * @Fields serialVersionUID : TODO 【】
	 */ 
	private static final long serialVersionUID = 5211876414236674811L;

	public JsonException ( ) {
		super(Code.i000010002em.getNO());
	}

	public JsonException ( String message ) {
		super(Code.i000010002em.getNO() + message);
	}

	public JsonException ( Class<?> clazz ) {
		super(clazz.toString());
	}
}
