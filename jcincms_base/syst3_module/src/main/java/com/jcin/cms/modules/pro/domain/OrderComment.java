package com.jcin.cms.modules.pro.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class OrderComment implements Serializable {
    /**
     *   所属表字段为order_comment.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String id;

    /**
     *  创建日期 所属表字段为order_comment.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *  修改日期 所属表字段为order_comment.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *  评价 所属表字段为order_comment.content
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String content;

    /**
     *   所属表字段为order_comment.order_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String orderId;

    /**
     * 该字段对应数据库表 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 order_comment.id
     *
     * @return 返回 order_comment.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 order_comment.id
     *
     * @param id 赋值 order_comment.id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 order_comment.create_date
     *
     * @return 返回 order_comment.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 order_comment.create_date
     *
     * @param createDate 赋值 order_comment.create_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 order_comment.update_date
     *
     * @return 返回 order_comment.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 order_comment.update_date
     *
     * @param updateDate 赋值 order_comment.update_date
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 order_comment.content
     *
     * @return 返回 order_comment.content
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getContent() {
        return content;
    }

    /**
     * setter方法 order_comment.content
     *
     * @param content 赋值 order_comment.content
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 所属表字段为 order_comment.order_id
     *
     * @return 返回 order_comment.order_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * setter方法 order_comment.order_id
     *
     * @param orderId 赋值 order_comment.order_id
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
}