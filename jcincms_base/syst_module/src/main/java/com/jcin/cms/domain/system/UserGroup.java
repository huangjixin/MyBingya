package com.jcin.cms.domain.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class UserGroup implements Serializable {
    /**
     *  唯一id标识符 所属表字段为tb_user_group.id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private String id;

    /**
     *  用户名 所属表字段为tb_user_group.groupname
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private String groupname;

    /**
     *  状态 所属表字段为tb_user_group.status
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private Short status;

    /**
     *  组描述 所属表字段为tb_user_group.description
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private String description;

    /**
     *  是否可用 所属表字段为tb_user_group.enabled
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private Boolean enabled;

    /**
     *  创建日期 所属表字段为tb_user_group.create_date
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  更新日期 所属表字段为tb_user_group.update_date
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *  是否把组锁定 所属表字段为tb_user_group.locked
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private Boolean locked;

    /**
     * 该字段对应数据库表 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_user_group.id
     *
     * @return 返回 tb_user_group.id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_user_group.id
     *
     * @param id 赋值 tb_user_group.id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_user_group.groupname
     *
     * @return 返回 tb_user_group.groupname
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * setter方法 tb_user_group.groupname
     *
     * @param groupname 赋值 tb_user_group.groupname
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    /**
     * 所属表字段为 tb_user_group.status
     *
     * @return 返回 tb_user_group.status
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public Short getStatus() {
        return status;
    }

    /**
     * setter方法 tb_user_group.status
     *
     * @param status 赋值 tb_user_group.status
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 所属表字段为 tb_user_group.description
     *
     * @return 返回 tb_user_group.description
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_user_group.description
     *
     * @param description 赋值 tb_user_group.description
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 所属表字段为 tb_user_group.enabled
     *
     * @return 返回 tb_user_group.enabled
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * setter方法 tb_user_group.enabled
     *
     * @param enabled 赋值 tb_user_group.enabled
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 所属表字段为 tb_user_group.create_date
     *
     * @return 返回 tb_user_group.create_date
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_user_group.create_date
     *
     * @param createDate 赋值 tb_user_group.create_date
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_user_group.update_date
     *
     * @return 返回 tb_user_group.update_date
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_user_group.update_date
     *
     * @param updateDate 赋值 tb_user_group.update_date
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_user_group.locked
     *
     * @return 返回 tb_user_group.locked
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * setter方法 tb_user_group.locked
     *
     * @param locked 赋值 tb_user_group.locked
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}