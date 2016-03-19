package com.obc.modules.sys.dao.impl;

import com.obc.common.mybatis.BaseDao;
import com.obc.modules.sys.dao.BcSysUserDao;
import com.obc.modules.sys.entity.BcSysUser;

public class BcSysUserDaoImpl extends BaseDao implements BcSysUserDao {

	@Override
	public BcSysUser findBcSysUser ( String username ) {
		return sqlSession.selectOne("com.obc.modules.sys.dao.BcSysUserDao.findBcSysUser", username);
	}

}
