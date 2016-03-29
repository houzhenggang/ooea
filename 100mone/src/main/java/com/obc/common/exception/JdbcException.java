package com.obc.common.exception;

import com.obc.common.enumeration.Code;

public class JdbcException extends RuntimeException {

	/**
	 * @author FC
	 * @Fields serialVersionUID : TODO 【用一句话描述这个变量表示什么】
	 * @date 2016年3月29日 下午8:00:55
	 */
	private static final long serialVersionUID = -1508426575277494992L;

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
