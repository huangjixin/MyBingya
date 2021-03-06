/**
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
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.jcin.cms.dao.system.OperationlogMapper;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.CustomerContextHolder;
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

	public static Logger logger = null;

	@Resource
	private OperationlogMapper operationlogMapper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseServiceImpl() {
		this.entityClass = null;
		Class c = getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.entityClass = (Class<T>) p[0];
		}

		logger = Logger.getLogger(entityClass.getName());
	}

	@Override
	public int deleteByPrimaryKey(PK id) {
		CustomerContextHolder.setCustomerType("SLAVE");

		// Operationlog operationlog = new Operationlog();
		// operationlog.setId(new Date().getTime() + "");
		// String opeName = Thread.currentThread().getStackTrace()[1]
		// .getMethodName();
		// String name = entityClass.getName() + "." + opeName
		// + " delete(删除) success";
		// operationlog.setName(name);
		// if (LoginResponse.user != null) {
		// operationlog.setOperator(LoginResponse.user.getUsername());
		// }

		// operationlog.setCreatedate(new Date());
		// operationlogMapper.insert(operationlog);

		return 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public String insert(T record) {
		CustomerContextHolder.setCustomerType("SLAVE");
		@SuppressWarnings("rawtypes")
		Class clazz = record.getClass();
		// Method createDatemethod;
		try {
			Method method = clazz.getDeclaredMethod("setId", String.class);
			method.invoke(record, new Date().getTime() + "");

			// createDatemethod = clazz.getDeclaredMethod("setCreatedate",
			// Date.class);
			// if (createDatemethod != null) {
			// createDatemethod.invoke(record, new Date());
			// }

			// Method updateDatemethod =
			// clazz.getDeclaredMethod("setUpdatedate",
			// Date.class);
			// if (updateDatemethod != null) {
			// updateDatemethod.invoke(record, new Date());
			// }

			// Operationlog operationlog = new Operationlog();
			// operationlog.setId(new Date().getTime() + "");
			// String opeName = Thread.currentThread().getStackTrace()[1]
			// .getMethodName();// 具体使用数组的那个元素和JVM的实现有关，我在SUN
			// // JDK6下面测试的是第二个元素，具体说明可以查看Thread.getStackTrace方法的javadoc
			// operationlog.setName(entityClass.getName() + "." + opeName
			// + " insert(添加) success");
			//
			// operationlog.setCreatedate(new Date());
			// operationlogMapper.insert(operationlog);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public Page select(Page page) {
		CustomerContextHolder.setCustomerType("MASTER");
		return null;
	}

	@Override
	public List<T> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public T selectByPrimaryKey(PK id) {
		CustomerContextHolder.setCustomerType("MASTER");
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String update(T record) {
		CustomerContextHolder.setCustomerType("SLAVE");

		@SuppressWarnings("rawtypes")
		Class clazz = record.getClass();
		Method updateDatemethod;
		try {
			// updateDatemethod = clazz.getDeclaredMethod("setUpdatedate",
			// Date.class);
			// updateDatemethod.invoke(record, new Date());
			//
			// Operationlog operationlog = new Operationlog();
			// operationlog.setId(new Date().getTime() + "");
			// String opeName = Thread.currentThread().getStackTrace()[1]
			// .getMethodName();// 具体使用数组的那个元素和JVM的实现有关，我在SUN
			// // JDK6下面测试的是第二个元素，具体说明可以查看Thread.getStackTrace方法的javadoc
			// operationlog.setName(entityClass.getName() + "." + opeName
			// + " 更新成功");
			// // if (LoginResponse.user != null) {
			// // operationlog.setOperator(LoginResponse.user.getUsername());
			// // }
			//
			// operationlog.setCreatedate(new Date());
			// operationlogMapper.insert(operationlog);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	@Override
	public int insertBatch(List<T> list) {
		CustomerContextHolder.setCustomerType("SLAVE");

		for (T t : list) {
			@SuppressWarnings("rawtypes")
			Class clazz = t.getClass();
			try {
				Method method = clazz.getDeclaredMethod("setId", String.class);
				method.invoke(t, new Date().getTime() + "");
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Operationlog operationlog = new Operationlog();
		// operationlog.setId(new Date().getTime() + "");
		// String opeName = Thread.currentThread().getStackTrace()[1]
		// .getMethodName();
		// operationlog.setName(entityClass.getName() + "." + opeName
		// + " insertBatch(批量添加) 成功");
		// // if (LoginResponse.user != null) {
		// // operationlog.setOperator(LoginResponse.user.getUsername());
		// // }
		//
		// operationlog.setCreatedate(new Date());
		// operationlogMapper.insert(operationlog);
		return 0;
	}

	@Override
	public int deleteBatch(List<PK> list) {
		// TODO Auto-generated method stub
		return 0;
	}

}
