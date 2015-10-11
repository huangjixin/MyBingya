package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class TqunhuInfo implements Serializable {
    /**
     *   所属表字段为t_qunhu_info.id
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    private Integer id;

    /**
     *  数据规则：qunhu20150929_4455,qunhu+当天时间+4455是上一条记录的“_”后面的数字+1 所属表字段为t_qunhu_info.create_Name
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    private String createName;

    /**
     *  数据表名 所属表字段为t_qunhu_info.table_Name
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    private String tableName;

    /**
     *   所属表字段为t_qunhu_info.times
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    private String times;

    /**
     *   所属表字段为t_qunhu_info.callbs
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    private String callbs;

    /**
     *   所属表字段为t_qunhu_info.countB
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    private Integer countb;

    /**
     *   所属表字段为t_qunhu_info.filename
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    private String filename;

    /**
     *   所属表字段为t_qunhu_info.ip
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    private String ip;

    /**
     *   所属表字段为t_qunhu_info.leixing
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    private Integer leixing;

    /**
     * 该字段对应数据库表 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 t_qunhu_info.id
     *
     * @return 返回 t_qunhu_info.id
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public Integer getId() {
        return id;
    }

    /**
     * setter方法 t_qunhu_info.id
     *
     * @param id 赋值 t_qunhu_info.id
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 所属表字段为 t_qunhu_info.create_Name
     *
     * @return 返回 t_qunhu_info.create_Name
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * setter方法 t_qunhu_info.create_Name
     *
     * @param createName 赋值 t_qunhu_info.create_Name
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 所属表字段为 t_qunhu_info.table_Name
     *
     * @return 返回 t_qunhu_info.table_Name
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * setter方法 t_qunhu_info.table_Name
     *
     * @param tableName 赋值 t_qunhu_info.table_Name
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * 所属表字段为 t_qunhu_info.times
     *
     * @return 返回 t_qunhu_info.times
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public String getTimes() {
        return times;
    }

    /**
     * setter方法 t_qunhu_info.times
     *
     * @param times 赋值 t_qunhu_info.times
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setTimes(String times) {
        this.times = times == null ? null : times.trim();
    }

    /**
     * 所属表字段为 t_qunhu_info.callbs
     *
     * @return 返回 t_qunhu_info.callbs
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public String getCallbs() {
        return callbs;
    }

    /**
     * setter方法 t_qunhu_info.callbs
     *
     * @param callbs 赋值 t_qunhu_info.callbs
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setCallbs(String callbs) {
        this.callbs = callbs == null ? null : callbs.trim();
    }

    /**
     * 所属表字段为 t_qunhu_info.countB
     *
     * @return 返回 t_qunhu_info.countB
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public Integer getCountb() {
        return countb;
    }

    /**
     * setter方法 t_qunhu_info.countB
     *
     * @param countb 赋值 t_qunhu_info.countB
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setCountb(Integer countb) {
        this.countb = countb;
    }

    /**
     * 所属表字段为 t_qunhu_info.filename
     *
     * @return 返回 t_qunhu_info.filename
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public String getFilename() {
        return filename;
    }

    /**
     * setter方法 t_qunhu_info.filename
     *
     * @param filename 赋值 t_qunhu_info.filename
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * 所属表字段为 t_qunhu_info.ip
     *
     * @return 返回 t_qunhu_info.ip
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public String getIp() {
        return ip;
    }

    /**
     * setter方法 t_qunhu_info.ip
     *
     * @param ip 赋值 t_qunhu_info.ip
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 所属表字段为 t_qunhu_info.leixing
     *
     * @return 返回 t_qunhu_info.leixing
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public Integer getLeixing() {
        return leixing;
    }

    /**
     * setter方法 t_qunhu_info.leixing
     *
     * @param leixing 赋值 t_qunhu_info.leixing
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setLeixing(Integer leixing) {
        this.leixing = leixing;
    }
}