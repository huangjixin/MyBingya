package com.jcin.cms.modules.channel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Document implements Serializable {
    /**
     *   所属表字段为busi_document.id
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String id;

    /**
     *   所属表字段为busi_document.channel_id
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String channelId;

    /**
     *  标题 所属表字段为busi_document.title
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String title;

    /**
     *  颜色 所属表字段为busi_document.color
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String color;

    /**
     *  关键词 所属表字段为busi_document.keyword
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String keyword;

    /**
     *  描述 所属表字段为busi_document.descrition
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String descrition;

    /**
     *  优先级 所属表字段为busi_document.priority
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private Integer priority;

    /**
     *  来源 所属表字段为busi_document.source
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String source;

    /**
     *  来源地址 所属表字段为busi_document.source_addr
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String sourceAddr;

    /**
     *  作者 所属表字段为busi_document.author
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String author;

    /**
     *  标题图片 所属表字段为busi_document.title_image
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String titleImage;

    /**
     *   所属表字段为busi_document.file_name
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String fileName;

    /**
     *   所属表字段为busi_document.file_addr
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String fileAddr;

    /**
     *  文件大小 所属表字段为busi_document.size
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private Long size;

    /**
     *  文档模板 所属表字段为busi_document.document_templete
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String documentTemplete;

    /**
     *  是否显示 所属表字段为busi_document.hidden
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private Boolean hidden;

    /**
     *   所属表字段为busi_document.assets_ids
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String assetsIds;

    /**
     *  是否推荐 所属表字段为busi_document.recommend
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private Boolean recommend;

    /**
     *   所属表字段为busi_document.click_count
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private Integer clickCount;

    /**
     *   所属表字段为busi_document.create_date
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为busi_document.update_date
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为busi_document.content_short
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String contentShort;

    /**
     *  移动端页面生成模板 所属表字段为busi_document.m_gene_template
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String mGeneTemplate;

    /**
     *  pc端页面生成模板 所属表字段为busi_document.gene_template
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String geneTemplate;

    /**
     *  内容 所属表字段为busi_document.content
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private String content;

    /**
     * 该字段对应数据库表 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 busi_document.id
     *
     * @return 返回 busi_document.id
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 busi_document.id
     *
     * @param id 赋值 busi_document.id
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 busi_document.channel_id
     *
     * @return 返回 busi_document.channel_id
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * setter方法 busi_document.channel_id
     *
     * @param channelId 赋值 busi_document.channel_id
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 所属表字段为 busi_document.title
     *
     * @return 返回 busi_document.title
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getTitle() {
        return title;
    }

    /**
     * setter方法 busi_document.title
     *
     * @param title 赋值 busi_document.title
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 所属表字段为 busi_document.color
     *
     * @return 返回 busi_document.color
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getColor() {
        return color;
    }

    /**
     * setter方法 busi_document.color
     *
     * @param color 赋值 busi_document.color
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    /**
     * 所属表字段为 busi_document.keyword
     *
     * @return 返回 busi_document.keyword
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * setter方法 busi_document.keyword
     *
     * @param keyword 赋值 busi_document.keyword
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * 所属表字段为 busi_document.descrition
     *
     * @return 返回 busi_document.descrition
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getDescrition() {
        return descrition;
    }

    /**
     * setter方法 busi_document.descrition
     *
     * @param descrition 赋值 busi_document.descrition
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setDescrition(String descrition) {
        this.descrition = descrition == null ? null : descrition.trim();
    }

    /**
     * 所属表字段为 busi_document.priority
     *
     * @return 返回 busi_document.priority
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * setter方法 busi_document.priority
     *
     * @param priority 赋值 busi_document.priority
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 所属表字段为 busi_document.source
     *
     * @return 返回 busi_document.source
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getSource() {
        return source;
    }

    /**
     * setter方法 busi_document.source
     *
     * @param source 赋值 busi_document.source
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 所属表字段为 busi_document.source_addr
     *
     * @return 返回 busi_document.source_addr
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getSourceAddr() {
        return sourceAddr;
    }

    /**
     * setter方法 busi_document.source_addr
     *
     * @param sourceAddr 赋值 busi_document.source_addr
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setSourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr == null ? null : sourceAddr.trim();
    }

    /**
     * 所属表字段为 busi_document.author
     *
     * @return 返回 busi_document.author
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getAuthor() {
        return author;
    }

    /**
     * setter方法 busi_document.author
     *
     * @param author 赋值 busi_document.author
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 所属表字段为 busi_document.title_image
     *
     * @return 返回 busi_document.title_image
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getTitleImage() {
        return titleImage;
    }

    /**
     * setter方法 busi_document.title_image
     *
     * @param titleImage 赋值 busi_document.title_image
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage == null ? null : titleImage.trim();
    }

    /**
     * 所属表字段为 busi_document.file_name
     *
     * @return 返回 busi_document.file_name
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * setter方法 busi_document.file_name
     *
     * @param fileName 赋值 busi_document.file_name
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 所属表字段为 busi_document.file_addr
     *
     * @return 返回 busi_document.file_addr
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getFileAddr() {
        return fileAddr;
    }

    /**
     * setter方法 busi_document.file_addr
     *
     * @param fileAddr 赋值 busi_document.file_addr
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setFileAddr(String fileAddr) {
        this.fileAddr = fileAddr == null ? null : fileAddr.trim();
    }

    /**
     * 所属表字段为 busi_document.size
     *
     * @return 返回 busi_document.size
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public Long getSize() {
        return size;
    }

    /**
     * setter方法 busi_document.size
     *
     * @param size 赋值 busi_document.size
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * 所属表字段为 busi_document.document_templete
     *
     * @return 返回 busi_document.document_templete
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getDocumentTemplete() {
        return documentTemplete;
    }

    /**
     * setter方法 busi_document.document_templete
     *
     * @param documentTemplete 赋值 busi_document.document_templete
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setDocumentTemplete(String documentTemplete) {
        this.documentTemplete = documentTemplete == null ? null : documentTemplete.trim();
    }

    /**
     * 所属表字段为 busi_document.hidden
     *
     * @return 返回 busi_document.hidden
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public Boolean getHidden() {
        return hidden;
    }

    /**
     * setter方法 busi_document.hidden
     *
     * @param hidden 赋值 busi_document.hidden
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * 所属表字段为 busi_document.assets_ids
     *
     * @return 返回 busi_document.assets_ids
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getAssetsIds() {
        return assetsIds;
    }

    /**
     * setter方法 busi_document.assets_ids
     *
     * @param assetsIds 赋值 busi_document.assets_ids
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setAssetsIds(String assetsIds) {
        this.assetsIds = assetsIds == null ? null : assetsIds.trim();
    }

    /**
     * 所属表字段为 busi_document.recommend
     *
     * @return 返回 busi_document.recommend
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * setter方法 busi_document.recommend
     *
     * @param recommend 赋值 busi_document.recommend
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * 所属表字段为 busi_document.click_count
     *
     * @return 返回 busi_document.click_count
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public Integer getClickCount() {
        return clickCount;
    }

    /**
     * setter方法 busi_document.click_count
     *
     * @param clickCount 赋值 busi_document.click_count
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * 所属表字段为 busi_document.create_date
     *
     * @return 返回 busi_document.create_date
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 busi_document.create_date
     *
     * @param createDate 赋值 busi_document.create_date
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 busi_document.update_date
     *
     * @return 返回 busi_document.update_date
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 busi_document.update_date
     *
     * @param updateDate 赋值 busi_document.update_date
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 busi_document.content_short
     *
     * @return 返回 busi_document.content_short
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getContentShort() {
        return contentShort;
    }

    /**
     * setter方法 busi_document.content_short
     *
     * @param contentShort 赋值 busi_document.content_short
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setContentShort(String contentShort) {
        this.contentShort = contentShort == null ? null : contentShort.trim();
    }

    /**
     * 所属表字段为 busi_document.m_gene_template
     *
     * @return 返回 busi_document.m_gene_template
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getmGeneTemplate() {
        return mGeneTemplate;
    }

    /**
     * setter方法 busi_document.m_gene_template
     *
     * @param mGeneTemplate 赋值 busi_document.m_gene_template
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setmGeneTemplate(String mGeneTemplate) {
        this.mGeneTemplate = mGeneTemplate == null ? null : mGeneTemplate.trim();
    }

    /**
     * 所属表字段为 busi_document.gene_template
     *
     * @return 返回 busi_document.gene_template
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getGeneTemplate() {
        return geneTemplate;
    }

    /**
     * setter方法 busi_document.gene_template
     *
     * @param geneTemplate 赋值 busi_document.gene_template
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setGeneTemplate(String geneTemplate) {
        this.geneTemplate = geneTemplate == null ? null : geneTemplate.trim();
    }

    /**
     * 所属表字段为 busi_document.content
     *
     * @return 返回 busi_document.content
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public String getContent() {
        return content;
    }

    /**
     * setter方法 busi_document.content
     *
     * @param content 赋值 busi_document.content
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    
    public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	private Channel channel;
}