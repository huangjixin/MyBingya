package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class ProductValue implements Serializable {
    /**
     *   所属表字段为pro_product_value.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String id;

    /**
     *  商品ID 所属表字段为pro_product_value.pro_product_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String proProductId;

    /**
     *  属性ID 所属表字段为pro_product_value.pro_proerties_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String proProertiesId;

    /**
     *  属性值ID 所属表字段为pro_product_value.pro_value_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String proValueId;

    /**
     *   所属表字段为pro_product_value.is_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private Byte isSku;

    /**
     *   所属表字段为pro_product_value.sku_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String skuId;

    /**
     * 该字段对应数据库表 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_product_value.id
     *
     * @return 返回 pro_product_value.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 pro_product_value.id
     *
     * @param id 赋值 pro_product_value.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 pro_product_value.pro_product_id
     *
     * @return 返回 pro_product_value.pro_product_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getProProductId() {
        return proProductId;
    }

    /**
     * setter方法 pro_product_value.pro_product_id
     *
     * @param proProductId 赋值 pro_product_value.pro_product_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setProProductId(String proProductId) {
        this.proProductId = proProductId == null ? null : proProductId.trim();
    }

    /**
     * 所属表字段为 pro_product_value.pro_proerties_id
     *
     * @return 返回 pro_product_value.pro_proerties_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getProProertiesId() {
        return proProertiesId;
    }

    /**
     * setter方法 pro_product_value.pro_proerties_id
     *
     * @param proProertiesId 赋值 pro_product_value.pro_proerties_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setProProertiesId(String proProertiesId) {
        this.proProertiesId = proProertiesId == null ? null : proProertiesId.trim();
    }

    /**
     * 所属表字段为 pro_product_value.pro_value_id
     *
     * @return 返回 pro_product_value.pro_value_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getProValueId() {
        return proValueId;
    }

    /**
     * setter方法 pro_product_value.pro_value_id
     *
     * @param proValueId 赋值 pro_product_value.pro_value_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setProValueId(String proValueId) {
        this.proValueId = proValueId == null ? null : proValueId.trim();
    }

    /**
     * 所属表字段为 pro_product_value.is_sku
     *
     * @return 返回 pro_product_value.is_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Byte getIsSku() {
        return isSku;
    }

    /**
     * setter方法 pro_product_value.is_sku
     *
     * @param isSku 赋值 pro_product_value.is_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setIsSku(Byte isSku) {
        this.isSku = isSku;
    }

    /**
     * 所属表字段为 pro_product_value.sku_id
     *
     * @return 返回 pro_product_value.sku_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * setter方法 pro_product_value.sku_id
     *
     * @param skuId 赋值 pro_product_value.sku_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId == null ? null : skuId.trim();
    }
}