package com.obc.common.persistence.mybatis;

import java.util.List;

public interface CrudDao<T> extends BaseDao {

	/**
	 * 
	 * @Title: get
	 * 
	 * @author FC
	 * @Description: TODO 【获取单条数据】
	 * @param id
	 * @return
	 * @return T
	 * @date 2016年2月27日 上午12:05:25
	 */
	public T get(Long id);

	/**
	 * 
	 * @Title: get
	 * 
	 * @author FC
	 * @Description: TODO 【获取单条数据】
	 * @param entity
	 * @return
	 * @return T
	 * @date 2016年2月27日 上午12:05:46
	 */
	public T get(T entity);

	/**
	 * 
	 * @Title: findList
	 * 
	 * @author FC
	 * @Description: TODO 【查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page
	 *               <T>())】
	 * @param entity
	 * @return
	 * @return List<T>
	 * @date 2016年2月27日 上午12:06:13
	 */
	public List<T> findList(T entity);

	/**
	 * 
	 * @Title: findAllList
	 * 
	 * @author FC
	 * @Description: TODO 【查询所有数据列表】
	 * @param entity
	 * @return
	 * @return List<T>
	 * @date 2016年2月27日 上午12:06:33
	 */
	public List<T> findAllList(T entity);

	/**
	 * 
	 * @Title: insert
	 * 
	 * @author FC
	 * @Description: TODO 【插入数据】
	 * @param entity
	 * @return
	 * @return int
	 * @date 2016年2月27日 上午12:06:45
	 */
	public int insert(T entity);

	/**
	 * 
	 * @Title: update
	 * 
	 * @author FC
	 * @Description: TODO 【更新数据】
	 * @param entity
	 * @return
	 * @return int
	 * @date 2016年2月27日 上午12:06:54
	 */
	public int update(T entity);

	/**
	 * 
	 * @Title: delete
	 * 
	 * @author FC
	 * @Description: TODO 【删除数据（一般为逻辑删除）】
	 * @param entity
	 * @return
	 * @return int
	 * @date 2016年2月27日 上午12:07:07
	 */
	public int delete(T entity);

}
