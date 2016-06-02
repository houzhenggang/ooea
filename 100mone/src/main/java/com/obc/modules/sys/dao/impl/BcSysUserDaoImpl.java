package com.obc.modules.sys.dao.impl;

import java.util.List;

import com.obc.common.exception.JdbcException;
import com.obc.common.persistence.mybatis.BaseDao;
import com.obc.common.utils.MoneStringUtils;
import com.obc.modules.sys.dao.BcSysUserDao;
import com.obc.modules.sys.entity.BcSysUser;

public class BcSysUserDaoImpl extends BaseDao implements BcSysUserDao {


	/** 
	 * <br>创建时间： 2016年6月3日 上午1:46:27 
	 * @Fields serialVersionUID : TODO 【】
	 */ 
	private static final long serialVersionUID = 5915647471282145530L;

	@Override
	public List<BcSysUser> findBcSysUser ( String username ) {
		try {
			return sqlSession.selectList("com.obc.modules.sys.dao.BcSysUserDao.findBcSysUser", username);
		} catch (Exception e) {
			MoneStringUtils.log(e, BcSysUserDaoImpl.class);
			throw new JdbcException(BcSysUserDaoImpl.class);
		}
	}

	@Override
	public int updateBcSysUser ( BcSysUser bsu ) {
		try {
			return sqlSession.update("com.obc.modules.sys.dao.BcSysUserDao.updateBcSysUser", bsu);
		} catch (Exception e) {
			MoneStringUtils.log(e, BcSysUserDaoImpl.class);
			throw new JdbcException(BcSysUserDaoImpl.class);
		}
	}

	@Override
	public int addBcSysUser ( BcSysUser bsu ) {
		try {
			return sqlSession.insert("com.obc.modules.sys.dao.BcSysUserDao.addBcSysUser", bsu);
		} catch (Exception e) {
			MoneStringUtils.log(e, BcSysUserDaoImpl.class);
			throw new JdbcException(BcSysUserDaoImpl.class);
		}
	}

}
