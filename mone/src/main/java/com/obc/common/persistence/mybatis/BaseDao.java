package com.obc.common.persistence.mybatis;

import java.io.Serializable;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * <br>类名： BaseDao 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:32:05 
 * @author FC
 */
public class BaseDao implements Serializable {

	/** 
	 * <br>创建时间： 2016年5月31日 上午2:32:14 
	 * @Fields serialVersionUID : TODO 【】
	 */ 
	private static final long serialVersionUID = 856014541129256429L;
	
	@Autowired
	public SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession ( ) {
		return sqlSession;
	}

	public void setSqlSession ( SqlSessionTemplate sqlSession ) {
		this.sqlSession = sqlSession;
	}

}
