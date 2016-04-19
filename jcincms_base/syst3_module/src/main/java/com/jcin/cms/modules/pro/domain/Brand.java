package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Brand implements Serializable {
    /**
     *   所属表字段为pro_brand.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String id;

    /**
     *  产品类目ID 所属表字段为pro_brand.pro_category_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String proCategoryId;

    /**
     *  中文名称 所属表字段为pro_brand.zh_name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String zhName;

    /**
     *  英文名称 所属表字段为pro_brand.en_name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String enName;

    /**
     *   所属表字段为pro_brand.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String status;

    /**
     *  品牌官方地址 所属表字段为pro_brand.website
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String website;

    /**
     *  修改日期 所属表字段为pro_brand.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *  创建日期 所属表字段为pro_brand.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     * 该字段对应数据库表 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_brand.id
     *
     * @return 返回 pro_brand.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 pro_brand.id
     *
     * @param id 赋值 pro_brand.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 pro_brand.pro_category_id
     *
     * @return 返回 pro_brand.pro_category_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getProCategoryId() {
        return proCategoryId;
    }

    /**
     * setter方法 pro_brand.pro_category_id
     *
     * @param proCategoryId 赋值 pro_brand.pro_category_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setProCategoryId(String proCategoryId) {
        this.proCategoryId = proCategoryId == null ? null : proCategoryId.trim();
    }

    /**
     * 所属表字段为 pro_brand.zh_name
     *
     * @return 返回 pro_brand.zh_name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getZhName() {
        return zhName;
    }

    /**
     * setter方法 pro_brand.zh_name
     *
     * @param zhName 赋值 pro_brand.zh_name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setZhName(String zhName) {
        this.zhName = zhName == null ? null : zhName.trim();
    }

    /**
     * 所属表字段为 pro_brand.en_name
     *
     * @return 返回 pro_brand.en_name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getEnName() {
        return enName;
    }

    /**
     * setter方法 pro_brand.en_name
     *
     * @param enName 赋值 pro_brand.en_name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    /**
     * 所属表字段为 pro_brand.status
     *
     * @return 返回 pro_brand.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getStatus() {
        return status;
    }

    /**
     * setter方法 pro_brand.status
     *
     * @param status 赋值 pro_brand.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 所属表字段为 pro_brand.website
     *
     * @return 返回 pro_brand.website
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getWebsite() {
        return website;
    }

    /**
     * setter方法 pro_brand.website
     *
     * @param website 赋值 pro_brand.website
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    /**
     * 所属表字段为 pro_brand.update_date
     *
     * @return 返回 pro_brand.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 pro_brand.update_date
     *
     * @param updateDate 赋值 pro_brand.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 pro_brand.create_date
     *
     * @return 返回 pro_brand.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 pro_brand.create_date
     *
     * @param createDate 赋值 pro_brand.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}