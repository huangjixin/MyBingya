package com.jcin.cms.domain.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Menu implements Serializable {
    /**
     *   所属表字段为tb_menu.id
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    private String id;

    /**
     *   所属表字段为tb_menu.name
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    private String name;

    /**
     *   所属表字段为tb_menu.description
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    private String description;

    /**
     *   所属表字段为tb_menu.path
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    private String path;

    /**
     *   所属表字段为tb_menu.parent_id
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    private String parentId;

    /**
     *   所属表字段为tb_menu.create_date
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_menu.icon
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    private String icon;

    /**
     *   所属表字段为tb_menu.update_date
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为tb_menu.url
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    private String url;
    
    private List<Menu> children = new ArrayList<Menu>();

    /**
     * 该字段对应数据库表 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_menu.id
     *
     * @return 返回 tb_menu.id
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_menu.id
     *
     * @param id 赋值 tb_menu.id
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_menu.name
     *
     * @return 返回 tb_menu.name
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_menu.name
     *
     * @param name 赋值 tb_menu.name
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_menu.description
     *
     * @return 返回 tb_menu.description
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_menu.description
     *
     * @param description 赋值 tb_menu.description
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 所属表字段为 tb_menu.path
     *
     * @return 返回 tb_menu.path
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public String getPath() {
        return path;
    }

    /**
     * setter方法 tb_menu.path
     *
     * @param path 赋值 tb_menu.path
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 所属表字段为 tb_menu.parent_id
     *
     * @return 返回 tb_menu.parent_id
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * setter方法 tb_menu.parent_id
     *
     * @param parentId 赋值 tb_menu.parent_id
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 所属表字段为 tb_menu.create_date
     *
     * @return 返回 tb_menu.create_date
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_menu.create_date
     *
     * @param createDate 赋值 tb_menu.create_date
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_menu.icon
     *
     * @return 返回 tb_menu.icon
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public String getIcon() {
        return icon;
    }

    /**
     * setter方法 tb_menu.icon
     *
     * @param icon 赋值 tb_menu.icon
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 所属表字段为 tb_menu.update_date
     *
     * @return 返回 tb_menu.update_date
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_menu.update_date
     *
     * @param updateDate 赋值 tb_menu.update_date
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_menu.url
     *
     * @return 返回 tb_menu.url
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public String getUrl() {
        return url;
    }

    /**
     * setter方法 tb_menu.url
     *
     * @param url 赋值 tb_menu.url
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}
}