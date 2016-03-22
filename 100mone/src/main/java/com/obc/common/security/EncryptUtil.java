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
 * @ClassName: EncryptUtil
 *
 * @author FC
 * @Description: TODO 【加密工具类】
 * @date 2016年3月22日 下午5:46:00
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
	 * @Description: TODO 【对密码明文进行SHA-1加密 返回加密因子和密文】
	 * @param plainText
	 *            密码明文
	 * @return Map{SALT->saltVal,PASSWD->passwdVal}
	 * @date 2016年3月22日 下午5:46:17
	 */
	public Map<String, String> encrypt ( String plainText ) {
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
	 * @Title: encryptBySalt
	 * 
	 * @author FC
	 * @Description: TODO 【指定加密因子对明文进行加密】
	 * @param plainText
	 *            密码明文
	 * @param salt
	 *            加密因子
	 * @return 加密后的密文
	 * @date 2016年3月22日 下午5:47:06
	 */
	public String encryptBySalt (	String plainText ,
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
	 * @Title: getBytesFromFile
	 * 
	 * @author FC
	 * @Description: TODO 【取得文件的哈希值】
	 * @param file
	 *            文件路径
	 * @return 文件哈希值
	 * @date 2016年3月22日 下午5:47:46
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
	 * @Title: getHash
	 * 
	 * @author FC
	 * @Description: TODO 【取得文件的哈希值】
	 * @param fileName
	 *            文件路径
	 * @param hashType
	 *            哈希类型
	 * @return 文件哈希值
	 * @throws Exception
	 * @date 2016年3月22日 下午5:50:14
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
	 * @Title: toHexString
	 * 
	 * @author FC
	 * @Description: TODO 【md5码数组转十六进制字符串】
	 * @param b
	 *            md5码数组
	 * @return 十六进制字符串
	 * @date 2016年3月22日 下午5:51:29
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
	 * @Title: toSha1
	 * 
	 * @author FC
	 * @Description: TODO 【对明文进行sha1】
	 * @param plainText
	 *            明文
	 * @return sha1 密文
	 * @date 2016年3月22日 下午5:51:58
	 */
	public static String toSha1 ( String plainText ) {
		// 用加密因子对明文进行SHA-1加密
		byte[] hashPassword = Digests.sha1(plainText.getBytes());
		return Encodes.encodeHex(hashPassword);
	}
}
