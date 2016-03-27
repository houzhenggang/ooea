package com.obc.modules.sys.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.obc.common.enumeration.Code;
import com.obc.common.security.EncryptUtil;
import com.obc.common.utils.ObcStringUtils;
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
		throw new RuntimeException(Code.i000010003EM.getNO());
	}

	@Override
	public BcSysUser updateBcSysUser ( BcSysUser bcSysUser ) {
		bcSysUserDao.updateBcSysUser(bcSysUser);
		return bcSysUser;
	}

	@Override
	public BcSysUser addBcSysUser ( BcSysUser bcSysUser ) {
		if (ObcStringUtils.isValidate(bcSysUser.getPlain_text(), Code.validatePass)) {// 当密码不是当前验证规则是抛出异常
			throw new RuntimeException(Code.i000010002EM.getNO());
		}
		Map<String, String> encrypt = EncryptUtil.encrypt(bcSysUser.getPlain_text());
		bcSysUser.setPassword(encrypt.get(Code.pass.getDesc()));
		bcSysUser.setSalt(encrypt.get(Code.salt.getDesc()));
		bcSysUser.setCreate_time(new Date());
		bcSysUser.setIs_valid(Code.isValid.getDesc());
		bcSysUserDao.addBcSysUser(bcSysUser);
		return bcSysUser;
	}

}
