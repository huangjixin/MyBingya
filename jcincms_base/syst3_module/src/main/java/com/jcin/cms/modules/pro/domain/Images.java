package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Images implements Serializable {
    /**
     *   所属表字段为pro_images.id
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    private String id;

    /**
     *  图片地址 所属表字段为pro_images.site
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    private String site;

    /**
     *  产品ID 所属表字段为pro_images.pro_product_id
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    private String proProductId;

    /**
     *   所属表字段为pro_images.position
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    private String position;

    /**
     *   所属表字段为pro_images.sortid
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    private Integer sortid;

    /**
     *   所属表字段为pro_images.ismasterpic
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    private Byte ismasterpic;

    /**
     *  创建日期 所属表字段为pro_images.create_date
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  修改日期 所属表字段为pro_images.update_date
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *  商品名称 所属表字段为pro_images.name
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    private String name;

    /**
     * 该字段对应数据库表 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_images.id
     *
     * @return 返回 pro_images.id
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 pro_images.id
     *
     * @param id 赋值 pro_images.id
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 pro_images.site
     *
     * @return 返回 pro_images.site
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public String getSite() {
        return site;
    }

    /**
     * setter方法 pro_images.site
     *
     * @param site 赋值 pro_images.site
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    /**
     * 所属表字段为 pro_images.pro_product_id
     *
     * @return 返回 pro_images.pro_product_id
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public String getProProductId() {
        return proProductId;
    }

    /**
     * setter方法 pro_images.pro_product_id
     *
     * @param proProductId 赋值 pro_images.pro_product_id
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public void setProProductId(String proProductId) {
        this.proProductId = proProductId == null ? null : proProductId.trim();
    }

    /**
     * 所属表字段为 pro_images.position
     *
     * @return 返回 pro_images.position
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public String getPosition() {
        return position;
    }

    /**
     * setter方法 pro_images.position
     *
     * @param position 赋值 pro_images.position
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 所属表字段为 pro_images.sortid
     *
     * @return 返回 pro_images.sortid
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public Integer getSortid() {
        return sortid;
    }

    /**
     * setter方法 pro_images.sortid
     *
     * @param sortid 赋值 pro_images.sortid
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    /**
     * 所属表字段为 pro_images.ismasterpic
     *
     * @return 返回 pro_images.ismasterpic
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public Byte getIsmasterpic() {
        return ismasterpic;
    }

    /**
     * setter方法 pro_images.ismasterpic
     *
     * @param ismasterpic 赋值 pro_images.ismasterpic
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public void setIsmasterpic(Byte ismasterpic) {
        this.ismasterpic = ismasterpic;
    }

    /**
     * 所属表字段为 pro_images.create_date
     *
     * @return 返回 pro_images.create_date
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 pro_images.create_date
     *
     * @param createDate 赋值 pro_images.create_date
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 pro_images.update_date
     *
     * @return 返回 pro_images.update_date
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 pro_images.update_date
     *
     * @param updateDate 赋值 pro_images.update_date
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 pro_images.name
     *
     * @return 返回 pro_images.name
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 pro_images.name
     *
     * @param name 赋值 pro_images.name
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}