package com.jcin.cms.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.subject.Subject;

import com.jcin.cms.modules.syst.dao.DictionaryMapper;
import com.jcin.cms.modules.syst.domain.Dictionary;
import com.jcin.cms.modules.syst.domain.DictionaryCriteria;
import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.service.IDictionaryService;
import com.jcin.cms.modules.syst.service.impl.DictionaryServiceImpl;

/**
 * 用户工具类
 * 
 * @author lcw
 * @version 2013-5-29
 */
public class DictionaryUtils {

	private static IDictionaryService dictionaryService = SpringUtils
			.getBean(DictionaryServiceImpl.class);

	public static final String CACHE_AVAILABLE = "available";//是否可用
	public static final String SEX = "sex";//性别

	public static List<Dictionary> getByType(String type) {
		List<Dictionary> list = (List<Dictionary>) getCache(CACHE_AVAILABLE);

		if (list == null) {
			DictionaryCriteria dictionaryCriteria = new DictionaryCriteria();
			dictionaryCriteria.createCriteria().andTypeEqualTo(type);
			list = dictionaryService.selectByExample(dictionaryCriteria);
			putCache(type, list);
		}

		return list;
	}

	public static List<Dictionary> getAvailable(){
		return getByType(CACHE_AVAILABLE);
	}
	
	public static List<Dictionary> getSex(){
		return getByType(SEX);
	}
	
	// ============== User Cache ==============

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		Object obj = getCacheMap().get(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		getCacheMap().put(key, value);
	}

	public static void removeCache(String key) {
		getCacheMap().remove(key);
	}

	private static Map<String, Object> map;

	public static Map<String, Object> getCacheMap() {
		if (map == null) {
			map = new HashMap<String, Object>();
		}
		return map;
	}

}
