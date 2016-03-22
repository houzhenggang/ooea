package com.obc.modules.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.obc.modules.sys.dao.BcSysUserDao;
import com.obc.modules.sys.entity.BcSysUser;
import com.obc.modules.sys.service.BcSysUserService;

@Service
public class BcSysUserServiceImpl implements BcSysUserService {

	@Autowired
	@Qualifier( "bcSysUserDaoImpl" )
	private BcSysUserDao bcSysUserDao;

	@Override
	public BcSysUser findBcSysUser ( String username ) {
		List<BcSysUser> users = bcSysUserDao.findBcSysUser(username);
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public BcSysUser updateBcSysUser ( BcSysUser bcSysUser ) {
		bcSysUserDao.updateBcSysUser(bcSysUser);
		return bcSysUser;
	}

	@Override
	public BcSysUser addBcSysUser ( BcSysUser bcSysUser ) {
		bcSysUserDao.addBcSysUser(bcSysUser);
		return bcSysUser;
	}

}
