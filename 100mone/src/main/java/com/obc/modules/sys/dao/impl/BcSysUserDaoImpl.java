package com.obc.modules.sys.dao.impl;

import com.obc.common.persistence.mybatis.BaseDao;
import com.obc.modules.sys.dao.BcSysUserDao;
import com.obc.modules.sys.entity.BcSysUser;

public class BcSysUserDaoImpl extends BaseDao implements BcSysUserDao {

	/** 
	 * @author FC
	 * @Fields serialVersionUID : TODO 【用一句话描述这个变量表示什么】
	 * @date 2016年3月21日 下午5:58:08 
	 */ 
	private static final long serialVersionUID = 7675938620185200061L;

	@Override
	public BcSysUser findBcSysUser ( String username ) {
		return sqlSession.selectOne("com.obc.modules.sys.dao.BcSysUserDao.findBcSysUser", username);
	}

}
