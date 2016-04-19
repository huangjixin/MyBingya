package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class Sku implements Serializable {
    /**
     *   所属表字段为pro_sku.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String id;

    /**
     *  产品ID 所属表字段为pro_sku.product_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String productId;

    /**
     *  数量 所属表字段为pro_sku.counts
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private Integer counts;

    /**
     *   所属表字段为pro_sku.price
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private Double price;

    /**
     *  sku名称 所属表字段为pro_sku.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String name;

    /**
     *   所属表字段为pro_sku.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String status;

    /**
     * 该字段对应数据库表 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_sku.id
     *
     * @return 返回 pro_sku.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 pro_sku.id
     *
     * @param id 赋值 pro_sku.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 pro_sku.product_id
     *
     * @return 返回 pro_sku.product_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getProductId() {
        return productId;
    }

    /**
     * setter方法 pro_sku.product_id
     *
     * @param productId 赋值 pro_sku.product_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * 所属表字段为 pro_sku.counts
     *
     * @return 返回 pro_sku.counts
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Integer getCounts() {
        return counts;
    }

    /**
     * setter方法 pro_sku.counts
     *
     * @param counts 赋值 pro_sku.counts
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    /**
     * 所属表字段为 pro_sku.price
     *
     * @return 返回 pro_sku.price
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Double getPrice() {
        return price;
    }

    /**
     * setter方法 pro_sku.price
     *
     * @param price 赋值 pro_sku.price
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 所属表字段为 pro_sku.name
     *
     * @return 返回 pro_sku.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 pro_sku.name
     *
     * @param name 赋值 pro_sku.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 pro_sku.status
     *
     * @return 返回 pro_sku.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getStatus() {
        return status;
    }

    /**
     * setter方法 pro_sku.status
     *
     * @param status 赋值 pro_sku.status
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}