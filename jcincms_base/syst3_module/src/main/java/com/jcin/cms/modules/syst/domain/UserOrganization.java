package com.jcin.cms.modules.syst.domain;

import java.io.Serializable;

public class UserOrganization implements Serializable {
    /**
     *   所属表字段为tb_user_organization.id
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    private String id;

    /**
     *   所属表字段为tb_user_organization.user_id
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    private String userId;

    /**
     *   所属表字段为tb_user_organization.organization_id
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    private String organizationId;

    /**
     * 该字段对应数据库表 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_user_organization.id
     *
     * @return 返回 tb_user_organization.id
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_user_organization.id
     *
     * @param id 赋值 tb_user_organization.id
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_user_organization.user_id
     *
     * @return 返回 tb_user_organization.user_id
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    public String getUserId() {
        return userId;
    }

    /**
     * setter方法 tb_user_organization.user_id
     *
     * @param userId 赋值 tb_user_organization.user_id
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 所属表字段为 tb_user_organization.organization_id
     *
     * @return 返回 tb_user_organization.organization_id
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
     * setter方法 tb_user_organization.organization_id
     *
     * @param organizationId 赋值 tb_user_organization.organization_id
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }
}