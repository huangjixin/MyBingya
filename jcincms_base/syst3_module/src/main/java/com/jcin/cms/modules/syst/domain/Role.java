package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Role implements Serializable {
    /**
     *   所属表字段为tb_role.id
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    private String id;

    /**
     *   所属表字段为tb_role.name
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    private String name;

    /**
     *   所属表字段为tb_role.create_date
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_role.update_date
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为tb_role.create_by
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    private String createBy;

    /**
     *   所属表字段为tb_role.update_by
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    private String updateBy;

    /**
     * 该字段对应数据库表 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_role.id
     *
     * @return 返回 tb_role.id
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_role.id
     *
     * @param id 赋值 tb_role.id
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_role.name
     *
     * @return 返回 tb_role.name
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_role.name
     *
     * @param name 赋值 tb_role.name
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_role.create_date
     *
     * @return 返回 tb_role.create_date
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_role.create_date
     *
     * @param createDate 赋值 tb_role.create_date
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_role.update_date
     *
     * @return 返回 tb_role.update_date
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_role.update_date
     *
     * @param updateDate 赋值 tb_role.update_date
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_role.create_by
     *
     * @return 返回 tb_role.create_by
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 tb_role.create_by
     *
     * @param createBy 赋值 tb_role.create_by
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 tb_role.update_by
     *
     * @return 返回 tb_role.update_by
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * setter方法 tb_role.update_by
     *
     * @param updateBy 赋值 tb_role.update_by
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}