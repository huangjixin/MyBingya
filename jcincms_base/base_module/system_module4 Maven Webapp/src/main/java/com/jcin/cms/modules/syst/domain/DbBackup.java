package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class DbBackup implements Serializable {
    /**
     *   所属表字段为tb_db_backup.id
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    private String id;

    /**
     *  名称 所属表字段为tb_db_backup.name
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    private String name;

    /**
     *  存放路径 所属表字段为tb_db_backup.path
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    private String path;

    /**
     *  创建日期 所属表字段为tb_db_backup.create_date
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     * 该字段对应数据库表 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_db_backup.id
     *
     * @return 返回 tb_db_backup.id
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_db_backup.id
     *
     * @param id 赋值 tb_db_backup.id
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_db_backup.name
     *
     * @return 返回 tb_db_backup.name
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_db_backup.name
     *
     * @param name 赋值 tb_db_backup.name
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_db_backup.path
     *
     * @return 返回 tb_db_backup.path
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    public String getPath() {
        return path;
    }

    /**
     * setter方法 tb_db_backup.path
     *
     * @param path 赋值 tb_db_backup.path
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 所属表字段为 tb_db_backup.create_date
     *
     * @return 返回 tb_db_backup.create_date
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setter方法 tb_db_backup.create_date
     *
     * @param createDate 赋值 tb_db_backup.create_date
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}