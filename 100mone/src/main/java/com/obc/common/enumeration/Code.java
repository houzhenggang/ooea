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
	i000010001em ( "i000010001" , "JSON异常" ) , //
	/** 验证异常 */
	i000010002em ( "i000010002" , "验证没有通过." ) , //
	/** 查询异常 */
	i000010003em ( "i000010003" , "查询异常" ) , //
	/** 成功 */
	SuccesssMessage ( "i000010004" , "验证成功。" ) , //

	/** 登录路径 */
	i000LoginSalt ( "i000010005" , "908SWDMDWA7SbsS9desUE" ) , //
	/** 加密盐 */
	i000Salt ( "i000010006" , "SALT" ) , // ***
	/** 密码 */
	i000Pass ( "i000010007" , "PASSWD" ) , // ***
	/** 密码验证 */
	validatePass ( "i000010008" , "Pass" ) , //
	/** 邮箱验证 */
	validateEmail ( "i000010010" , "Email" ) , //
	/** 手机号验证 */
	validatePhone ( "i000010011" , "Phone" ) , //
	/** 是否有效 */
	i000IsValid1L ( "i000019999" , "1" ) , // 数据库记录有效性【有效】
	i000jdbcem ( "jdbc" , "数据异常。" ) , //
	/** 是否有效 */
	i000IsValid0L ( "i000019999" , "0" );// 数据库记录有效性【无效】

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
