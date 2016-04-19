package com.jcin.cms.modules.pro.domain;

import java.io.Serializable;

public class BrandWithBLOBs extends Brand implements Serializable {
    /**
     *   所属表字段为pro_brand.description
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String description;

    /**
     *  品牌故事 所属表字段为pro_brand.story
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String story;

    /**
     * 该字段对应数据库表 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_brand.description
     *
     * @return 返回 pro_brand.description
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 pro_brand.description
     *
     * @param description 赋值 pro_brand.description
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 所属表字段为 pro_brand.story
     *
     * @return 返回 pro_brand.story
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getStory() {
        return story;
    }

    /**
     * setter方法 pro_brand.story
     *
     * @param story 赋值 pro_brand.story
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setStory(String story) {
        this.story = story == null ? null : story.trim();
    }
}