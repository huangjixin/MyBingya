package com.jcin.cms.domain;

import java.io.Serializable;

public class Comment implements Serializable {
    private String id;

    private String content;

    private String tbArticleId;

    private String parentid;

    private String updatedate;

    private String createdate;

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

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate == null ? null : updatedate.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }
}