/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-23,上午9:54:24
 *
 */
/**
 * 
 */
package com.jcin.cms.service;

import java.io.Serializable;
import java.util.List;

import com.jcin.cms.utils.Page;

/**
 * 该类定义了一系列数据库基础操作，包括增删改查，批量增加，批量删除。
 * @author 黄记新
 * @date 2014-12-23,上午9:54:24
 * 
 */
public interface IBaseService<T extends Serializable, PK extends Serializable> {
	/**
	 * 根据主键删除一条记录
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(PK id);

	/**
	 * 插入一条记录
	 * @param record
	 * @return
	 */
	int insert(T record);

	/**
	 * 根据page对象进行查询。
	 * @param page
	 * @return
	 */
	Page select(Page page);

	/**
	 * 根据主键查询返回记录。
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(PK id);

	/**
	 * 更新记录。
	 * @param record
	 * @return
	 */
	int update(T record);
	
	/**
	 * 批量插入。
	 * @param list
	 * @return
	 */
	int insertBatch(List<T> list);

	/**
	 * 批量删除。
	 * @param list
	 * @return
	 */
	int deleteBatch(List<PK> list);
}
