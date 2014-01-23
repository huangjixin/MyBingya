/**
 * 
 */
package com.bingya.service.system;

import java.util.List;

import com.bingya.domain.system.Role;
import com.bingya.service.IGenericService;

/**
 * @author huangjixin
 *
 */
public interface IRoleService extends IGenericService<Role, String> {
	/**
	 * 根据id查询角色。
	 * @param id
	 * @return
	 */
	List getMenusById(String id);
	
	String getMenusXMLById(String id);
}
