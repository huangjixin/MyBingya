package com.jcin.cms.modules.channel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Channel implements Serializable {
    /**
     *  id标识符 所属表字段为busi_channel.id
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String id;

    /**
     *  名称 所属表字段为busi_channel.name
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String name;

    /**
     *  代码 所属表字段为busi_channel.code
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String code;

    /**
     *  关键词 所属表字段为busi_channel.keyword
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String keyword;

    /**
     *  链接地址 所属表字段为busi_channel.link_addr
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String linkAddr;

    /**
     *  打开模式 所属表字段为busi_channel.open_mode
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String openMode;

    /**
     *  描述 所属表字段为busi_channel.descrition
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String descrition;

    /**
     *   所属表字段为busi_channel.parent_id
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String parentId;

    /**
     *  栏目模板 所属表字段为busi_channel.channel_templete
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String channelTemplete;

    /**
     *  文档模板 所属表字段为busi_channel.document_templete
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String documentTemplete;

    /**
     *  是否显示 所属表字段为busi_channel.hidden
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private Boolean hidden;

    /**
     *   所属表字段为busi_channel.asdocument
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private Boolean asdocument;

    /**
     *   所属表字段为busi_channel.document_id
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String documentId;

    /**
     *   所属表字段为busi_channel.sort
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private Integer sort;

    /**
     *   所属表字段为busi_channel.parent_ids
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private String parentIds;

    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 busi_channel.id
     *
     * @return 返回 busi_channel.id
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 busi_channel.id
     *
     * @param id 赋值 busi_channel.id
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 busi_channel.name
     *
     * @return 返回 busi_channel.name
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 busi_channel.name
     *
     * @param name 赋值 busi_channel.name
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 busi_channel.code
     *
     * @return 返回 busi_channel.code
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getCode() {
        return code;
    }

    /**
     * setter方法 busi_channel.code
     *
     * @param code 赋值 busi_channel.code
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 所属表字段为 busi_channel.keyword
     *
     * @return 返回 busi_channel.keyword
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * setter方法 busi_channel.keyword
     *
     * @param keyword 赋值 busi_channel.keyword
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * 所属表字段为 busi_channel.link_addr
     *
     * @return 返回 busi_channel.link_addr
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getLinkAddr() {
        return linkAddr;
    }

    /**
     * setter方法 busi_channel.link_addr
     *
     * @param linkAddr 赋值 busi_channel.link_addr
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr == null ? null : linkAddr.trim();
    }

    /**
     * 所属表字段为 busi_channel.open_mode
     *
     * @return 返回 busi_channel.open_mode
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getOpenMode() {
        return openMode;
    }

    /**
     * setter方法 busi_channel.open_mode
     *
     * @param openMode 赋值 busi_channel.open_mode
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setOpenMode(String openMode) {
        this.openMode = openMode == null ? null : openMode.trim();
    }

    /**
     * 所属表字段为 busi_channel.descrition
     *
     * @return 返回 busi_channel.descrition
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getDescrition() {
        return descrition;
    }

    /**
     * setter方法 busi_channel.descrition
     *
     * @param descrition 赋值 busi_channel.descrition
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setDescrition(String descrition) {
        this.descrition = descrition == null ? null : descrition.trim();
    }

    /**
     * 所属表字段为 busi_channel.parent_id
     *
     * @return 返回 busi_channel.parent_id
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * setter方法 busi_channel.parent_id
     *
     * @param parentId 赋值 busi_channel.parent_id
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 所属表字段为 busi_channel.channel_templete
     *
     * @return 返回 busi_channel.channel_templete
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getChannelTemplete() {
        return channelTemplete;
    }

    /**
     * setter方法 busi_channel.channel_templete
     *
     * @param channelTemplete 赋值 busi_channel.channel_templete
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setChannelTemplete(String channelTemplete) {
        this.channelTemplete = channelTemplete == null ? null : channelTemplete.trim();
    }

    /**
     * 所属表字段为 busi_channel.document_templete
     *
     * @return 返回 busi_channel.document_templete
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getDocumentTemplete() {
        return documentTemplete;
    }

    /**
     * setter方法 busi_channel.document_templete
     *
     * @param documentTemplete 赋值 busi_channel.document_templete
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setDocumentTemplete(String documentTemplete) {
        this.documentTemplete = documentTemplete == null ? null : documentTemplete.trim();
    }

    /**
     * 所属表字段为 busi_channel.hidden
     *
     * @return 返回 busi_channel.hidden
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public Boolean getHidden() {
        return hidden;
    }

    /**
     * setter方法 busi_channel.hidden
     *
     * @param hidden 赋值 busi_channel.hidden
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * 所属表字段为 busi_channel.asdocument
     *
     * @return 返回 busi_channel.asdocument
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public Boolean getAsdocument() {
        return asdocument;
    }

    /**
     * setter方法 busi_channel.asdocument
     *
     * @param asdocument 赋值 busi_channel.asdocument
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setAsdocument(Boolean asdocument) {
        this.asdocument = asdocument;
    }

    /**
     * 所属表字段为 busi_channel.document_id
     *
     * @return 返回 busi_channel.document_id
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * setter方法 busi_channel.document_id
     *
     * @param documentId 赋值 busi_channel.document_id
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId == null ? null : documentId.trim();
    }

    /**
     * 所属表字段为 busi_channel.sort
     *
     * @return 返回 busi_channel.sort
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * setter方法 busi_channel.sort
     *
     * @param sort 赋值 busi_channel.sort
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 所属表字段为 busi_channel.parent_ids
     *
     * @return 返回 busi_channel.parent_ids
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * setter方法 busi_channel.parent_ids
     *
     * @param parentIds 赋值 busi_channel.parent_ids
     *
     * @mbggenerated 2015年11月17日 17时51分44秒 星期二
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }
    
private List<String> childrenids = new ArrayList<String>() ;
    
    private List<Channel> children ;

	private boolean checked;
	
    public String getText() {
		return name;
	}
	
	public List<Channel> getChildren() {
		return children;
	}

	public boolean hasChildren() {
		return getChildren().size()>0;
	}
	
	public void setChildren(List<Channel> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<String> getChildrenids() {
		return childrenids;
	}

	public void setChildrenids(List<String> childrenids) {
		this.childrenids = childrenids;
	}
}