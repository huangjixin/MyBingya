package com.jcin.cms.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.subject.Subject;

import com.jcin.cms.modules.syst.dao.UserMapper;
import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.service.IResourceService;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.modules.syst.service.impl.ResourceServiceImpl;
import com.jcin.cms.modules.syst.service.impl.UserServiceImpl;

/**
 * 用户工具类
 * @author lcw
 * @version 2013-5-29
 */
public class UserUtils {
	
	private static UserMapper userDao = SpringUtils.getBean(UserMapper.class);
	private static IUserService userService = SpringUtils.getBean(UserServiceImpl.class);
	private static IResourceService resourceService = SpringUtils.getBean(ResourceServiceImpl.class);

	public static final String CACHE_USER = "user";
	public static final String CACHE_RESOURCE = "resource";
	
	public static User getUser(){
		User user = (User)getCache(CACHE_USER);

        if (user == null){
            try{
            	Subject currentUser = SecurityUtils.getSubject();
            	Object object = null;
            	if(null != currentUser){
            		object = currentUser.getPrincipal();
            	}
            	
                if (object!=null){
                    user = userService.findByUsername(object.toString());
                    putCache(CACHE_USER, user);
                }
            }catch (UnavailableSecurityManagerException e){
                return null;
            }
		}
		if (user == null){
			user = new User();
            if(SecurityUtils.getSecurityManager()!=null&&SecurityUtils.getSubject()!=null)
            {
                SecurityUtils.getSubject().logout();
            }
		}
		return user;
	}
	
	public static User getUser(boolean isRefresh){
		if (isRefresh){
			removeCache(CACHE_USER);
		}
		return getUser();
	}
	
	public static List<Resource> getResource(boolean isRefresh){
		if (isRefresh){
			removeCache(CACHE_RESOURCE);
		}
		return getResource();
	}
	
	/**
	 * 获取资源列表，实现缓存。
	 * @return
	 */
	public static List<Resource> getResource(){
		List<Resource> list = (List)getCache(CACHE_RESOURCE);

        if (list == null){
            list = resourceService.getResourceCheckboxTree(null);
            putCache(CACHE_RESOURCE, list);
		}
		return list;
	}
	
	public static String getUsername(){
		return getUser().getUsername();
	}
	
	public static String getUserId(){
		return getUser().getId();
	}

	
	// ============== User Cache ==============
	
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
		Object obj = getCacheMap().get(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
		getCacheMap().put(key, value);
	}

	public static void removeCache(String key) {
		getCacheMap().remove(key);
	}
	
	private static Map<String, Object> map;
	
	public static Map<String, Object> getCacheMap(){
		if(map == null){
			map = new HashMap<String, Object>();
		}
		return map;
	}
	
}
