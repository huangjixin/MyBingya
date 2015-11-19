package com.jcin.cms.modules.channel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Comment implements Serializable {
    /**
     *   所属表字段为busi_comment.id
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    private String id;

    /**
     *   所属表字段为busi_comment.document_id
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    private String documentId;

    /**
     *   所属表字段为busi_comment.create_date
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为busi_comment.update_date
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为busi_comment.content
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    private String content;

    /**
     *   所属表字段为busi_comment.parent_ids
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    private String parentIds;

    /**
     *   所属表字段为busi_comment.parent_id
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    private String parentId;

    /**
     *   所属表字段为busi_comment.hidden
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    private Boolean hidden;

    /**
     * 该字段对应数据库表 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 busi_comment.id
     *
     * @return 返回 busi_comment.id
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 busi_comment.id
     *
     * @param id 赋值 busi_comment.id
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 busi_comment.document_id
     *
     * @return 返回 busi_comment.document_id
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * setter方法 busi_comment.document_id
     *
     * @param documentId 赋值 busi_comment.document_id
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId == null ? null : documentId.trim();
    }

    /**
     * 所属表字段为 busi_comment.create_date
     *
     * @return 返回 busi_comment.create_date
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 busi_comment.create_date
     *
     * @param createDate 赋值 busi_comment.create_date
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 busi_comment.update_date
     *
     * @return 返回 busi_comment.update_date
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 busi_comment.update_date
     *
     * @param updateDate 赋值 busi_comment.update_date
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 busi_comment.content
     *
     * @return 返回 busi_comment.content
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public String getContent() {
        return content;
    }

    /**
     * setter方法 busi_comment.content
     *
     * @param content 赋值 busi_comment.content
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 所属表字段为 busi_comment.parent_ids
     *
     * @return 返回 busi_comment.parent_ids
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * setter方法 busi_comment.parent_ids
     *
     * @param parentIds 赋值 busi_comment.parent_ids
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    /**
     * 所属表字段为 busi_comment.parent_id
     *
     * @return 返回 busi_comment.parent_id
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * setter方法 busi_comment.parent_id
     *
     * @param parentId 赋值 busi_comment.parent_id
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 所属表字段为 busi_comment.hidden
     *
     * @return 返回 busi_comment.hidden
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public Boolean getHidden() {
        return hidden;
    }

    /**
     * setter方法 busi_comment.hidden
     *
     * @param hidden 赋值 busi_comment.hidden
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }
}