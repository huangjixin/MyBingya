/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jcin.cms.domain.system.Role;
import com.jcin.cms.service.system.IRoleService;
import com.jcin.cms.service.system.ITestService;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class TestServiceImpl implements ITestService {
	@Resource
	private IRoleService roleService;

	private static Logger logger = Logger.getLogger(TestServiceImpl.class
			.getName());

	@Override
	public List<Role> selectAll() {
		List<Role> roles = roleService.selectAll();
		return roles;
	}

}
