package com.obc.modules;

import java.io.Serializable;

/**
 * 
 * <br>类名： LoginPojo 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:19:23 
 * @author FC
 */
public class LoginPojo implements Serializable {
	
	/**
	 * <br>创建时间： 2016年5月31日 上午2:19:09
	 * @Fields serialVersionUID : TODO 【】
	 */
	private static final long serialVersionUID = -5748856127917166189L;
	private String			  username;
	private String			  password;
							  
	public String getUsername ( ) {
		return username;
	}
	
	public void setUsername ( String username ) {
		this.username = username;
	}
	
	public String getPassword ( ) {
		return password;
	}
	
	public void setPassword ( String password ) {
		this.password = password;
	}
	
}
