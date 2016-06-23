package com.jcin.cms.modules.syst.domain;

import java.io.Serializable;

public class OrganizationResource implements Serializable {
    /**
     *   所属表字段为tb_organization_resource.id
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    private String id;

    /**
     *   所属表字段为tb_organization_resource.organization_id
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    private String organizationId;

    /**
     *   所属表字段为tb_organization_resource.resource_id
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    private String resourceId;

    /**
     * 该字段对应数据库表 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_organization_resource.id
     *
     * @return 返回 tb_organization_resource.id
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_organization_resource.id
     *
     * @param id 赋值 tb_organization_resource.id
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_organization_resource.organization_id
     *
     * @return 返回 tb_organization_resource.organization_id
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
     * setter方法 tb_organization_resource.organization_id
     *
     * @param organizationId 赋值 tb_organization_resource.organization_id
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }

    /**
     * 所属表字段为 tb_organization_resource.resource_id
     *
     * @return 返回 tb_organization_resource.resource_id
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * setter方法 tb_organization_resource.resource_id
     *
     * @param resourceId 赋值 tb_organization_resource.resource_id
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }
}