package com.obc.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <br>类名： Canonical 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:21:52 
 * @author FC
 */
public class Canonical {

	/** 邮箱验证 */
	public static final String Email = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	/** 手机号码 */
	public static final String Phone = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
	/** 密码验证 */
	public static final String Pass = "^\\w{6,18}$";

	/** **/
	public static final Map<String, String> cvk = new HashMap<String, String>();
	/** **/
	public static final Map<String, String> ckv = new HashMap<String, String>();
	public static final String codeRegex = "^[A-Za-z0-9]$";
	public static final String validateCodeMessage = "验证码不正确或已过期，请重新获取.";
	public static final String emailSubject = "100mone注册验证";
	public static final String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
	public static final String accessKeyId = "3FHmJQGiFbt4sbun";
	public static final String accessKeySecret = "1tzpq1aNrDtaoJxINwOgXnpDtVKY39";
	/**
	 * ljs1e2xeeda2ercvd2lo
	 */
	public static final String BucketMyImg = "ljs1e2xeeda2ercvd2lo";

	public static final Integer num1 = 1;
	public static final Integer num2 = 2;
	public static final Integer num3 = 3;
	public static final Integer num4 = 4;
	public static final Integer num5 = 5;
	public static final Integer num6 = 6;
	public static final Integer num7 = 7;
	public static final Integer num8 = 8;
	public static final Integer num9 = 9;
	public static final Integer num0 = 0;

	static {
		cvk.put("0", "a");
		ckv.put("a", "0");
		cvk.put("1", "b");
		ckv.put("b", "1");
		cvk.put("2", "c");
		ckv.put("c", "2");
		cvk.put("3", "d");
		ckv.put("d", "3");
		cvk.put("4", "e");
		ckv.put("e", "4");
		cvk.put("5", "f");
		ckv.put("f", "5");
		cvk.put("6", "g");
		ckv.put("g", "6");
		cvk.put("7", "h");
		ckv.put("h", "7");
		cvk.put("8", "i");
		ckv.put("i", "8");
		cvk.put("9", "j");
		ckv.put("j", "9");
		cvk.put("a", "k");
		ckv.put("k", "a");
		cvk.put("b", "l");
		ckv.put("l", "b");
		cvk.put("c", "m");
		ckv.put("m", "c");
		cvk.put("d", "n");
		ckv.put("n", "d");
		cvk.put("e", "o");
		ckv.put("o", "e");
		cvk.put("f", "p");
		ckv.put("p", "f");
		cvk.put("g", "q");
		ckv.put("q", "g");
		cvk.put("h", "r");
		ckv.put("r", "h");
		cvk.put("i", "s");
		ckv.put("s", "i");
		cvk.put("j", "t");
		ckv.put("t", "j");
		cvk.put("k", "u");
		ckv.put("u", "k");
		cvk.put("l", "v");
		ckv.put("v", "l");
		cvk.put("m", "w");
		ckv.put("w", "m");
		cvk.put("n", "x");
		ckv.put("x", "n");
		cvk.put("o", "y");
		ckv.put("y", "o");
		cvk.put("p", "z");
		ckv.put("z", "p");
		cvk.put("q", "0");
		ckv.put("0", "q");
		cvk.put("r", "1");
		ckv.put("1", "r");
		cvk.put("s", "2");
		ckv.put("2", "s");
		cvk.put("t", "3");
		ckv.put("3", "t");
		cvk.put("u", "4");
		ckv.put("4", "u");
		cvk.put("v", "5");
		ckv.put("5", "v");
		cvk.put("w", "6");
		ckv.put("6", "w");
		cvk.put("x", "7");
		ckv.put("7", "x");
		cvk.put("y", "8");
		ckv.put("8", "y");
		cvk.put("z", "9");
		ckv.put("9", "z");
	}

}
