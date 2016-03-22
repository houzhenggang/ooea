package com.obc.common.security;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @ClassName: Coder 
 *
 * @author FC
 * @Description: TODO 【基础加密组件】
 * @date 2016年3月22日 下午5:41:28
 */
public abstract class Coder {

	/**
	 * 
	 * @Title: decryptBASE64
	 * 
	 * @author FC
	 * @Description: TODO 【BASE64解密】
	 * @param key
	 * @return
	 * @throws Exception
	 * @date 2016年3月22日 下午5:40:51
	 */
	public static byte[] decryptBASE64 ( String key ) throws Exception {
		return (new Base64()).decode(key.getBytes());
	}

	/**
	 * 
	 * @Title: encryptBASE64
	 * 
	 * @author FC
	 * @Description: TODO 【BASE64加密】 
	 * @param key
	 * @return
	 * @throws Exception 
	 * @date 2016年3月22日 下午5:41:13
	 */
	public static String encryptBASE64 ( byte[] key ) throws Exception {
		return (new Base64()).encodeAsString(key).replace("\r", "").replace("\n", "");
	}
}
