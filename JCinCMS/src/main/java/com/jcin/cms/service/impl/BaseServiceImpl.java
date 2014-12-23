/**
 * 中兴软创<br/>
 * 一句话描述该类：服务类的基类，可以在基类的方法当中做一些切入动作，例如操作日志，日志监控等<br/>
 * @author 黄记新
 * @date 2014-12-23,上午9:59:24
 *
 */
/**
 * 
 */
package com.jcin.cms.service.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-23,上午9:59:24
 * 
 */
public class BaseServiceImpl<T extends Serializable, PK extends Serializable>
		implements IBaseService<T, PK> {
	// 实体类类型(由构造方法自动赋值)
	private Class<T> entityClass;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseServiceImpl() {
		this.entityClass = null;
		Class c = getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.entityClass = (Class<T>) p[0];
		}
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(T record) {
		@SuppressWarnings("rawtypes")
		Class clazz = record.getClass();
		try {
			Method method = clazz.getDeclaredMethod("setId", String.class);
			method.invoke(record, new Date().getTime() + "");

			Method createDatemethod = clazz.getDeclaredMethod("setCreatedate",
					Date.class);
			createDatemethod.invoke(record, new Date());

			Method updateDatemethod = clazz.getDeclaredMethod("setUpdatedate",
					Date.class);
			updateDatemethod.invoke(record, new Date());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Page select(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(T record) {
		@SuppressWarnings("rawtypes")
		Class clazz = record.getClass();
		Method updateDatemethod;
		try {
			updateDatemethod = clazz.getDeclaredMethod("setUpdatedate",
					Date.class);
			updateDatemethod.invoke(record, new Date());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
