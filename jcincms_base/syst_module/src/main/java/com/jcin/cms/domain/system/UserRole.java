package com.jcin.cms.domain.system;

import java.io.Serializable;

public class UserRole implements Serializable {
    /**
     *   所属表字段为tb_user_role.id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    private String id;

    /**
     *   所属表字段为tb_user_role.user_id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    private String userId;

    /**
     *   所属表字段为tb_user_role.role_id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    private String roleId;

    /**
     * 该字段对应数据库表 tb_user_role
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_user_role.id
     *
     * @return 返回 tb_user_role.id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_user_role.id
     *
     * @param id 赋值 tb_user_role.id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_user_role.user_id
     *
     * @return 返回 tb_user_role.user_id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public String getUserId() {
        return userId;
    }

    /**
     * setter方法 tb_user_role.user_id
     *
     * @param userId 赋值 tb_user_role.user_id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 所属表字段为 tb_user_role.role_id
     *
     * @return 返回 tb_user_role.role_id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * setter方法 tb_user_role.role_id
     *
     * @param roleId 赋值 tb_user_role.role_id
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}