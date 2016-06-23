package com.jcin.cms.common;

import com.jcin.cms.modules.pro.domain.Brand;
import com.jcin.cms.modules.pro.service.IBrandService;
import com.jcin.cms.modules.pro.service.impl.BrandServiceImpl;

/**
 * 用户工具类
 * 
 * @author lcw
 * @version 2013-5-29
 */
public class ProductUtils {

	private static IBrandService brandService = SpringUtils
			.getBean(BrandServiceImpl.class);

	public static Brand getBrandById(String id) {
		return brandService.selectByPrimaryKey(id);
	}

}
