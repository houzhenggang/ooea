package com.obc.modules.sys.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.obc.common.enumeration.Code;
import com.obc.common.security.EncryptUtil;
import com.obc.common.utils.IStringUtils;
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
		throw new RuntimeException(Code.i000010003em.getNO());
	}

	@Override
	public BcSysUser updateBcSysUser ( BcSysUser bsu ) {
		bcSysUserDao.updateBcSysUser(bsu);
		return bsu;
	}

	@Override
	public BcSysUser addBcSysUser ( BcSysUser bsu ) {
		String pass = bsu.getPlain_text();// 用户传入的密码
		// 正则验证密码格式是否正确
		if (!IStringUtils.isValidate(pass, Code.validatePass)) {
			throw new RuntimeException(Code.i000010002em.getNO());
		}
		String email = bsu.getEmail();
		if (!IStringUtils.isValidate(email, Code.validateEmail)) {
			throw new RuntimeException(Code.i000010002em.getNO());
		}
		String phone = bsu.getMobile_phone();
		Map<String, String> enc = EncryptUtil.encrypt(pass);
		bsu.setPassword(enc.get(Code.i000Pass.getDesc()));
		bsu.setSalt(enc.get(Code.i000Salt.getDesc()));
		bsu.setCreate_time(new Date());
		bsu.setIs_valid(Code.i000IsValid1L.getDesc());
		bsu.setEmail(IStringUtils.replaceK(email));
		bsu.setMobile_phone(IStringUtils.replaceK(phone));
		bcSysUserDao.addBcSysUser(bsu);
		return bsu;
	}

}
