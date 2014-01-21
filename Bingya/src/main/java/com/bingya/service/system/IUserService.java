/**
 * 
 */
package com.bingya.service.system;

import java.util.List;

import com.bingya.domain.system.Role;
import com.bingya.domain.system.User;
import com.bingya.service.IGenericService;

/**
 * @author huangjixin
 *
 */
public interface IUserService extends IGenericService<User, Integer> {
	/**
	 * 根据id查询角色。
	 * @param id
	 * @return
	 */
	List<Role> getRolesById(String id);
}
