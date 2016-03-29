package test;

import com.obc.common.constant.Canonical;
import com.obc.common.security.DESCoder;
import com.obc.common.utils.IStringUtils;

import junit.framework.TestCase;

public class EncryptUtilTest extends TestCase {

	public static void main ( String[] args ) throws Exception {
		String inputStr = "DES";
		String key = DESCoder.initKey("wang!@#$%");
		System.err.println("原文:\t" + inputStr);
		System.err.println("密钥:\t" + key);
		byte[] inputData = inputStr.getBytes();
		inputData = DESCoder.encrypt(inputData, key);
		System.err.println("加密后:\t" + DESCoder.encryptBASE64(inputData));
		byte[] outputData = DESCoder.decrypt(inputData, key);
		String outputStr = new String(outputData);
		System.err.println("解密后:\t" + outputStr);
		String o = DESCoder.decrypt(DESCoder.encryptBASE64(inputData), key);
		System.err.println(o);
	}

	public void test ( ) {
		System.out.println("1286808279@qq.com".matches(Canonical.Email));

		String str = "1286808279@qq.com";
		str = IStringUtils.replaceK(str);
		System.out.println(str);
		str = IStringUtils.replaceV(str);
		System.out.println(str);

	}
}
