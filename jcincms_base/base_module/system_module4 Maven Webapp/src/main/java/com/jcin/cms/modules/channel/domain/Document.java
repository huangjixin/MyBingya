package com.jcin.cms.modules.channel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class Document implements Serializable {
    /**
     *   所属表字段为busi_document.id
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String id;

    /**
     *   所属表字段为busi_document.channel_id
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String channelId;

    /**
     *  标题 所属表字段为busi_document.title
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String title;

    /**
     *  颜色 所属表字段为busi_document.color
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String color;

    /**
     *  关键词 所属表字段为busi_document.keyword
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String keyword;

    /**
     *  描述 所属表字段为busi_document.descrition
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String descrition;

    /**
     *  优先级 所属表字段为busi_document.priority
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private Integer priority;

    /**
     *  来源 所属表字段为busi_document.source
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String source;

    /**
     *  来源地址 所属表字段为busi_document.source_addr
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String sourceAddr;

    /**
     *  作者 所属表字段为busi_document.author
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String author;

    /**
     *  标题图片 所属表字段为busi_document.title_image
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String titleImage;

    /**
     *   所属表字段为busi_document.file_name
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String fileName;

    /**
     *   所属表字段为busi_document.file_addr
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String fileAddr;

    /**
     *  文件大小 所属表字段为busi_document.size
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private Long size;

    /**
     *  内容 所属表字段为busi_document.content
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String content;

    /**
     *  文档模板 所属表字段为busi_document.document_templete
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String documentTemplete;

    /**
     *  是否显示 所属表字段为busi_document.hidden
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private Boolean hidden;

    /**
     *   所属表字段为busi_document.assets_ids
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private String assetsIds;

    /**
     *  是否推荐 所属表字段为busi_document.recommend
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private Boolean recommend=false;

    /**
     * 该字段对应数据库表 busi_document
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 busi_document.id
     *
     * @return 返回 busi_document.id
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 busi_document.id
     *
     * @param id 赋值 busi_document.id
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 busi_document.channel_id
     *
     * @return 返回 busi_document.channel_id
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * setter方法 busi_document.channel_id
     *
     * @param channelId 赋值 busi_document.channel_id
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 所属表字段为 busi_document.title
     *
     * @return 返回 busi_document.title
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getTitle() {
        return title;
    }

    /**
     * setter方法 busi_document.title
     *
     * @param title 赋值 busi_document.title
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 所属表字段为 busi_document.color
     *
     * @return 返回 busi_document.color
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getColor() {
        return color;
    }

    /**
     * setter方法 busi_document.color
     *
     * @param color 赋值 busi_document.color
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    /**
     * 所属表字段为 busi_document.keyword
     *
     * @return 返回 busi_document.keyword
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * setter方法 busi_document.keyword
     *
     * @param keyword 赋值 busi_document.keyword
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * 所属表字段为 busi_document.descrition
     *
     * @return 返回 busi_document.descrition
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getDescrition() {
        return descrition;
    }

    /**
     * setter方法 busi_document.descrition
     *
     * @param descrition 赋值 busi_document.descrition
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setDescrition(String descrition) {
        this.descrition = descrition == null ? null : descrition.trim();
    }

    /**
     * 所属表字段为 busi_document.priority
     *
     * @return 返回 busi_document.priority
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * setter方法 busi_document.priority
     *
     * @param priority 赋值 busi_document.priority
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 所属表字段为 busi_document.source
     *
     * @return 返回 busi_document.source
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getSource() {
        return source;
    }

    /**
     * setter方法 busi_document.source
     *
     * @param source 赋值 busi_document.source
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 所属表字段为 busi_document.source_addr
     *
     * @return 返回 busi_document.source_addr
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getSourceAddr() {
        return sourceAddr;
    }

    /**
     * setter方法 busi_document.source_addr
     *
     * @param sourceAddr 赋值 busi_document.source_addr
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setSourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr == null ? null : sourceAddr.trim();
    }

    /**
     * 所属表字段为 busi_document.author
     *
     * @return 返回 busi_document.author
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getAuthor() {
        return author;
    }

    /**
     * setter方法 busi_document.author
     *
     * @param author 赋值 busi_document.author
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 所属表字段为 busi_document.title_image
     *
     * @return 返回 busi_document.title_image
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getTitleImage() {
        return titleImage;
    }

    /**
     * setter方法 busi_document.title_image
     *
     * @param titleImage 赋值 busi_document.title_image
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage == null ? null : titleImage.trim();
    }

    /**
     * 所属表字段为 busi_document.file_name
     *
     * @return 返回 busi_document.file_name
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * setter方法 busi_document.file_name
     *
     * @param fileName 赋值 busi_document.file_name
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 所属表字段为 busi_document.file_addr
     *
     * @return 返回 busi_document.file_addr
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getFileAddr() {
        return fileAddr;
    }

    /**
     * setter方法 busi_document.file_addr
     *
     * @param fileAddr 赋值 busi_document.file_addr
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setFileAddr(String fileAddr) {
        this.fileAddr = fileAddr == null ? null : fileAddr.trim();
    }

    /**
     * 所属表字段为 busi_document.size
     *
     * @return 返回 busi_document.size
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public Long getSize() {
        return size;
    }

    /**
     * setter方法 busi_document.size
     *
     * @param size 赋值 busi_document.size
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * 所属表字段为 busi_document.content
     *
     * @return 返回 busi_document.content
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getContent() {
        return content;
    }

    /**
     * setter方法 busi_document.content
     *
     * @param content 赋值 busi_document.content
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 所属表字段为 busi_document.document_templete
     *
     * @return 返回 busi_document.document_templete
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getDocumentTemplete() {
        return documentTemplete;
    }

    /**
     * setter方法 busi_document.document_templete
     *
     * @param documentTemplete 赋值 busi_document.document_templete
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setDocumentTemplete(String documentTemplete) {
        this.documentTemplete = documentTemplete == null ? null : documentTemplete.trim();
    }

    /**
     * 所属表字段为 busi_document.hidden
     *
     * @return 返回 busi_document.hidden
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public Boolean getHidden() {
        return hidden;
    }

    /**
     * setter方法 busi_document.hidden
     *
     * @param hidden 赋值 busi_document.hidden
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * 所属表字段为 busi_document.assets_ids
     *
     * @return 返回 busi_document.assets_ids
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public String getAssetsIds() {
        return assetsIds;
    }

    /**
     * setter方法 busi_document.assets_ids
     *
     * @param assetsIds 赋值 busi_document.assets_ids
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setAssetsIds(String assetsIds) {
        this.assetsIds = assetsIds == null ? null : assetsIds.trim();
    }

    /**
     * 所属表字段为 busi_document.recommend
     *
     * @return 返回 busi_document.recommend
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * setter方法 busi_document.recommend
     *
     * @param recommend 赋值 busi_document.recommend
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }
}