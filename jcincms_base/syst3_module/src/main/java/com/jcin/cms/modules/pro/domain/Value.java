package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Value implements Serializable {
    /**
     *   所属表字段为pro_value.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String id;

    /**
     *  属性值名称 所属表字段为pro_value.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String name;

    /**
     *  属性名ID 所属表字段为pro_value.pro_properties_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String proPropertiesId;

    /**
     *   所属表字段为pro_value.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String status;

    /**
     *  产品类目ID 所属表字段为pro_value.pro_category_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String proCategoryId;

    /**
     *  排序id 所属表字段为pro_value.sortid
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private Integer sortid;

    /**
     *  创建日期 所属表字段为pro_value.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  修改日期 所属表字段为pro_value.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     * 该字段对应数据库表 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_value.id
     *
     * @return 返回 pro_value.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 pro_value.id
     *
     * @param id 赋值 pro_value.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 pro_value.name
     *
     * @return 返回 pro_value.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 pro_value.name
     *
     * @param name 赋值 pro_value.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 pro_value.pro_properties_id
     *
     * @return 返回 pro_value.pro_properties_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getProPropertiesId() {
        return proPropertiesId;
    }

    /**
     * setter方法 pro_value.pro_properties_id
     *
     * @param proPropertiesId 赋值 pro_value.pro_properties_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setProPropertiesId(String proPropertiesId) {
        this.proPropertiesId = proPropertiesId == null ? null : proPropertiesId.trim();
    }

    /**
     * 所属表字段为 pro_value.status
     *
     * @return 返回 pro_value.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getStatus() {
        return status;
    }

    /**
     * setter方法 pro_value.status
     *
     * @param status 赋值 pro_value.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 所属表字段为 pro_value.pro_category_id
     *
     * @return 返回 pro_value.pro_category_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getProCategoryId() {
        return proCategoryId;
    }

    /**
     * setter方法 pro_value.pro_category_id
     *
     * @param proCategoryId 赋值 pro_value.pro_category_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setProCategoryId(String proCategoryId) {
        this.proCategoryId = proCategoryId == null ? null : proCategoryId.trim();
    }

    /**
     * 所属表字段为 pro_value.sortid
     *
     * @return 返回 pro_value.sortid
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Integer getSortid() {
        return sortid;
    }

    /**
     * setter方法 pro_value.sortid
     *
     * @param sortid 赋值 pro_value.sortid
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    /**
     * 所属表字段为 pro_value.create_date
     *
     * @return 返回 pro_value.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 pro_value.create_date
     *
     * @param createDate 赋值 pro_value.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 pro_value.update_date
     *
     * @return 返回 pro_value.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 pro_value.update_date
     *
     * @param updateDate 赋值 pro_value.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}