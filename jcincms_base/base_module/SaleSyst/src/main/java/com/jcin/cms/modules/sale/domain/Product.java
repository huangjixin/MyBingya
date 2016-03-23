package com.jcin.cms.modules.sale.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jcin.cms.modules.syst.dao.CustomDateSerializer;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

public class Product implements Serializable {
	private boolean countTotal;
    /**
     *   所属表字段为tb_product.id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private String id;

    /**
     *   所属表字段为tb_product.name
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private String name;

    /**
     *   所属表字段为tb_product.create_date
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_product.create_by
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private String createBy;

    /**
     *   所属表字段为tb_product.parent_id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private String parentId;

    /**
     *   所属表字段为tb_product.description
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private String description;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date beginDate;
    
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endDate;
	
    /**
     * 该字段对应数据库表 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_product.id
     *
     * @return 返回 tb_product.id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_product.id
     *
     * @param id 赋值 tb_product.id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_product.name
     *
     * @return 返回 tb_product.name
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_product.name
     *
     * @param name 赋值 tb_product.name
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_product.create_date
     *
     * @return 返回 tb_product.create_date
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_product.create_date
     *
     * @param createDate 赋值 tb_product.create_date
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_product.create_by
     *
     * @return 返回 tb_product.create_by
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 tb_product.create_by
     *
     * @param createBy 赋值 tb_product.create_by
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 tb_product.parent_id
     *
     * @return 返回 tb_product.parent_id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * setter方法 tb_product.parent_id
     *
     * @param parentId 赋值 tb_product.parent_id
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 所属表字段为 tb_product.description
     *
     * @return 返回 tb_product.description
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_product.description
     *
     * @param description 赋值 tb_product.description
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public boolean isCountTotal() {
		return countTotal;
	}

	public void setCountTotal(boolean countTotal) {
		this.countTotal = countTotal;
	}
}