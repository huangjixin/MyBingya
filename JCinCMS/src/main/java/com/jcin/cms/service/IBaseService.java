/**
 * 中兴软创<br/>
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

import com.jcin.cms.domain.User;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-23,上午9:54:24
 * 
 */
public interface IBaseService<T extends Serializable, PK extends Serializable> {
	int deleteByPrimaryKey(String id);

	int insert(T record);

	Page select(Page page);

	T selectByPrimaryKey(String id);

	int update(T record);
}
