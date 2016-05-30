package com.obc.common.exception;

import com.obc.common.enumeration.Code;

public class JdbcException extends RuntimeException {

	/** 
	 * <br>创建时间： 2016年5月31日 上午2:22:22 
	 * @Fields serialVersionUID : TODO 【】
	 */ 
	private static final long serialVersionUID = -2285751751883751052L;

	public JdbcException ( ) {
		super(Code.i000jdbcem.getNO());
	}

	public JdbcException ( String message ) {
		super(Code.i000jdbcem.getNO() + message);
	}

	public JdbcException ( Class<?> clazz ) {
		super(clazz.toString());
	}
}
