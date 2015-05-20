package com.jcin.cms.domain.system;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable {
    /**
     *   所属表字段为tb_user.id
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    private String id;

    /**
     *   所属表字段为tb_user.username
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    private String username;

    /**
     *   所属表字段为tb_user.password
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    private String password;

    /**
     *   所属表字段为tb_user.status
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    private Short status;

    /**
     *   所属表字段为tb_user.description
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    private String description;

    /**
     *   所属表字段为tb_user.enabled
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    private Boolean enabled;

    /**
     *   所属表字段为tb_user.create_date
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createDate;

    /**
     *   所属表字段为tb_user.update_date
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateDate;

    /**
     *   所属表字段为tb_user.ip
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    private String ip;

    /**
     *   所属表字段为tb_user.telephone
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    private String telephone;

    /**
     *   所属表字段为tb_user.salt
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    private String salt;

    /**
     *   所属表字段为tb_user.locked
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    private Boolean locked;

    /**
     * 该字段对应数据库表 tb_user
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_user.id
     *
     * @return 返回 tb_user.id
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_user.id
     *
     * @param id 赋值 tb_user.id
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_user.username
     *
     * @return 返回 tb_user.username
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter方法 tb_user.username
     *
     * @param username 赋值 tb_user.username
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 所属表字段为 tb_user.password
     *
     * @return 返回 tb_user.password
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter方法 tb_user.password
     *
     * @param password 赋值 tb_user.password
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 所属表字段为 tb_user.status
     *
     * @return 返回 tb_user.status
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public Short getStatus() {
        return status;
    }

    /**
     * setter方法 tb_user.status
     *
     * @param status 赋值 tb_user.status
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 所属表字段为 tb_user.description
     *
     * @return 返回 tb_user.description
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_user.description
     *
     * @param description 赋值 tb_user.description
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 所属表字段为 tb_user.enabled
     *
     * @return 返回 tb_user.enabled
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * setter方法 tb_user.enabled
     *
     * @param enabled 赋值 tb_user.enabled
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 所属表字段为 tb_user.create_date
     *
     * @return 返回 tb_user.create_date
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_user.create_date
     *
     * @param createDate 赋值 tb_user.create_date
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_user.update_date
     *
     * @return 返回 tb_user.update_date
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_user.update_date
     *
     * @param updateDate 赋值 tb_user.update_date
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_user.ip
     *
     * @return 返回 tb_user.ip
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public String getIp() {
        return ip;
    }

    /**
     * setter方法 tb_user.ip
     *
     * @param ip 赋值 tb_user.ip
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 所属表字段为 tb_user.telephone
     *
     * @return 返回 tb_user.telephone
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * setter方法 tb_user.telephone
     *
     * @param telephone 赋值 tb_user.telephone
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 所属表字段为 tb_user.salt
     *
     * @return 返回 tb_user.salt
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public String getSalt() {
        return salt;
    }

    /**
     * setter方法 tb_user.salt
     *
     * @param salt 赋值 tb_user.salt
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 所属表字段为 tb_user.locked
     *
     * @return 返回 tb_user.locked
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * setter方法 tb_user.locked
     *
     * @param locked 赋值 tb_user.locked
     *
     * @mbggenerated 2015年05月20日 18时26分02秒 星期三
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}