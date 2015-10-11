package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class Role implements Serializable {
    /**
     *   所属表字段为tb_role.id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private String id;

    /**
     *   所属表字段为tb_role.name
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private String name;

    /**
     * 该字段对应数据库表 tb_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_role.id
     *
     * @return 返回 tb_role.id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_role.id
     *
     * @param id 赋值 tb_role.id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_role.name
     *
     * @return 返回 tb_role.name
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_role.name
     *
     * @param name 赋值 tb_role.name
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}