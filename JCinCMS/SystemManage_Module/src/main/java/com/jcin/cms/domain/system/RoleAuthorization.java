package com.jcin.cms.domain.system;

import java.io.Serializable;

public class RoleAuthorization implements Serializable {
    private String id;

    private String tbRoleId;

    private String tbAuthorizationId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTbRoleId() {
        return tbRoleId;
    }

    public void setTbRoleId(String tbRoleId) {
        this.tbRoleId = tbRoleId == null ? null : tbRoleId.trim();
    }

    public String getTbAuthorizationId() {
        return tbAuthorizationId;
    }

    public void setTbAuthorizationId(String tbAuthorizationId) {
        this.tbAuthorizationId = tbAuthorizationId == null ? null : tbAuthorizationId.trim();
    }
}