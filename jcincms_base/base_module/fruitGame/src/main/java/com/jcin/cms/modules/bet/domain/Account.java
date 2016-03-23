package com.jcin.cms.modules.bet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Account implements Serializable {
    /**
     *   所属表字段为tb_account.id
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    private String id;

    /**
     *  账户总额 所属表字段为tb_account.total
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    private Double total;

    /**
     *   所属表字段为tb_account.create_date
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_account.update_date
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *  备注 所属表字段为tb_account.description
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    private String description;

    /**
     *   所属表字段为tb_account.create_by
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    private String createBy;

    /**
     *   所属表字段为tb_account.update_by
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    private String updateBy;

    /**
     *  用户名称 所属表字段为tb_account.username
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    private String username;

    /**
     * 该字段对应数据库表 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_account.id
     *
     * @return 返回 tb_account.id
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_account.id
     *
     * @param id 赋值 tb_account.id
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_account.total
     *
     * @return 返回 tb_account.total
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public Double getTotal() {
        return total;
    }

    /**
     * setter方法 tb_account.total
     *
     * @param total 赋值 tb_account.total
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 所属表字段为 tb_account.create_date
     *
     * @return 返回 tb_account.create_date
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_account.create_date
     *
     * @param createDate 赋值 tb_account.create_date
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_account.update_date
     *
     * @return 返回 tb_account.update_date
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_account.update_date
     *
     * @param updateDate 赋值 tb_account.update_date
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_account.description
     *
     * @return 返回 tb_account.description
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_account.description
     *
     * @param description 赋值 tb_account.description
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 所属表字段为 tb_account.create_by
     *
     * @return 返回 tb_account.create_by
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 tb_account.create_by
     *
     * @param createBy 赋值 tb_account.create_by
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 tb_account.update_by
     *
     * @return 返回 tb_account.update_by
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * setter方法 tb_account.update_by
     *
     * @param updateBy 赋值 tb_account.update_by
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 所属表字段为 tb_account.username
     *
     * @return 返回 tb_account.username
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter方法 tb_account.username
     *
     * @param username 赋值 tb_account.username
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}