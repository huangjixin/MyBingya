package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class RoleResource implements Serializable {
    /**
     *   所属表字段为tb_role_resource.id
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    private String id;

    /**
     *   所属表字段为tb_role_resource.role_id
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    private String roleId;

    /**
     *   所属表字段为tb_role_resource.resource_id
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    private String resourceId;

    /**
     * 该字段对应数据库表 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_role_resource.id
     *
     * @return 返回 tb_role_resource.id
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_role_resource.id
     *
     * @param id 赋值 tb_role_resource.id
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_role_resource.role_id
     *
     * @return 返回 tb_role_resource.role_id
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * setter方法 tb_role_resource.role_id
     *
     * @param roleId 赋值 tb_role_resource.role_id
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * 所属表字段为 tb_role_resource.resource_id
     *
     * @return 返回 tb_role_resource.resource_id
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * setter方法 tb_role_resource.resource_id
     *
     * @param resourceId 赋值 tb_role_resource.resource_id
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }
}