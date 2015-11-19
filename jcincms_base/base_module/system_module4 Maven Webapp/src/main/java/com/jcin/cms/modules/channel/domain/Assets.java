package com.jcin.cms.modules.channel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Assets implements Serializable {
    /**
     *   所属表字段为tb_assets.id
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    private String id;

    /**
     *   所属表字段为tb_assets.name
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    private String name;

    /**
     *   所属表字段为tb_assets.path
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    private String path;

    /**
     *   所属表字段为tb_assets.url
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    private String url;

    /**
     *   所属表字段为tb_assets.create_date
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     *   所属表字段为tb_assets.update_date
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     *   所属表字段为tb_assets.size
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    private Integer size;

    /**
     * 该字段对应数据库表 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_assets.id
     *
     * @return 返回 tb_assets.id
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_assets.id
     *
     * @param id 赋值 tb_assets.id
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_assets.name
     *
     * @return 返回 tb_assets.name
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_assets.name
     *
     * @param name 赋值 tb_assets.name
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_assets.path
     *
     * @return 返回 tb_assets.path
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public String getPath() {
        return path;
    }

    /**
     * setter方法 tb_assets.path
     *
     * @param path 赋值 tb_assets.path
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 所属表字段为 tb_assets.url
     *
     * @return 返回 tb_assets.url
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public String getUrl() {
        return url;
    }

    /**
     * setter方法 tb_assets.url
     *
     * @param url 赋值 tb_assets.url
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 所属表字段为 tb_assets.create_date
     *
     * @return 返回 tb_assets.create_date
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_assets.create_date
     *
     * @param createDate 赋值 tb_assets.create_date
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 所属表字段为 tb_assets.update_date
     *
     * @return 返回 tb_assets.update_date
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * setter方法 tb_assets.update_date
     *
     * @param updateDate 赋值 tb_assets.update_date
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 所属表字段为 tb_assets.size
     *
     * @return 返回 tb_assets.size
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public Integer getSize() {
        return size;
    }

    /**
     * setter方法 tb_assets.size
     *
     * @param size 赋值 tb_assets.size
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    public void setSize(Integer size) {
        this.size = size;
    }
}