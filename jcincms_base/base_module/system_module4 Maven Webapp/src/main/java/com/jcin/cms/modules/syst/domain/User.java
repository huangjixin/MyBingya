package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable {
    /**
     *   所属表字段为tb_user.id
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    private String id;

    /**
     *   所属表字段为tb_user.username
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    private String username;

    /**
     *   所属表字段为tb_user.password
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    private String password;

    /**
     *   所属表字段为tb_user.login_date
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date loginDate;

    /**
     *   所属表字段为tb_user.create_date
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_user.update_date
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     * 该字段对应数据库表 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_user.id
     *
     * @return 返回 tb_user.id
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_user.id
     *
     * @param id 赋值 tb_user.id
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_user.username
     *
     * @return 返回 tb_user.username
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter方法 tb_user.username
     *
     * @param username 赋值 tb_user.username
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 所属表字段为 tb_user.password
     *
     * @return 返回 tb_user.password
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter方法 tb_user.password
     *
     * @param password 赋值 tb_user.password
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 所属表字段为 tb_user.login_date
     *
     * @return 返回 tb_user.login_date
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * setter方法 tb_user.login_date
     *
     * @param loginDate 赋值 tb_user.login_date
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 所属表字段为 tb_user.create_date
     *
     * @return 返回 tb_user.create_date
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_user.create_date
     *
     * @param createDate 赋值 tb_user.create_date
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_user.update_date
     *
     * @return 返回 tb_user.update_date
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_user.update_date
     *
     * @param updateDate 赋值 tb_user.update_date
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}