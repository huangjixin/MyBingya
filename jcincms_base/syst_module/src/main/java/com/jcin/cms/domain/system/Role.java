package com.jcin.cms.domain.system;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    /**
     *   所属表字段为tb_role.id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    private String id;

    /**
     *   所属表字段为tb_role.name
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    private String name;

    /**
     *   所属表字段为tb_role.description
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    private String description;

    /**
     *   所属表字段为tb_role.create_date
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    private Date createDate;

    /**
     *   所属表字段为tb_role.update_date
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    private Date updateDate;

    /**
     * 该字段对应数据库表 tb_role
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_role.id
     *
     * @return 返回 tb_role.id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_role.id
     *
     * @param id 赋值 tb_role.id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_role.name
     *
     * @return 返回 tb_role.name
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_role.name
     *
     * @param name 赋值 tb_role.name
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_role.description
     *
     * @return 返回 tb_role.description
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_role.description
     *
     * @param description 赋值 tb_role.description
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 所属表字段为 tb_role.create_date
     *
     * @return 返回 tb_role.create_date
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_role.create_date
     *
     * @param createDate 赋值 tb_role.create_date
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_role.update_date
     *
     * @return 返回 tb_role.update_date
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_role.update_date
     *
     * @param updateDate 赋值 tb_role.update_date
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}