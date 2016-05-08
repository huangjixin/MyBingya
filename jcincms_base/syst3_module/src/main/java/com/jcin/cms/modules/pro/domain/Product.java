package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Product implements Serializable {
    /**
     *   所属表字段为pro_product.id
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String id;

    /**
     *  产品名称 所属表字段为pro_product.name
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String name;

    /**
     *  品牌ID 所属表字段为pro_product.pro_brand_id
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String proBrandId;

    /**
     *  创建日期 所属表字段为pro_product.create_date
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  修改日期 所属表字段为pro_product.update_date
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为pro_product.assets
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String assets;

    /**
     *   所属表字段为pro_product.userid
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String userid;

    /**
     *  关键字 所属表字段为pro_product.keywords
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String keywords;

    /**
     *  页面标题 所属表字段为pro_product.title
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String title;

    /**
     *  页面关键字 所属表字段为pro_product.content_keywords
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String contentKeywords;

    /**
     *  标签 所属表字段为pro_product.tags
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String tags;

    /**
     *  封面缩略图 所属表字段为pro_product.title_image
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String titleImage;

    /**
     *  商品生成模板 所属表字段为pro_product.gene_template
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String geneTemplate;

    /**
     *  移动端页面生成模板 所属表字段为pro_product.m_gene_template
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String mGeneTemplate;

    /**
     *  价格区间 所属表字段为pro_product.price
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String price;

    /**
     *  尺寸 所属表字段为pro_product.measure
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String measure;

    /**
     *  品牌名称 所属表字段为pro_product.brand_name
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String brandName;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_product.id
     *
     * @return 返回 pro_product.id
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 pro_product.id
     *
     * @param id 赋值 pro_product.id
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 pro_product.name
     *
     * @return 返回 pro_product.name
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 pro_product.name
     *
     * @param name 赋值 pro_product.name
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 pro_product.pro_brand_id
     *
     * @return 返回 pro_product.pro_brand_id
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getProBrandId() {
        return proBrandId;
    }

    /**
     * setter方法 pro_product.pro_brand_id
     *
     * @param proBrandId 赋值 pro_product.pro_brand_id
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setProBrandId(String proBrandId) {
        this.proBrandId = proBrandId == null ? null : proBrandId.trim();
    }

    /**
     * 所属表字段为 pro_product.create_date
     *
     * @return 返回 pro_product.create_date
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 pro_product.create_date
     *
     * @param createDate 赋值 pro_product.create_date
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 pro_product.update_date
     *
     * @return 返回 pro_product.update_date
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 pro_product.update_date
     *
     * @param updateDate 赋值 pro_product.update_date
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 pro_product.assets
     *
     * @return 返回 pro_product.assets
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getAssets() {
        return assets;
    }

    /**
     * setter方法 pro_product.assets
     *
     * @param assets 赋值 pro_product.assets
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setAssets(String assets) {
        this.assets = assets == null ? null : assets.trim();
    }

    /**
     * 所属表字段为 pro_product.userid
     *
     * @return 返回 pro_product.userid
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getUserid() {
        return userid;
    }

    /**
     * setter方法 pro_product.userid
     *
     * @param userid 赋值 pro_product.userid
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 所属表字段为 pro_product.keywords
     *
     * @return 返回 pro_product.keywords
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * setter方法 pro_product.keywords
     *
     * @param keywords 赋值 pro_product.keywords
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * 所属表字段为 pro_product.title
     *
     * @return 返回 pro_product.title
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getTitle() {
        return title;
    }

    /**
     * setter方法 pro_product.title
     *
     * @param title 赋值 pro_product.title
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 所属表字段为 pro_product.content_keywords
     *
     * @return 返回 pro_product.content_keywords
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getContentKeywords() {
        return contentKeywords;
    }

    /**
     * setter方法 pro_product.content_keywords
     *
     * @param contentKeywords 赋值 pro_product.content_keywords
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setContentKeywords(String contentKeywords) {
        this.contentKeywords = contentKeywords == null ? null : contentKeywords.trim();
    }

    /**
     * 所属表字段为 pro_product.tags
     *
     * @return 返回 pro_product.tags
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getTags() {
        return tags;
    }

    /**
     * setter方法 pro_product.tags
     *
     * @param tags 赋值 pro_product.tags
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * 所属表字段为 pro_product.title_image
     *
     * @return 返回 pro_product.title_image
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getTitleImage() {
        return titleImage;
    }

    /**
     * setter方法 pro_product.title_image
     *
     * @param titleImage 赋值 pro_product.title_image
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage == null ? null : titleImage.trim();
    }

    /**
     * 所属表字段为 pro_product.gene_template
     *
     * @return 返回 pro_product.gene_template
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getGeneTemplate() {
        return geneTemplate;
    }

    /**
     * setter方法 pro_product.gene_template
     *
     * @param geneTemplate 赋值 pro_product.gene_template
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setGeneTemplate(String geneTemplate) {
        this.geneTemplate = geneTemplate == null ? null : geneTemplate.trim();
    }

    /**
     * 所属表字段为 pro_product.m_gene_template
     *
     * @return 返回 pro_product.m_gene_template
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getmGeneTemplate() {
        return mGeneTemplate;
    }

    /**
     * setter方法 pro_product.m_gene_template
     *
     * @param mGeneTemplate 赋值 pro_product.m_gene_template
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setmGeneTemplate(String mGeneTemplate) {
        this.mGeneTemplate = mGeneTemplate == null ? null : mGeneTemplate.trim();
    }

    /**
     * 所属表字段为 pro_product.price
     *
     * @return 返回 pro_product.price
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getPrice() {
        return price;
    }

    /**
     * setter方法 pro_product.price
     *
     * @param price 赋值 pro_product.price
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     * 所属表字段为 pro_product.measure
     *
     * @return 返回 pro_product.measure
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getMeasure() {
        return measure;
    }

    /**
     * setter方法 pro_product.measure
     *
     * @param measure 赋值 pro_product.measure
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setMeasure(String measure) {
        this.measure = measure == null ? null : measure.trim();
    }

    /**
     * 所属表字段为 pro_product.brand_name
     *
     * @return 返回 pro_product.brand_name
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * setter方法 pro_product.brand_name
     *
     * @param brandName 赋值 pro_product.brand_name
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }
}