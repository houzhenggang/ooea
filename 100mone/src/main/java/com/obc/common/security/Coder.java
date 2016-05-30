package com.obc.common.security;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * <br>类名： Coder 
 *
 * <br>公司名称： 【】
 * <br>描述：【基础加密组件】
 * <br>创建时间： 2016年5月31日 上午2:32:50 
 * @author FC
 */
public abstract class Coder {

	/**
	 * 
	 * <br>方法名： decryptBASE64
	 * 
	 * <br>描述：【BASE64解密】 
	 * <br>创建时间： 2016年5月31日 上午2:33:06 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64 ( String key ) throws Exception {
		return (new Base64()).decode(key.getBytes());
	}

	/**
	 * 
	 * <br>方法名： encryptBASE64
	 * 
	 * <br>描述：【BASE64加密】 
	 * <br>创建时间： 2016年5月31日 上午2:33:16 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64 ( byte[] key ) throws Exception {
		return (new Base64()).encodeAsString(key).replace("\r", "").replace("\n", "");
	}
}
