package com.jcin.cms.modules.syst.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Resource implements Serializable {
	/**
	 * 所属表字段为tb_resource.id
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	private String id;

	/**
	 * 菜单名 所属表字段为tb_resource.name
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	private String name;

	/**
	 * 父亲节点集，用逗号分开 所属表字段为tb_resource.parentids
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	private String parentids;

	/**
	 * 父亲节点 所属表字段为tb_resource.parent_id
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	private String parentId;

	/**
	 * 权限名称 所属表字段为tb_resource.auth_name
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	private String authName;

	/**
	 * 访问路径，以“/”开头 所属表字段为tb_resource.path
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	private String path;

	/**
	 * 创建日期 所属表字段为tb_resource.create_date
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;

	/**
	 * 更新日期 所属表字段为tb_resource.update_date
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;

	/**
	 * 创建人 所属表字段为tb_resource.create_by
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	private String createBy;

	/**
	 * 更新人 所属表字段为tb_resource.update_by
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	private String updateBy;

	/**
	 * 该字段对应数据库表 tb_resource
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 所属表字段为 tb_resource.id
	 * 
	 * @return 返回 tb_resource.id
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
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
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * 所属表字段为 tb_resource.name
	 * 
	 * @return 返回 tb_resource.name
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
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
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 所属表字段为 tb_resource.parentids
	 * 
	 * @return 返回 tb_resource.parentids
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
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
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public void setParentids(String parentids) {
		this.parentids = parentids == null ? null : parentids.trim();
	}

	/**
	 * 所属表字段为 tb_resource.parent_id
	 * 
	 * @return 返回 tb_resource.parent_id
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
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
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId == null ? null : parentId.trim();
	}

	/**
	 * 所属表字段为 tb_resource.auth_name
	 * 
	 * @return 返回 tb_resource.auth_name
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
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
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public void setAuthName(String authName) {
		this.authName = authName == null ? null : authName.trim();
	}

	/**
	 * 所属表字段为 tb_resource.path
	 * 
	 * @return 返回 tb_resource.path
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
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
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	/**
	 * 所属表字段为 tb_resource.create_date
	 * 
	 * @return 返回 tb_resource.create_date
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * setter方法 tb_resource.create_date
	 * 
	 * @param createDate
	 *            赋值 tb_resource.create_date
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 所属表字段为 tb_resource.update_date
	 * 
	 * @return 返回 tb_resource.update_date
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * setter方法 tb_resource.update_date
	 * 
	 * @param updateDate
	 *            赋值 tb_resource.update_date
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 所属表字段为 tb_resource.create_by
	 * 
	 * @return 返回 tb_resource.create_by
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * setter方法 tb_resource.create_by
	 * 
	 * @param createBy
	 *            赋值 tb_resource.create_by
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	/**
	 * 所属表字段为 tb_resource.update_by
	 * 
	 * @return 返回 tb_resource.update_by
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * setter方法 tb_resource.update_by
	 * 
	 * @param updateBy
	 *            赋值 tb_resource.update_by
	 * 
	 * @mbggenerated 2015年12月13日 10时47分30秒 星期日
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

	/**
	 * 所属表字段为tb_resource.type
	 * 
	 * @mbggenerated 2015年09月29日 16时42分33秒 星期二
	 */
	private ResourceType type = ResourceType.menu; // 资源类型

	private List<Resource> children = new ArrayList<Resource>();

	private boolean checked;
	
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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}


}