package com.jcin.cms.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.subject.Subject;

import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.modules.channel.service.impl.ChannelServiceImpl;
import com.jcin.cms.modules.channel.service.impl.DocumentServiceImpl;
import com.jcin.cms.modules.pro.domain.Brand;
import com.jcin.cms.modules.pro.service.IBrandService;
import com.jcin.cms.modules.pro.service.impl.BrandServiceImpl;
import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.service.IResourceService;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.modules.syst.service.impl.ResourceServiceImpl;
import com.jcin.cms.modules.syst.service.impl.UserServiceImpl;
import com.jcin.cms.utils.Page;

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
