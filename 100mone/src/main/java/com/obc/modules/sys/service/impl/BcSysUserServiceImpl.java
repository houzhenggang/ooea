package com.obc.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.obc.modules.sys.dao.BcSysUserDao;
import com.obc.modules.sys.entity.BcSysUser;
import com.obc.modules.sys.service.BcSysUserService;

@Service
public class BcSysUserServiceImpl implements BcSysUserService {

	@Autowired
	@Qualifier("bcSysUserDaoImpl")
	private BcSysUserDao bcSysUserDao;

	@Override
	public BcSysUser findBcSysUser ( String username ) {
		return bcSysUserDao.findBcSysUser(username);
	}

}
