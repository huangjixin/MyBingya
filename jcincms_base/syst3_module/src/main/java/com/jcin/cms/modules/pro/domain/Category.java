package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jcin.cms.modules.syst.domain.Resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Category implements Serializable {
    /**
     *   所属表字段为pro_category.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String id;

    /**
     *  名称 所属表字段为pro_category.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String name;

    /**
     *  父类ID 所属表字段为pro_category.parent_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String parentId;

    /**
     *  排序id 所属表字段为pro_category.sortid
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private Integer sortid;

    /**
     *  创建日期 所属表字段为pro_category.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  修改日期 所属表字段为pro_category.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *  是否为父级 所属表字段为pro_category.is_parent
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private Byte isParent;

    /**
     * 该字段对应数据库表 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_category.id
     *
     * @return 返回 pro_category.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 pro_category.id
     *
     * @param id 赋值 pro_category.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 pro_category.name
     *
     * @return 返回 pro_category.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 pro_category.name
     *
     * @param name 赋值 pro_category.name
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 pro_category.parent_id
     *
     * @return 返回 pro_category.parent_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * setter方法 pro_category.parent_id
     *
     * @param parentId 赋值 pro_category.parent_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 所属表字段为 pro_category.sortid
     *
     * @return 返回 pro_category.sortid
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Integer getSortid() {
        return sortid;
    }

    /**
     * setter方法 pro_category.sortid
     *
     * @param sortid 赋值 pro_category.sortid
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    /**
     * 所属表字段为 pro_category.create_date
     *
     * @return 返回 pro_category.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 pro_category.create_date
     *
     * @param createDate 赋值 pro_category.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 pro_category.update_date
     *
     * @return 返回 pro_category.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 pro_category.update_date
     *
     * @param updateDate 赋值 pro_category.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 pro_category.is_parent
     *
     * @return 返回 pro_category.is_parent
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Byte getIsParent() {
        return isParent;
    }

    public String getText() {
		return name;
	}
    
    /**
     * setter方法 pro_category.is_parent
     *
     * @param isParent 赋值 pro_category.is_parent
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setIsParent(Byte isParent) {
        this.isParent = isParent;
    }
    
    private List<Category> children = new ArrayList<Category>();

	private boolean checked;
	
	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}