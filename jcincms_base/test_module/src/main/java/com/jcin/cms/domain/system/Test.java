package com.jcin.cms.domain.system;

import java.io.Serializable;

public class Test implements Serializable {
    /**
     *  主键ID 所属表字段为tb_test.id
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    private String id;

    /**
     *  描述信息 所属表字段为tb_test.description
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    private String description;

    /**
     * 该字段对应数据库表 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_test.id
     *
     * @return 返回 tb_test.id
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_test.id
     *
     * @param id 赋值 tb_test.id
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_test.description
     *
     * @return 返回 tb_test.description
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_test.description
     *
     * @param description 赋值 tb_test.description
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}