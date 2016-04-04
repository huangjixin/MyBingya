package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Guestbook implements Serializable {
    /**
     *   所属表字段为tb_guestbook.id
     *
     * @mbggenerated 2016年04月04日 07时25分59秒 星期一
     */
    private String id;

    /**
     *  主题 所属表字段为tb_guestbook.topic
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    private String topic;

    /**
     *  留言内容 所属表字段为tb_guestbook.content
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    private String content;

    /**
     *   所属表字段为tb_guestbook.tel
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    private String tel;

    /**
     *  qq 所属表字段为tb_guestbook.qq
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    private String qq;

    /**
     *  姓名 所属表字段为tb_guestbook.name
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    private String name;

    /**
     *  邮箱 所属表字段为tb_guestbook.email
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    private String email;

    /**
     *   所属表字段为tb_guestbook.create_date
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_guestbook.update_date
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     * 该字段对应数据库表 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_guestbook.id
     *
     * @return 返回 tb_guestbook.id
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_guestbook.id
     *
     * @param id 赋值 tb_guestbook.id
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_guestbook.topic
     *
     * @return 返回 tb_guestbook.topic
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public String getTopic() {
        return topic;
    }

    /**
     * setter方法 tb_guestbook.topic
     *
     * @param topic 赋值 tb_guestbook.topic
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    /**
     * 所属表字段为 tb_guestbook.content
     *
     * @return 返回 tb_guestbook.content
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public String getContent() {
        return content;
    }

    /**
     * setter方法 tb_guestbook.content
     *
     * @param content 赋值 tb_guestbook.content
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 所属表字段为 tb_guestbook.tel
     *
     * @return 返回 tb_guestbook.tel
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public String getTel() {
        return tel;
    }

    /**
     * setter方法 tb_guestbook.tel
     *
     * @param tel 赋值 tb_guestbook.tel
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 所属表字段为 tb_guestbook.qq
     *
     * @return 返回 tb_guestbook.qq
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public String getQq() {
        return qq;
    }

    /**
     * setter方法 tb_guestbook.qq
     *
     * @param qq 赋值 tb_guestbook.qq
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * 所属表字段为 tb_guestbook.name
     *
     * @return 返回 tb_guestbook.name
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_guestbook.name
     *
     * @param name 赋值 tb_guestbook.name
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_guestbook.email
     *
     * @return 返回 tb_guestbook.email
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter方法 tb_guestbook.email
     *
     * @param email 赋值 tb_guestbook.email
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 所属表字段为 tb_guestbook.create_date
     *
     * @return 返回 tb_guestbook.create_date
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_guestbook.create_date
     *
     * @param createDate 赋值 tb_guestbook.create_date
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_guestbook.update_date
     *
     * @return 返回 tb_guestbook.update_date
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_guestbook.update_date
     *
     * @param updateDate 赋值 tb_guestbook.update_date
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}