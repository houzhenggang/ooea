package com.obc.common.enumeration;

/**
 * 
 * @ClassName: Code
 *
 * @author FC
 * @Description: TODO 【项目中所有的字符串】
 * @date 2016年3月27日 下午2:06:28
 */
public enum Code {
	/**
	 * 验证异常
	 */
	i000010002EM ( "i000010002" , "验证没有通过." ) , // 验证
	/**
	 * json解析异常
	 */
	i000010001EM ( "i000010001" , "JSON异常" ) , // json处理
	/**
	 * 成功
	 */
	SuccesssMessage ( "0000" , "验证成功。" ) , //
	/**
	 * 加密盐
	 */
	salt ( "0002" , "SALT" ) , //
	/**
	 * 密码
	 */
	pass ( "0003" , "PASSWD" ) , //
	/**
	 * 是否有效
	 */
	isValid ( "0004" , "1" );
	private String no;
	private String desc;

	private Code ( String no , String desc ) {
		this.no = no;
		this.desc = desc;
	}

	public String getNO ( ) {
		return no;
	}

	public String getDesc ( ) {
		return desc;
	}
}
