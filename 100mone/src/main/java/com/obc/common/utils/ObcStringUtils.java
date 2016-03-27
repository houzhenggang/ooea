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
		switch (validate.getNO()) {
		case Canonical.Pass:
			bool = str.matches(Code.validatePass.getDesc());
			break;
		case Canonical.Card:
			bool = str.matches(Code.validateCard.getDesc());
			break;
		case Canonical.Email:
			bool = str.matches(Code.validateEmail.getDesc());
			break;
		case Canonical.Phone:
			bool = str.matches(Code.validatePhone.getDesc());
			break;
		}
		return bool;
	}

}
