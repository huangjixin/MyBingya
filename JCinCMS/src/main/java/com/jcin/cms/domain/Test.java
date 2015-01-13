package com.jcin.cms.domain;

import java.io.Serializable;

public class Test implements Serializable {
    private String id;

    private byte[] description;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
    }
}