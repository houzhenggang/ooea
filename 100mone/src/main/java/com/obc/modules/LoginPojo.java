package com.obc.modules;

import java.io.Serializable;

public class LoginPojo implements Serializable {

	/**
	 * @author FC
	 * @Fields serialVersionUID : TODO 【用一句话描述这个变量表示什么】
	 * @date 2016年4月1日 下午11:51:11
	 */
	private static final long serialVersionUID = -5463670396213686551L;
	
	private String username;
	private String password;
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
