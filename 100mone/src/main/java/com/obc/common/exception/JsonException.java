package com.obc.common.exception;

import com.obc.common.constant.ExceptionCode;

public class JsonException extends Exception {

	/**
	 * @author FC
	 * @Fields serialVersionUID : TODO 【标识】
	 * @date 2016年3月6日 下午8:26:25
	 */
	private static final long serialVersionUID = -6105893005062688525L;

	public JsonException ( ) {
		super(ExceptionCode.JosnExceptionMessage);
	}

	public JsonException ( String message ) {
		super(ExceptionCode.JosnExceptionMessage);
	}

}
