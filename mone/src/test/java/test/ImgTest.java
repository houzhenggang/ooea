package test;

import java.io.IOException;
import java.util.Date;

import com.obc.common.utils.ValidateCode;

public class ImgTest {

	/**
	 * @param args
	 */
	public static void main ( String[] args ) {
		ValidateCode vCode = ValidateCode.newInstance();
		try {
			String path = "D:/t/" + new Date().getTime() + ".png";
			System.out.println(vCode.getCode() + " >" + path);
			vCode.write(path);
			
			System.out.println(vCode.getCode());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
