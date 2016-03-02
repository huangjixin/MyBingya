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
import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.service.IResourceService;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.modules.syst.service.impl.ResourceServiceImpl;
import com.jcin.cms.modules.syst.service.impl.UserServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * 用户工具类
 * @author lcw
 * @version 2013-5-29
 */
public class UserUtils {
	
	private static IUserService userService = SpringUtils.getBean(UserServiceImpl.class);
	private static IResourceService resourceService = SpringUtils.getBean(ResourceServiceImpl.class);
	private static IDocumentService documentService = SpringUtils.getBean(DocumentServiceImpl.class);
	private static IChannelService channelService = SpringUtils.getBean(ChannelServiceImpl.class);

	public static final String CACHE_USER = "user";
	public static final String CACHE_RESOURCE = "resource";
	
	public static User getUser(){
		User user = null;//(User)getCache(CACHE_USER);
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
	
	public static List<Channel> getChannels(boolean isRefresh){
		if (isRefresh){
			removeCache("channels");
		}
		return getChannels();
	}
	
	public static List<Channel> getChannels(){
		List<Channel> list = (List<Channel>)getCache("channels");

        if (list == null){
            list = channelService.getChannelTree();
            putCache("channels", list);
		}
		return list;
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
	
	public static List getRecommendDoc(){
		Page page = new Page();
		List list = documentService.getRecommendDoc(page);
		return list==null || list.size()==0?null:list;
	}
	
	public static List getDocByChannelId(String id){
		Page page = new Page();
		return documentService.getDocByChannelId(id,page);
	}
	
	public static Channel getByCode(String code){
		return channelService.getByCode(code);
	}
	
	public static List<Document> getDocByChannelCode(String code,Integer pageSize){
		Page page = new Page();
		page.setPageSize(pageSize);
		return documentService.getDocByChannelCode(code,page);
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
//			map = new HashMap<String, Object>();
			map = new HashMap<String, Object>();
		}
		return map;
	}
	
}
