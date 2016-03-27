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
	public BcSysUser updateBcSysUser ( BcSysUser bsu ) {
		bcSysUserDao.updateBcSysUser(bsu);
		return bsu;
	}

	@Override
	public BcSysUser addBcSysUser ( BcSysUser bsu ) {
		String str = bsu.getPlain_text();// 用户传入的密码
		// 正则验证密码格式是否正确
		if (ObcStringUtils.isValidate(str, Code.validatePass)) {
			throw new RuntimeException(Code.i000010002EM.getNO());
		}
		Map<String, String> enc = EncryptUtil.encrypt(bsu.getPlain_text());
		bsu.setPassword(enc.get(Code.pass.getDesc()));
		bsu.setSalt(enc.get(Code.salt.getDesc()));
		bsu.setCreate_time(new Date());
		bsu.setIs_valid(Code.isValid.getDesc());
		bcSysUserDao.addBcSysUser(bsu);
		return bsu;
	}

}
