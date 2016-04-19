package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Properties implements Serializable {
    /**
     *   所属表字段为pro_properties.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String id;

    /**
     *   所属表字段为pro_properties.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String name;

    /**
     *  产品类目ID 所属表字段为pro_properties.pro_category_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String proCategoryId;

    /**
     *   所属表字段为pro_properties.sortid
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private Integer sortid;

    /**
     *  创建日期 所属表字段为pro_properties.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  修改日期 所属表字段为pro_properties.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *  状态 所属表字段为pro_properties.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String status;

    /**
     * 该字段对应数据库表 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_properties.id
     *
     * @return 返回 pro_properties.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 pro_properties.id
     *
     * @param id 赋值 pro_properties.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 pro_properties.name
     *
     * @return 返回 pro_properties.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 pro_properties.name
     *
     * @param name 赋值 pro_properties.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 pro_properties.pro_category_id
     *
     * @return 返回 pro_properties.pro_category_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getProCategoryId() {
        return proCategoryId;
    }

    /**
     * setter方法 pro_properties.pro_category_id
     *
     * @param proCategoryId 赋值 pro_properties.pro_category_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setProCategoryId(String proCategoryId) {
        this.proCategoryId = proCategoryId == null ? null : proCategoryId.trim();
    }

    /**
     * 所属表字段为 pro_properties.sortid
     *
     * @return 返回 pro_properties.sortid
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Integer getSortid() {
        return sortid;
    }

    /**
     * setter方法 pro_properties.sortid
     *
     * @param sortid 赋值 pro_properties.sortid
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    /**
     * 所属表字段为 pro_properties.create_date
     *
     * @return 返回 pro_properties.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 pro_properties.create_date
     *
     * @param createDate 赋值 pro_properties.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 pro_properties.update_date
     *
     * @return 返回 pro_properties.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 pro_properties.update_date
     *
     * @param updateDate 赋值 pro_properties.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 pro_properties.status
     *
     * @return 返回 pro_properties.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getStatus() {
        return status;
    }

    /**
     * setter方法 pro_properties.status
     *
     * @param status 赋值 pro_properties.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}