package com.jcin.cms.modules.channel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class VoteTopic implements Serializable {
    /**
     *   所属表字段为tb_vote_topic.id
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String id;

    /**
     *  投票类型，可选为多选和单选 所属表字段为tb_vote_topic.type
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String type;

    /**
     *  投票结束时间 所属表字段为tb_vote_topic.end_time
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    /**
     *  活动介绍 所属表字段为tb_vote_topic.introduction
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String introduction;

    /**
     *   所属表字段为tb_vote_topic.create_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String createBy;

    /**
     *   所属表字段为tb_vote_topic.update_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String updateBy;

    /**
     *   所属表字段为tb_vote_topic.create_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_vote_topic.update_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为tb_vote_topic.name
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String name;

    /**
     * 该字段对应数据库表 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_vote_topic.id
     *
     * @return 返回 tb_vote_topic.id
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_vote_topic.id
     *
     * @param id 赋值 tb_vote_topic.id
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_vote_topic.type
     *
     * @return 返回 tb_vote_topic.type
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getType() {
        return type;
    }

    /**
     * setter方法 tb_vote_topic.type
     *
     * @param type 赋值 tb_vote_topic.type
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 所属表字段为 tb_vote_topic.end_time
     *
     * @return 返回 tb_vote_topic.end_time
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * setter方法 tb_vote_topic.end_time
     *
     * @param endTime 赋值 tb_vote_topic.end_time
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 所属表字段为 tb_vote_topic.introduction
     *
     * @return 返回 tb_vote_topic.introduction
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * setter方法 tb_vote_topic.introduction
     *
     * @param introduction 赋值 tb_vote_topic.introduction
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * 所属表字段为 tb_vote_topic.create_by
     *
     * @return 返回 tb_vote_topic.create_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 tb_vote_topic.create_by
     *
     * @param createBy 赋值 tb_vote_topic.create_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 tb_vote_topic.update_by
     *
     * @return 返回 tb_vote_topic.update_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * setter方法 tb_vote_topic.update_by
     *
     * @param updateBy 赋值 tb_vote_topic.update_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 所属表字段为 tb_vote_topic.create_date
     *
     * @return 返回 tb_vote_topic.create_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_vote_topic.create_date
     *
     * @param createDate 赋值 tb_vote_topic.create_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_vote_topic.update_date
     *
     * @return 返回 tb_vote_topic.update_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_vote_topic.update_date
     *
     * @param updateDate 赋值 tb_vote_topic.update_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_vote_topic.name
     *
     * @return 返回 tb_vote_topic.name
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_vote_topic.name
     *
     * @param name 赋值 tb_vote_topic.name
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}