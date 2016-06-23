package com.jcin.cms.modules.syst.domain;

import java.io.Serializable;

public class Menu implements Serializable {
    /**
     *   所属表字段为tb_menu.id
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    private String id;

    /**
     *  菜单名 所属表字段为tb_menu.name
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    private String name;

    /**
     *  父亲节点集，用逗号分开 所属表字段为tb_menu.parentids
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    private String parentids;

    /**
     *  父亲节点 所属表字段为tb_menu.parent_id
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    private String parentId;

    /**
     *  权限名称 所属表字段为tb_menu.auth_name
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    private String authName;

    /**
     *  访问路径，以“/”开头 所属表字段为tb_menu.path
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    private String path;

    /**
     * 该字段对应数据库表 tb_menu
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_menu.id
     *
     * @return 返回 tb_menu.id
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_menu.id
     *
     * @param id 赋值 tb_menu.id
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_menu.name
     *
     * @return 返回 tb_menu.name
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_menu.name
     *
     * @param name 赋值 tb_menu.name
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_menu.parentids
     *
     * @return 返回 tb_menu.parentids
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public String getParentids() {
        return parentids;
    }

    /**
     * setter方法 tb_menu.parentids
     *
     * @param parentids 赋值 tb_menu.parentids
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public void setParentids(String parentids) {
        this.parentids = parentids == null ? null : parentids.trim();
    }

    /**
     * 所属表字段为 tb_menu.parent_id
     *
     * @return 返回 tb_menu.parent_id
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * setter方法 tb_menu.parent_id
     *
     * @param parentId 赋值 tb_menu.parent_id
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 所属表字段为 tb_menu.auth_name
     *
     * @return 返回 tb_menu.auth_name
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public String getAuthName() {
        return authName;
    }

    /**
     * setter方法 tb_menu.auth_name
     *
     * @param authName 赋值 tb_menu.auth_name
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public void setAuthName(String authName) {
        this.authName = authName == null ? null : authName.trim();
    }

    /**
     * 所属表字段为 tb_menu.path
     *
     * @return 返回 tb_menu.path
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public String getPath() {
        return path;
    }

    /**
     * setter方法 tb_menu.path
     *
     * @param path 赋值 tb_menu.path
     *
     * @mbggenerated 2015年09月28日 15时16分36秒 星期一
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
}