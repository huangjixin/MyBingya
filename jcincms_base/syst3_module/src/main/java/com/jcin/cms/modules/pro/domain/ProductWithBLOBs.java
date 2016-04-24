package com.jcin.cms.modules.pro.domain;

import java.io.Serializable;

public class ProductWithBLOBs extends Product implements Serializable {
    /**
     *   所属表字段为pro_product.content
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    private String content;

    /**
     *   所属表字段为pro_product.description
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    private String description;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_product.content
     *
     * @return 返回 pro_product.content
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    public String getContent() {
        return content;
    }

    /**
     * setter方法 pro_product.content
     *
     * @param content 赋值 pro_product.content
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 所属表字段为 pro_product.description
     *
     * @return 返回 pro_product.description
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 pro_product.description
     *
     * @param description 赋值 pro_product.description
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}