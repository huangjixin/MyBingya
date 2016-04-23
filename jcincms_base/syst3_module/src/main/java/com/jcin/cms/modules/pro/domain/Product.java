package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Product implements Serializable {
    /**
     *   所属表字段为pro_product.id
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    private String id;

    /**
     *  产品名称 所属表字段为pro_product.name
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    private String name;

    /**
     *  品牌ID 所属表字段为pro_product.pro_brand_id
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    private String proBrandId;

    /**
     *  创建日期 所属表字段为pro_product.create_date
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  修改日期 所属表字段为pro_product.update_date
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为pro_product.assets
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    private String assets;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_product.id
     *
     * @return 返回 pro_product.id
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 pro_product.id
     *
     * @param id 赋值 pro_product.id
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 pro_product.name
     *
     * @return 返回 pro_product.name
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 pro_product.name
     *
     * @param name 赋值 pro_product.name
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 pro_product.pro_brand_id
     *
     * @return 返回 pro_product.pro_brand_id
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public String getProBrandId() {
        return proBrandId;
    }

    /**
     * setter方法 pro_product.pro_brand_id
     *
     * @param proBrandId 赋值 pro_product.pro_brand_id
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public void setProBrandId(String proBrandId) {
        this.proBrandId = proBrandId == null ? null : proBrandId.trim();
    }

    /**
     * 所属表字段为 pro_product.create_date
     *
     * @return 返回 pro_product.create_date
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 pro_product.create_date
     *
     * @param createDate 赋值 pro_product.create_date
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 pro_product.update_date
     *
     * @return 返回 pro_product.update_date
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 pro_product.update_date
     *
     * @param updateDate 赋值 pro_product.update_date
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 pro_product.assets
     *
     * @return 返回 pro_product.assets
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public String getAssets() {
        return assets;
    }

    /**
     * setter方法 pro_product.assets
     *
     * @param assets 赋值 pro_product.assets
     *
     * @mbggenerated 2016年04月23日 16时46分46秒 星期六
     */
    public void setAssets(String assets) {
        this.assets = assets == null ? null : assets.trim();
    }
}