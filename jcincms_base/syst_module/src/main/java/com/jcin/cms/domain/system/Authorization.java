package com.jcin.cms.domain.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Authorization implements Serializable {
    /**
     *   所属表字段为tb_authorization.id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    private String id;

    /**
     *   所属表字段为tb_authorization.name
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    private String name;

    /**
     *   所属表字段为tb_authorization.description
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    private String description;

    /**
     *   所属表字段为tb_authorization.create_date
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_authorization.update_date
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为tb_authorization.parent_id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    private String parentId;

    /**
     *   所属表字段为tb_authorization.url
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    private String url;

    /**
     *   所属表字段为tb_authorization.parent_ids
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    private String parentIds;

    /**
     * 该字段对应数据库表 tb_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_authorization.id
     *
     * @return 返回 tb_authorization.id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_authorization.id
     *
     * @param id 赋值 tb_authorization.id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_authorization.name
     *
     * @return 返回 tb_authorization.name
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_authorization.name
     *
     * @param name 赋值 tb_authorization.name
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_authorization.description
     *
     * @return 返回 tb_authorization.description
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_authorization.description
     *
     * @param description 赋值 tb_authorization.description
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 所属表字段为 tb_authorization.create_date
     *
     * @return 返回 tb_authorization.create_date
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_authorization.create_date
     *
     * @param createDate 赋值 tb_authorization.create_date
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_authorization.update_date
     *
     * @return 返回 tb_authorization.update_date
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_authorization.update_date
     *
     * @param updateDate 赋值 tb_authorization.update_date
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_authorization.parent_id
     *
     * @return 返回 tb_authorization.parent_id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * setter方法 tb_authorization.parent_id
     *
     * @param parentId 赋值 tb_authorization.parent_id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 所属表字段为 tb_authorization.url
     *
     * @return 返回 tb_authorization.url
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public String getUrl() {
        return url;
    }

    /**
     * setter方法 tb_authorization.url
     *
     * @param url 赋值 tb_authorization.url
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 所属表字段为 tb_authorization.parent_ids
     *
     * @return 返回 tb_authorization.parent_ids
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * setter方法 tb_authorization.parent_ids
     *
     * @param parentIds 赋值 tb_authorization.parent_ids
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }
}