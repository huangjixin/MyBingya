package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class UserOrganization implements Serializable {
    /**
     *   所属表字段为tb_user_organization.id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    private String id;

    /**
     *   所属表字段为tb_user_organization.user_id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    private String userId;

    /**
     *   所属表字段为tb_user_organization.organization_id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    private String organizationId;

    /**
     * 该字段对应数据库表 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_user_organization.id
     *
     * @return 返回 tb_user_organization.id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_user_organization.id
     *
     * @param id 赋值 tb_user_organization.id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_user_organization.user_id
     *
     * @return 返回 tb_user_organization.user_id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public String getUserId() {
        return userId;
    }

    /**
     * setter方法 tb_user_organization.user_id
     *
     * @param userId 赋值 tb_user_organization.user_id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 所属表字段为 tb_user_organization.organization_id
     *
     * @return 返回 tb_user_organization.organization_id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
     * setter方法 tb_user_organization.organization_id
     *
     * @param organizationId 赋值 tb_user_organization.organization_id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }
}