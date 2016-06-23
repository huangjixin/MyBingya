package com.jcin.cms.modules.syst.domain;

import java.io.Serializable;

public class Dictionary implements Serializable {
    /**
     *   所属表字段为tb_dictionary.id
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    private String id;

    /**
     *   所属表字段为tb_dictionary.type
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    private String type;

    /**
     *   所属表字段为tb_dictionary.label
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    private String label;

    /**
     *   所属表字段为tb_dictionary.value
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    private String value;

    /**
     * 该字段对应数据库表 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_dictionary.id
     *
     * @return 返回 tb_dictionary.id
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_dictionary.id
     *
     * @param id 赋值 tb_dictionary.id
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_dictionary.type
     *
     * @return 返回 tb_dictionary.type
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    public String getType() {
        return type;
    }

    /**
     * setter方法 tb_dictionary.type
     *
     * @param type 赋值 tb_dictionary.type
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 所属表字段为 tb_dictionary.label
     *
     * @return 返回 tb_dictionary.label
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    public String getLabel() {
        return label;
    }

    /**
     * setter方法 tb_dictionary.label
     *
     * @param label 赋值 tb_dictionary.label
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     * 所属表字段为 tb_dictionary.value
     *
     * @return 返回 tb_dictionary.value
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    public String getValue() {
        return value;
    }

    /**
     * setter方法 tb_dictionary.value
     *
     * @param value 赋值 tb_dictionary.value
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}