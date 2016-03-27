package com.obc.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: BcSysUser
 *
 * @author FC
 * @Description: TODO 【这里用一句话描述这个类的作用】
 * @date 2016年2月20日 下午9:03:23
 */
public class BcSysUser implements Serializable {

	/**
	 * @author FC
	 * @Fields serialVersionUID : TODO 【用一句话描述这个变量表示什么】
	 * @date 2016年3月21日 下午8:39:21
	 */
	private static final long serialVersionUID = -246089492778549021L;

	private Long sys_user_id;// '用户ID'
	private String password;// '密码'
	private String salt;// '加密因子'
	private String username;// '用户名'
	private String email;// '邮箱'
	private String nickname;// '昵称'
	private String mobile_phone;// '手机号码'
	private Date create_time;// '创建时间'
	private Date last_login_time;// '最近登录'
	private String is_valid;// '是否有效【1：有效 0：无效】'
	private String plain_text;// 明文密码

	public String getPlain_text ( ) {
		return plain_text;
	}

	public void setPlain_text ( String plain_text ) {
		this.plain_text = plain_text;
	}

	public Long getSys_user_id ( ) {
		return sys_user_id;
	}

	public void setSys_user_id ( Long sys_user_id ) {
		this.sys_user_id = sys_user_id;
	}

	public String getPassword ( ) {
		return password;
	}

	public void setPassword ( String password ) {
		this.password = password;
	}

	public String getSalt ( ) {
		return salt;
	}

	public void setSalt ( String salt ) {
		this.salt = salt;
	}

	public String getUsername ( ) {
		return username;
	}

	public void setUsername ( String username ) {
		this.username = username;
	}

	public String getEmail ( ) {
		return email;
	}

	public void setEmail ( String email ) {
		this.email = email;
	}

	public String getNickname ( ) {
		return nickname;
	}

	public void setNickname ( String nickname ) {
		this.nickname = nickname;
	}

	public String getMobile_phone ( ) {
		return mobile_phone;
	}

	public void setMobile_phone ( String mobile_phone ) {
		this.mobile_phone = mobile_phone;
	}

	public Date getCreate_time ( ) {
		return create_time;
	}

	public void setCreate_time ( Date create_time ) {
		this.create_time = create_time;
	}

	public Date getLast_login_time ( ) {
		return last_login_time;
	}

	public void setLast_login_time ( Date last_login_time ) {
		this.last_login_time = last_login_time;
	}

	public String getIs_valid ( ) {
		return is_valid;
	}

	public void setIs_valid ( String is_valid ) {
		this.is_valid = is_valid;
	}

	public BcSysUser ( ) {
		super();
	}

	public BcSysUser ( Long sys_user_id ,
			String password ,
			String salt ,
			String username ,
			String email ,
			String nickname ,
			String mobile_phone ,
			Date create_time ,
			Date last_login_time ,
			String is_valid ) {
		super();
		this.sys_user_id = sys_user_id;
		this.password = password;
		this.salt = salt;
		this.username = username;
		this.email = email;
		this.nickname = nickname;
		this.mobile_phone = mobile_phone;
		this.create_time = create_time;
		this.last_login_time = last_login_time;
		this.is_valid = is_valid;
	}

}
