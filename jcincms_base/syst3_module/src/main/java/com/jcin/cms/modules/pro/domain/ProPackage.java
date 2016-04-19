package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class ProPackage implements Serializable {
    /**
     *   所属表字段为pro_package.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String id;

    /**
     *   所属表字段为pro_package.sku_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String skuId;

    /**
     *  数量 所属表字段为pro_package.counts
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private Integer counts;

    /**
     *  价格 所属表字段为pro_package.price
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private Double price;

    /**
     *  创建日期 所属表字段为pro_package.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  修改日期 所属表字段为pro_package.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     * 该字段对应数据库表 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_package.id
     *
     * @return 返回 pro_package.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 pro_package.id
     *
     * @param id 赋值 pro_package.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 pro_package.sku_id
     *
     * @return 返回 pro_package.sku_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * setter方法 pro_package.sku_id
     *
     * @param skuId 赋值 pro_package.sku_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId == null ? null : skuId.trim();
    }

    /**
     * 所属表字段为 pro_package.counts
     *
     * @return 返回 pro_package.counts
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Integer getCounts() {
        return counts;
    }

    /**
     * setter方法 pro_package.counts
     *
     * @param counts 赋值 pro_package.counts
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    /**
     * 所属表字段为 pro_package.price
     *
     * @return 返回 pro_package.price
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Double getPrice() {
        return price;
    }

    /**
     * setter方法 pro_package.price
     *
     * @param price 赋值 pro_package.price
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 所属表字段为 pro_package.create_date
     *
     * @return 返回 pro_package.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 pro_package.create_date
     *
     * @param createDate 赋值 pro_package.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 pro_package.update_date
     *
     * @return 返回 pro_package.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 pro_package.update_date
     *
     * @param updateDate 赋值 pro_package.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}