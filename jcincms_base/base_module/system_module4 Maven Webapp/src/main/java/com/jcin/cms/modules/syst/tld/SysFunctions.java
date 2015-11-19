/**
 * 一句话描述该类：系统函数类<br/>
 * @author 黄记新
 * @date 2015-9-29,下午12:38:15
 *
 */
package com.jcin.cms.modules.syst.tld;


/**
 * @author 黄记新
 * 
 */
public class SysFunctions {
	/*private static RoleService roleService;

	public static String roleNames(Collection<Long> roleIds) {
		if (CollectionUtils.isEmpty(roleIds)) {
			return "";
		}

		StringBuilder s = new StringBuilder();
		for (Long roleId : roleIds) {
			Role role = getRoleService().findOne(roleId);
			if (role == null) {
				return "";
			}
			s.append(role.getDescription());
			s.append(",");
		}

		if (s.length() > 0) {
			s.deleteCharAt(s.length() - 1);
		}

		return s.toString();
	}

	public static RoleService getRoleService() {
		if (roleService == null) {
			roleService = SpringUtils.getBean(RoleService.class);
		}
		return roleService;
	}*/
}
