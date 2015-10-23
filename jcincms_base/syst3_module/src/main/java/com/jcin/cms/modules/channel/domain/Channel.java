package com.jcin.cms.modules.channel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Channel implements Serializable {
    /**
     *  id标识符 所属表字段为busi_channel.id
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    private String id;

    /**
     *  名称 所属表字段为busi_channel.name
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    private String name;

    /**
     *  代码 所属表字段为busi_channel.code
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    private String code;

    /**
     *  关键词 所属表字段为busi_channel.keyword
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    private String keyword;

    /**
     *  链接地址 所属表字段为busi_channel.link_addr
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    private String linkAddr;

    /**
     *  打开模式 所属表字段为busi_channel.open_mode
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    private String openMode;

    /**
     *  描述 所属表字段为busi_channel.descrition
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    private String descrition;

    /**
     *   所属表字段为busi_channel.parent_id
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    private String parentId;

    private List<Channel> children = new ArrayList<Channel>();
    
    private boolean checked;
    
    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 busi_channel.id
     *
     * @return 返回 busi_channel.id
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 busi_channel.id
     *
     * @param id 赋值 busi_channel.id
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 busi_channel.name
     *
     * @return 返回 busi_channel.name
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 busi_channel.name
     *
     * @param name 赋值 busi_channel.name
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 busi_channel.code
     *
     * @return 返回 busi_channel.code
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public String getCode() {
        return code;
    }

    /**
     * setter方法 busi_channel.code
     *
     * @param code 赋值 busi_channel.code
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 所属表字段为 busi_channel.keyword
     *
     * @return 返回 busi_channel.keyword
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * setter方法 busi_channel.keyword
     *
     * @param keyword 赋值 busi_channel.keyword
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * 所属表字段为 busi_channel.link_addr
     *
     * @return 返回 busi_channel.link_addr
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public String getLinkAddr() {
        return linkAddr;
    }

    /**
     * setter方法 busi_channel.link_addr
     *
     * @param linkAddr 赋值 busi_channel.link_addr
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr == null ? null : linkAddr.trim();
    }

    /**
     * 所属表字段为 busi_channel.open_mode
     *
     * @return 返回 busi_channel.open_mode
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public String getOpenMode() {
        return openMode;
    }

    /**
     * setter方法 busi_channel.open_mode
     *
     * @param openMode 赋值 busi_channel.open_mode
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setOpenMode(String openMode) {
        this.openMode = openMode == null ? null : openMode.trim();
    }

    /**
     * 所属表字段为 busi_channel.descrition
     *
     * @return 返回 busi_channel.descrition
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public String getDescrition() {
        return descrition;
    }

    /**
     * setter方法 busi_channel.descrition
     *
     * @param descrition 赋值 busi_channel.descrition
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setDescrition(String descrition) {
        this.descrition = descrition == null ? null : descrition.trim();
    }

    /**
     * 所属表字段为 busi_channel.parent_id
     *
     * @return 返回 busi_channel.parent_id
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * setter方法 busi_channel.parent_id
     *
     * @param parentId 赋值 busi_channel.parent_id
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }
    
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
}