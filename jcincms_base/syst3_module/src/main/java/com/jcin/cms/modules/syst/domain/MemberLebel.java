package com.jcin.cms.modules.syst.domain;

import java.io.Serializable;

public class MemberLebel implements Serializable {
    /**
     *   所属表字段为tb_member_lebel.id
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    private String id;

    /**
     *  会员级别名称 所属表字段为tb_member_lebel.name
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    private String name;

    /**
     *  名称 所属表字段为tb_member_lebel.description
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    private String description;

    /**
     * 该字段对应数据库表 tb_member_lebel
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_member_lebel.id
     *
     * @return 返回 tb_member_lebel.id
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_member_lebel.id
     *
     * @param id 赋值 tb_member_lebel.id
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_member_lebel.name
     *
     * @return 返回 tb_member_lebel.name
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    public String getName() {
        return name;
    }

    /**
     * setter方法 tb_member_lebel.name
     *
     * @param name 赋值 tb_member_lebel.name
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属表字段为 tb_member_lebel.description
     *
     * @return 返回 tb_member_lebel.description
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 tb_member_lebel.description
     *
     * @param description 赋值 tb_member_lebel.description
     *
     * @mbggenerated 2016年04月16日 22时29分05秒 星期六
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}