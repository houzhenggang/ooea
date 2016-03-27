package com.obc.common.utils;

import com.obc.common.constant.Canonical;
import com.obc.common.enumeration.Code;

/**
 * 
 * @ClassName: ObcStringUtils
 *
 * @author FC
 * @Description: TODO 【自定义StringUtils】
 * @date 2016年3月27日 下午6:58:36
 */
public class ObcStringUtils {

	/**
	 * 
	 * @Title: isValidate
	 * 
	 * @author FC
	 * @Description: TODO 【用户注册登录字符串验证】
	 * @param str
	 * @param validate
	 * @return
	 * @date 2016年3月27日 下午7:05:29
	 */
	public static Boolean isValidate (	String str ,
										Code validate ) {
		Boolean bool = false;
		switch (validate.getDesc()) {
		case "Pass":
			bool = str.matches(Canonical.Pass);
			break;
		case "Card":
			bool = str.matches(Canonical.Card);
			break;
		case "Email":
			bool = str.matches(Canonical.Email);
			break;
		case "Phone":
			bool = str.matches(Canonical.Phone);
			break;
		}
		return bool;
	}

}
