package com.jcin.cms.domain;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private String id;

    private String content;

    private String tbArticleId;

    private String parentid;

    private Date updatedate;

    private Date createdate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTbArticleId() {
        return tbArticleId;
    }

    public void setTbArticleId(String tbArticleId) {
        this.tbArticleId = tbArticleId == null ? null : tbArticleId.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}