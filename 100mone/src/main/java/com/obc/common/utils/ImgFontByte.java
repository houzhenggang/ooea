package com.obc.common.utils;

import java.io.ByteArrayInputStream;
import java.awt.*;

/**
 * 
 * @ClassName: ImgFontByte 
 *
 * @author FC
 * @Description: TODO 【这里用一句话描述这个类的作用】
 * @date 2016年4月10日 上午10:56:43
 */
public class ImgFontByte {

	public Font getFont ( int fontHeight ) {
		try {
			Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new ByteArrayInputStream(hex2byte(getFontByteStr())));
			return baseFont.deriveFont(Font.PLAIN, fontHeight);
		}
		catch (Exception e) {
			return new Font("Arial", Font.PLAIN, fontHeight);
		}
	}

	private byte[] hex2byte ( String str ) {
		if (str == null) return null;
		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1) return null;

		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer.decode("0x" + str.substring(i, i + 2)).intValue();
			}
			return b;
		}
		catch (Exception e) {
			return null;
		}
	}

	private String getFontByteStr ( ) {
		return null;
	}
}