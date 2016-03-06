package com.obc.common.exception;

public class JosnException extends Exception {
	
	private static final String JosnExceptionMessage = "10000000001"; 

	/**
	 * @author FC
	 * @Fields serialVersionUID : TODO 【标识】
	 * @date 2016年3月6日 下午8:26:25
	 */
	private static final long serialVersionUID = -6105893005062688525L;

	public JosnException ( ) {
		super(JosnExceptionMessage);
	}

	public JosnException ( String message ) {
		super(JosnExceptionMessage);
	}

}
