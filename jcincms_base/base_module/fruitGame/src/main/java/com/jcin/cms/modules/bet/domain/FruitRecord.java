package com.jcin.cms.modules.bet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class FruitRecord implements Serializable {
    /**
     *   所属表字段为tb_fruit_record.id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String id;

    /**
     *  结果：1苹果，2葡萄，3菠萝，4草莓，5西瓜，6香蕉 所属表字段为tb_fruit_record.result
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private Integer result;

    /**
     *   所属表字段为tb_fruit_record.create_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_fruit_record.create_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String createBy;

    /**
     *   所属表字段为tb_fruit_record.update_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为tb_fruit_record.update_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String updateBy;

    /**
     *  描述信息 所属表字段为tb_fruit_record.description
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String description;

    /**
     * 该字段对应数据库表 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_fruit_record.id
     *
     * @return 返回 tb_fruit_record.id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_fruit_record.id
     *
     * @param id 赋值 tb_fruit_record.id
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_fruit_record.result
     *
     * @return 返回 tb_fruit_record.result
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Integer getResult() {
        return result;
    }

    /**
     * setter方法 tb_fruit_record.result
     *
     * @param result 赋值 tb_fruit_record.result
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * 所属表字段为 tb_fruit_record.create_date
     *
     * @return 返回 tb_fruit_record.create_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_fruit_record.create_date
     *
     * @param createDate 赋值 tb_fruit_record.create_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_fruit_record.create_by
     *
     * @return 返回 tb_fruit_record.create_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setter方法 tb_fruit_record.create_by
     *
     * @param createBy 赋值 tb_fruit_record.create_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 所属表字段为 tb_fruit_record.update_date
     *
     * @return 返回 tb_fruit_record.update_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_fruit_record.update_date
     *
     * @param updateDate 赋值 tb_fruit_record.update_date
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_fruit_record.update_by
     *
     * @return 返回 tb_fruit_record.update_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * setter方法 tb_fruit_record.update_by
     *
     * @param updateBy 赋值 tb_fruit_record.update_by
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 所属表字段为 tb_fruit_record.description
     *
     * @return 返回 tb_fruit_record.description
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_fruit_record.description
     *
     * @param description 赋值 tb_fruit_record.description
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}