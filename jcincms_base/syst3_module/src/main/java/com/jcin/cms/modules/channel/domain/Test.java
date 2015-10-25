package com.jcin.cms.modules.channel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Test implements Serializable {
    /**
     *   所属表字段为test.id
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    private String id;

    /**
     *   所属表字段为test.name
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    private String name;

    /**
     *   所属表字段为test.create_date
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为test.update_date
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     * 该字段对应数据库表 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 test.id
     *
     * @return 返回 test.id
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 test.id
     *
     * @param id 赋值 test.id
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 test.name
     *
     * @return 返回 test.name
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 test.name
     *
     * @param name 赋值 test.name
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 test.create_date
     *
     * @return 返回 test.create_date
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 test.create_date
     *
     * @param createDate 赋值 test.create_date
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 test.update_date
     *
     * @return 返回 test.update_date
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 test.update_date
     *
     * @param updateDate 赋值 test.update_date
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}