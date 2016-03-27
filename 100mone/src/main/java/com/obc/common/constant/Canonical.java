package com.obc.common.constant;

/**
 * 验证格式
 * 
 * @ClassName: Canonical
 *
 * @author FC
 * @Description: TODO 【这里用一句话描述这个类的作用】
 * @date 2016年3月19日 下午10:44:10
 */
public class Canonical {

	/** 邮箱验证 */
	public static final String Email = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	/** 手机号码 */
	public static final String Phone = "Phone";
	/** 身份证 */
	public static final String Card = "Card";
	/** 密码验证 */
	public static final String Pass = "Pass";
}
