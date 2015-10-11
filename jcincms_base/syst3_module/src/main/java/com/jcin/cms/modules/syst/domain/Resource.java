package com.jcin.cms.modules.syst.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Resource implements Serializable {
	/**
	 * 所属表字段为tb_resource.id
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	private String id;

	/**
	 * 菜单名 所属表字段为tb_resource.name
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	private String name;

	/**
	 * 父亲节点集，用逗号分开 所属表字段为tb_resource.parentids
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	private String parentids;

	/**
	 * 父亲节点 所属表字段为tb_resource.parent_id
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	private String parentId;

	/**
	 * 权限名称 所属表字段为tb_resource.auth_name
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	private String authName;

	/**
	 * 访问路径，以“/”开头 所属表字段为tb_resource.path
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	private String path;

	/**
	 * 所属表字段为tb_resource.type
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	private ResourceType type = ResourceType.menu; // 资源类型

	/**
	 * 该字段对应数据库表 tb_resource
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	private static final long serialVersionUID = 1L;

	
	private List<Resource> children = new ArrayList<Resource>();
	/**
	 * 所属表字段为 tb_resource.id
	 * 
	 * @return 返回 tb_resource.id
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public String getId() {
		return id;
	}

	/**
	 * setter方法 tb_resource.id
	 * 
	 * @param id
	 *            赋值 tb_resource.id
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * 所属表字段为 tb_resource.name
	 * 
	 * @return 返回 tb_resource.name
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter方法 tb_resource.name
	 * 
	 * @param name
	 *            赋值 tb_resource.name
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 所属表字段为 tb_resource.parentids
	 * 
	 * @return 返回 tb_resource.parentids
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public String getParentids() {
		return parentids;
	}

	/**
	 * setter方法 tb_resource.parentids
	 * 
	 * @param parentids
	 *            赋值 tb_resource.parentids
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public void setParentids(String parentids) {
		this.parentids = parentids == null ? null : parentids.trim();
	}

	/**
	 * 所属表字段为 tb_resource.parent_id
	 * 
	 * @return 返回 tb_resource.parent_id
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * setter方法 tb_resource.parent_id
	 * 
	 * @param parentId
	 *            赋值 tb_resource.parent_id
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId == null ? null : parentId.trim();
	}

	/**
	 * 所属表字段为 tb_resource.auth_name
	 * 
	 * @return 返回 tb_resource.auth_name
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public String getAuthName() {
		return authName;
	}

	/**
	 * setter方法 tb_resource.auth_name
	 * 
	 * @param authName
	 *            赋值 tb_resource.auth_name
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public void setAuthName(String authName) {
		this.authName = authName == null ? null : authName.trim();
	}

	/**
	 * 所属表字段为 tb_resource.path
	 * 
	 * @return 返回 tb_resource.path
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public String getPath() {
		return path;
	}

	/**
	 * setter方法 tb_resource.path
	 * 
	 * @param path
	 *            赋值 tb_resource.path
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	public static enum ResourceType {
		menu("菜单"), button("按钮");

		private final String info;

		private ResourceType(String info) {
			this.info = info;
		}

		public String getInfo() {
			return info;
		}
	}

	public String getText() {
		return name;
	}
	
	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public List<Resource> getChildren() {
		return children;
	}

	public void setChildren(List<Resource> children) {
		this.children = children;
	}
}