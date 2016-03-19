package com.obc.common.exception;

public class JsonException extends Exception {

	private static final String JosnExceptionMessage = "10000000001";

	/**
	 * @author FC
	 * @Fields serialVersionUID : TODO 【标识】
	 * @date 2016年3月6日 下午8:26:25
	 */
	private static final long serialVersionUID = -6105893005062688525L;

	public JsonException ( ) {
		super(JosnExceptionMessage);
	}

	public JsonException ( String message ) {
		super(JosnExceptionMessage);
	}

}
