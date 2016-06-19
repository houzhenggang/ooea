package com.obc.common.security;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

/**
 * 
 * <br>类名： EncryptUtil 
 *
 * <br>公司名称： 【】
 * <br>描述：【加密工具类】
 * <br>创建时间： 2016年5月31日 上午2:41:38 
 * @author FC
 */
public class EncryptUtil {
	public static final int INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	public static final String ALGORITHM = "SHA-1";
	public static final char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	/**
	 * 
	 * @Title: encrypt
	 * 
	 * @author FC
	 * @Description: TODO 【】
	 * @param plainText
	 *            
	 * @return 
	 * @date 2016年3月22日 下午5:46:17
	 */
	/**
	 * 
	 * <br>方法名： encrypt
	 * 
	 * <br>描述：【对密码明文进行SHA-1加密 返回加密因子和密文】 
	 * <br>创建时间： 2016年5月31日 上午2:41:47 
	 * @param plainText 密码明文
	 * @return Map{SALT->saltVal,PASSWD->passwdVal}
	 */
	public static Map<String, String> encrypt ( String plainText ) {
		// 构造返回Map对象
		Map<String, String> passwdMap = new HashMap<String, String>();
		// 获取随机加密因子
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		passwdMap.put("SALT", Encodes.encodeHex(salt));
		// 用加密因子对明文进行SHA-1加密
		byte[] hashPassword = Digests.sha1(plainText.getBytes(), salt, INTERATIONS);
		passwdMap.put("PASSWD", Encodes.encodeHex(hashPassword));
		return passwdMap;
	}

	/**
	 * 
	 * <br>方法名： encryptBySalt
	 * 
	 * <br>描述：【指定加密因子对明文进行加密】 
	 * <br>创建时间： 2016年5月31日 上午2:42:10 
	 * @param plainText 密码明文
	 * @param salt 加密因子
	 * @return
	 */
	public static String encryptBySalt (	String plainText ,
									String salt ) {
		// 将因子转换为字节数组类型
		byte[] old_salt = Encodes.decodeHex(salt);
		// 用加密因子对明文进行加密
		byte[] hashPassword = Digests.sha1(plainText.getBytes(), old_salt, INTERATIONS);
		// 返回加密后的密码
		return Encodes.encodeHex(hashPassword);
	}


	/**
	 * 
	 * <br>方法名： getBytesFromFile
	 * 
	 * <br>描述：【取得文件的哈希值】 
	 * <br>创建时间： 2016年5月31日 上午2:42:40 
	 * @param file 文件路径
	 * @return 文件哈希值
	 */
	public static byte[] getBytesFromFile ( File file ) {
		if (file == null)
			return null;
		try {
			FileInputStream stream = new FileInputStream(file);
			ByteArrayOutputStream out = new ByteArrayOutputStream(10000);
			byte[] b = new byte[10000];
			int n;
			while ((n = stream.read(b)) != -1) {
				out.write(b, 0, n);
			}
			stream.close();
			out.close();
			return out.toByteArray();
		} catch (IOException e) {

		}
		return null;
	}

	/**
	 * 
	 * <br>方法名： getHash
	 * 
	 * <br>描述：【取得文件的哈希值】 
	 * <br>创建时间： 2016年5月31日 上午2:43:02 
	 * @param fileName 文件路径
	 * @param hashType 哈希类型
	 * @return 文件哈希值
	 * @throws Exception
	 */
	public static String getHash (	String fileName ,
									String hashType ) throws Exception {
		InputStream fis;
		fis = new FileInputStream(fileName);// 读取文件
		byte[] b = new byte[1024];
		MessageDigest md5 = MessageDigest.getInstance(hashType);
		int numRead = 0;
		while ((numRead = fis.read(b)) > 0) {
			md5.update(b, 0, numRead);
		}
		fis.close();
		return toHexString(md5.digest());
	}

	/**
	 * 
	 * <br>方法名： toHexString
	 * 
	 * <br>描述：【md5码数组转十六进制字符串】 
	 * <br>创建时间： 2016年5月31日 上午2:43:29 
	 * @param b md5码数组
	 * @return 十六进制字符串
	 */
	private static String toHexString ( byte[] b ) {
		StringBuffer sbuf = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sbuf.append(hexChar[(b[i] & 0xf0) >>> 4]);
			sbuf.append(hexChar[b[i] & 0x0f]);
		}
		return sbuf.toString();
	}

	/**
	 * 
	 * <br>方法名： toSha1
	 * 
	 * <br>描述：【对明文进行sha1】 
	 * <br>创建时间： 2016年5月31日 上午2:43:58 
	 * @param plainText 明文
	 * @return sha1 密文
	 */
	public static String toSha1 ( String plainText ) {
		// 用加密因子对明文进行SHA-1加密
		byte[] hashPassword = Digests.sha1(plainText.getBytes());
		return Encodes.encodeHex(hashPassword);
	}
}
