package com.jcin.cms.modules.channel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class VoteChoice implements Serializable {
    /**
     *   所属表字段为tb_vote_choice.id
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String id;

    /**
     *   所属表字段为tb_vote_choice.name
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String name;

    /**
     *  投票数 所属表字段为tb_vote_choice.vote_count
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private Integer voteCount;

    /**
     *   所属表字段为tb_vote_choice.create_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String createBy;

    /**
     *   所属表字段为tb_vote_choice.update_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String updateBy;

    /**
     *   所属表字段为tb_vote_choice.create_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_vote_choice.update_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *  图片 所属表字段为tb_vote_choice.image
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String image;

    /**
     *   所属表字段为tb_vote_choice.tb_vote_topic_id
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private String tbVoteTopicId;

    /**
     * 该字段对应数据库表 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_vote_choice.id
     *
     * @return 返回 tb_vote_choice.id
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_vote_choice.id
     *
     * @param id 赋值 tb_vote_choice.id
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_vote_choice.name
     *
     * @return 返回 tb_vote_choice.name
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_vote_choice.name
     *
     * @param name 赋值 tb_vote_choice.name
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_vote_choice.vote_count
     *
     * @return 返回 tb_vote_choice.vote_count
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     * setter方法 tb_vote_choice.vote_count
     *
     * @param voteCount 赋值 tb_vote_choice.vote_count
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    /**
     * 所属表字段为 tb_vote_choice.create_by
     *
     * @return 返回 tb_vote_choice.create_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 tb_vote_choice.create_by
     *
     * @param createBy 赋值 tb_vote_choice.create_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 tb_vote_choice.update_by
     *
     * @return 返回 tb_vote_choice.update_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * setter方法 tb_vote_choice.update_by
     *
     * @param updateBy 赋值 tb_vote_choice.update_by
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 所属表字段为 tb_vote_choice.create_date
     *
     * @return 返回 tb_vote_choice.create_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_vote_choice.create_date
     *
     * @param createDate 赋值 tb_vote_choice.create_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_vote_choice.update_date
     *
     * @return 返回 tb_vote_choice.update_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_vote_choice.update_date
     *
     * @param updateDate 赋值 tb_vote_choice.update_date
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_vote_choice.image
     *
     * @return 返回 tb_vote_choice.image
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getImage() {
        return image;
    }

    /**
     * setter方法 tb_vote_choice.image
     *
     * @param image 赋值 tb_vote_choice.image
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 所属表字段为 tb_vote_choice.tb_vote_topic_id
     *
     * @return 返回 tb_vote_choice.tb_vote_topic_id
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public String getTbVoteTopicId() {
        return tbVoteTopicId;
    }

    /**
     * setter方法 tb_vote_choice.tb_vote_topic_id
     *
     * @param tbVoteTopicId 赋值 tb_vote_choice.tb_vote_topic_id
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    public void setTbVoteTopicId(String tbVoteTopicId) {
        this.tbVoteTopicId = tbVoteTopicId == null ? null : tbVoteTopicId.trim();
    }
}