package com.obc.modules.sys.entity;

import java.util.Date;

import com.obc.common.persistence.mybatis.DataEntity;

public class BcSysUser extends DataEntity<BcSysUser> {

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

	public Long getSys_user_id() {
		return sys_user_id;
	}

	public void setSys_user_id(Long sys_user_id) {
		this.sys_user_id = sys_user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}

	public String getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}

}
