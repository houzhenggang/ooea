package com.obc.common.mybatis;

import java.io.Serializable;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao implements Serializable {

	private static final long serialVersionUID = 4346247866840659680L;

	@Autowired
	public SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

}
