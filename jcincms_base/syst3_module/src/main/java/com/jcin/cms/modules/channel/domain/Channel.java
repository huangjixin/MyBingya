package com.jcin.cms.modules.channel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Channel implements Serializable {
	private String docGeneTemplate;
	private String docMgeneTemplate;
	private String mchannelTemplate;
	private String mdocumentTemplate;
    /**
     *  id标识符 所属表字段为busi_channel.id
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String id;

    /**
     *  名称 所属表字段为busi_channel.name
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String name;

    /**
     *  代码 所属表字段为busi_channel.code
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String code;

    /**
     *  关键词 所属表字段为busi_channel.keyword
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String keyword;

    /**
     *  链接地址 所属表字段为busi_channel.link_addr
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String linkAddr;

    /**
     *  打开模式 所属表字段为busi_channel.open_mode
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String openMode;

    /**
     *  描述 所属表字段为busi_channel.descrition
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String descrition;

    /**
     *   所属表字段为busi_channel.parent_id
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String parentId;

    /**
     *  栏目模板 所属表字段为busi_channel.channel_templete
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String channelTemplete;

    /**
     *  文档模板 所属表字段为busi_channel.document_templete
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String documentTemplete;

    /**
     *  是否显示 所属表字段为busi_channel.hidden
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private Boolean hidden;

    /**
     *   所属表字段为busi_channel.asdocument
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private Boolean asdocument;

    /**
     *   所属表字段为busi_channel.document_id
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String documentId;

    /**
     *   所属表字段为busi_channel.sort
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private Integer sort;

    /**
     *   所属表字段为busi_channel.parent_ids
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String parentIds;

    /**
     *  中文连接导航 所属表字段为busi_channel.link_addr_zh
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String linkAddrZh;

    /**
     *  创建日期 所属表字段为busi_channel.create_date
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  更新日期 所属表字段为busi_channel.update_date
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *  创建人 所属表字段为busi_channel.create_by
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String createBy;

    /**
     *  更新人 所属表字段为busi_channel.update_by
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String updateBy;

    /**
     *   所属表字段为busi_channel.gene_template
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String geneTemplate;

    /**
     *  移动端页面生成模板 所属表字段为busi_channel.m_gene_template
     *
     * @mbggenerated 2016年01月13日 22时14分34秒 星期三
     */
    private String mGeneTemplate;
    /**
     *  图片 所属表字段为busi_channel.image
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String image;

    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 busi_channel.id
     *
     * @return 返回 busi_channel.id
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 busi_channel.id
     *
     * @param id 赋值 busi_channel.id
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 busi_channel.name
     *
     * @return 返回 busi_channel.name
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 busi_channel.name
     *
     * @param name 赋值 busi_channel.name
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 所属表字段为 busi_channel.code
     *
     * @return 返回 busi_channel.code
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getCode() {
        return code;
    }

    /**
     * setter方法 busi_channel.code
     *
     * @param code 赋值 busi_channel.code
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 所属表字段为 busi_channel.keyword
     *
     * @return 返回 busi_channel.keyword
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * setter方法 busi_channel.keyword
     *
     * @param keyword 赋值 busi_channel.keyword
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * 所属表字段为 busi_channel.link_addr
     *
     * @return 返回 busi_channel.link_addr
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getLinkAddr() {
        return linkAddr;
    }

    /**
     * setter方法 busi_channel.link_addr
     *
     * @param linkAddr 赋值 busi_channel.link_addr
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr == null ? null : linkAddr.trim();
    }

    /**
     * 所属表字段为 busi_channel.open_mode
     *
     * @return 返回 busi_channel.open_mode
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getOpenMode() {
        return openMode;
    }

    /**
     * setter方法 busi_channel.open_mode
     *
     * @param openMode 赋值 busi_channel.open_mode
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setOpenMode(String openMode) {
        this.openMode = openMode == null ? null : openMode.trim();
    }

    /**
     * 所属表字段为 busi_channel.descrition
     *
     * @return 返回 busi_channel.descrition
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getDescrition() {
        return descrition;
    }

    /**
     * setter方法 busi_channel.descrition
     *
     * @param descrition 赋值 busi_channel.descrition
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setDescrition(String descrition) {
        this.descrition = descrition == null ? null : descrition.trim();
    }

    /**
     * 所属表字段为 busi_channel.parent_id
     *
     * @return 返回 busi_channel.parent_id
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * setter方法 busi_channel.parent_id
     *
     * @param parentId 赋值 busi_channel.parent_id
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 所属表字段为 busi_channel.channel_templete
     *
     * @return 返回 busi_channel.channel_templete
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getChannelTemplete() {
        return channelTemplete;
    }

    /**
     * setter方法 busi_channel.channel_templete
     *
     * @param channelTemplete 赋值 busi_channel.channel_templete
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setChannelTemplete(String channelTemplete) {
        this.channelTemplete = channelTemplete == null ? null : channelTemplete.trim();
    }

    /**
     * 所属表字段为 busi_channel.document_templete
     *
     * @return 返回 busi_channel.document_templete
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getDocumentTemplete() {
        return documentTemplete;
    }

    /**
     * setter方法 busi_channel.document_templete
     *
     * @param documentTemplete 赋值 busi_channel.document_templete
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setDocumentTemplete(String documentTemplete) {
        this.documentTemplete = documentTemplete == null ? null : documentTemplete.trim();
    }

    /**
     * 所属表字段为 busi_channel.hidden
     *
     * @return 返回 busi_channel.hidden
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public Boolean getHidden() {
        return hidden;
    }

    /**
     * setter方法 busi_channel.hidden
     *
     * @param hidden 赋值 busi_channel.hidden
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * 所属表字段为 busi_channel.asdocument
     *
     * @return 返回 busi_channel.asdocument
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public Boolean getAsdocument() {
        return asdocument;
    }

    /**
     * setter方法 busi_channel.asdocument
     *
     * @param asdocument 赋值 busi_channel.asdocument
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setAsdocument(Boolean asdocument) {
        this.asdocument = asdocument;
    }

    /**
     * 所属表字段为 busi_channel.document_id
     *
     * @return 返回 busi_channel.document_id
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * setter方法 busi_channel.document_id
     *
     * @param documentId 赋值 busi_channel.document_id
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId == null ? null : documentId.trim();
    }

    /**
     * 所属表字段为 busi_channel.sort
     *
     * @return 返回 busi_channel.sort
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * setter方法 busi_channel.sort
     *
     * @param sort 赋值 busi_channel.sort
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 所属表字段为 busi_channel.parent_ids
     *
     * @return 返回 busi_channel.parent_ids
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * setter方法 busi_channel.parent_ids
     *
     * @param parentIds 赋值 busi_channel.parent_ids
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    /**
     * 所属表字段为 busi_channel.link_addr_zh
     *
     * @return 返回 busi_channel.link_addr_zh
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getLinkAddrZh() {
        return linkAddrZh;
    }

    /**
     * setter方法 busi_channel.link_addr_zh
     *
     * @param linkAddrZh 赋值 busi_channel.link_addr_zh
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setLinkAddrZh(String linkAddrZh) {
        this.linkAddrZh = linkAddrZh == null ? null : linkAddrZh.trim();
    }

    /**
     * 所属表字段为 busi_channel.create_date
     *
     * @return 返回 busi_channel.create_date
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 busi_channel.create_date
     *
     * @param createDate 赋值 busi_channel.create_date
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 busi_channel.update_date
     *
     * @return 返回 busi_channel.update_date
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 busi_channel.update_date
     *
     * @param updateDate 赋值 busi_channel.update_date
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 busi_channel.create_by
     *
     * @return 返回 busi_channel.create_by
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 busi_channel.create_by
     *
     * @param createBy 赋值 busi_channel.create_by
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 busi_channel.update_by
     *
     * @return 返回 busi_channel.update_by
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * setter方法 busi_channel.update_by
     *
     * @param updateBy 赋值 busi_channel.update_by
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 所属表字段为 busi_channel.gene_template
     *
     * @return 返回 busi_channel.gene_template
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getGeneTemplate() {
        return geneTemplate;
    }

    /**
     * setter方法 busi_channel.gene_template
     *
     * @param geneTemplate 赋值 busi_channel.gene_template
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setGeneTemplate(String geneTemplate) {
        this.geneTemplate = geneTemplate == null ? null : geneTemplate.trim();
    }
    
    public String getmGeneTemplate() {
		return mGeneTemplate;
	}

	public void setmGeneTemplate(String mGeneTemplate) {
		this.mGeneTemplate = mGeneTemplate== null ? null : mGeneTemplate.trim();
	}

    /**
     * 所属表字段为 busi_channel.image
     *
     * @return 返回 busi_channel.image
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getImage() {
        return image;
    }

    /**
     * setter方法 busi_channel.image
     *
     * @param image 赋值 busi_channel.image
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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

	public String getDocMgeneTemplate() {
		return docMgeneTemplate;
	}

	public void setDocMgeneTemplate(String docMgeneTemplate) {
		this.docMgeneTemplate = docMgeneTemplate;
	}

	public String getDocGeneTemplate() {
		return docGeneTemplate;
	}

	public void setDocGeneTemplate(String docGeneTemplate) {
		this.docGeneTemplate = docGeneTemplate;
	}

	public String getMchannelTemplate() {
		return mchannelTemplate;
	}

	public void setMchannelTemplate(String mchannelTemplate) {
		this.mchannelTemplate = mchannelTemplate;
	}

	public String getMdocumentTemplate() {
		return mdocumentTemplate;
	}

	public void setMdocumentTemplate(String mdocumentTemplate) {
		this.mdocumentTemplate = mdocumentTemplate;
	}

}