package com.obc.common.persistence.mybatis;

import java.io.Serializable;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @ClassName: BaseDao
 *
 * @author FC
 * @Description: TODO 【数据库连接模板】
 * @date 2016年3月21日 下午5:50:33
 */
public class BaseDao implements Serializable {

	/**
	 * @author FC
	 * @Fields serialVersionUID : TODO 【用一句话描述这个变量表示什么】
	 * @date 2016年3月21日 下午5:58:26
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
