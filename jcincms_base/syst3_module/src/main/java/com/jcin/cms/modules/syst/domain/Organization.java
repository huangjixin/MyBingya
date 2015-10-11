package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Organization implements Serializable {
    /**
     *   所属表字段为tb_organization.id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    private String id;

    /**
     *   所属表字段为tb_organization.name
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    private String name;

    /**
     *   所属表字段为tb_organization.parent_id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    private String parentId;

    /**
     *   所属表字段为tb_organization.parent_ids
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    private String parentIds;

    /**
     *   所属表字段为tb_organization.available
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    private Boolean available;

    /**
     *   所属表字段为tb_organization.create_date
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_organization.update_date
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     * 该字段对应数据库表 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_organization.id
     *
     * @return 返回 tb_organization.id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_organization.id
     *
     * @param id 赋值 tb_organization.id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_organization.name
     *
     * @return 返回 tb_organization.name
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_organization.name
     *
     * @param name 赋值 tb_organization.name
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_organization.parent_id
     *
     * @return 返回 tb_organization.parent_id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * setter方法 tb_organization.parent_id
     *
     * @param parentId 赋值 tb_organization.parent_id
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 所属表字段为 tb_organization.parent_ids
     *
     * @return 返回 tb_organization.parent_ids
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * setter方法 tb_organization.parent_ids
     *
     * @param parentIds 赋值 tb_organization.parent_ids
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    /**
     * 所属表字段为 tb_organization.available
     *
     * @return 返回 tb_organization.available
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * setter方法 tb_organization.available
     *
     * @param available 赋值 tb_organization.available
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    /**
     * 所属表字段为 tb_organization.create_date
     *
     * @return 返回 tb_organization.create_date
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_organization.create_date
     *
     * @param createDate 赋值 tb_organization.create_date
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_organization.update_date
     *
     * @return 返回 tb_organization.update_date
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_organization.update_date
     *
     * @param updateDate 赋值 tb_organization.update_date
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}