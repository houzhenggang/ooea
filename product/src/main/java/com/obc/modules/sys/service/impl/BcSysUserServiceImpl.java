package com.obc.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.obc.modules.sys.dao.BcSysUserDao;
import com.obc.modules.sys.entity.BcSysUser;
import com.obc.modules.sys.service.BcSysUserService;

public class BcSysUserServiceImpl implements BcSysUserService {

	@Autowired
	private BcSysUserDao bcSysUserDao;

	@Override
	public BcSysUser findBcSysUser ( String username ) {
		return bcSysUserDao.findBcSysUser(username);
	}

}
