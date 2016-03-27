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
	/** json解析异常 */
	i000010001EM ( "i000010001" , "JSON异常" ) , //
	/** 验证异常 */
	i000010002EM ( "i000010002" , "验证没有通过." ) , //
	/** 查询异常 */
	i000010003EM ( "i000010003" , "查询异常" ) , //
	/** 成功 */
	SuccesssMessage ( "i000010004" , "验证成功。" ) , //
	/** 登录路径 */
	loginSalt ( "i000010005" , "908SWDMDWA7SbsS9desUE" ) , //
	/** 加密盐 */
	salt ( "i000010006" , "SALT" ) , //
	/** 密码 */
	pass ( "i000010007" , "PASSWD" ) , //
	/** 密码验证 */
	validatePass ( "i000010008" , "Pass" ) , //
	/** 身份证验证 */
	validateCard ( "i000010009" , "Card" ) , //
	/** 邮箱验证 */
	validateEmail ( "i000010010" , "Email" ) , //
	/** 手机号验证 */
	validatePhone ( "i000010011" , "Phone" ) , //
	/** 是否有效 */
	isValid ( "i000019999" , "1" );

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
