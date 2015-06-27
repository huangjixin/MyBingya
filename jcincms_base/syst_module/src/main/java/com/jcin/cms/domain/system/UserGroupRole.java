package com.jcin.cms.domain.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class UserGroupRole implements Serializable {
    /**
     *   所属表字段为tb_user_group_role.id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private String id;

    /**
     *   所属表字段为tb_user_group_role.role_id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private String roleId;

    /**
     *   所属表字段为tb_user_group_role.user_group_id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private String userGroupId;

    /**
     * 该字段对应数据库表 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_user_group_role.id
     *
     * @return 返回 tb_user_group_role.id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_user_group_role.id
     *
     * @param id 赋值 tb_user_group_role.id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_user_group_role.role_id
     *
     * @return 返回 tb_user_group_role.role_id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * setter方法 tb_user_group_role.role_id
     *
     * @param roleId 赋值 tb_user_group_role.role_id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * 所属表字段为 tb_user_group_role.user_group_id
     *
     * @return 返回 tb_user_group_role.user_group_id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public String getUserGroupId() {
        return userGroupId;
    }

    /**
     * setter方法 tb_user_group_role.user_group_id
     *
     * @param userGroupId 赋值 tb_user_group_role.user_group_id
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId == null ? null : userGroupId.trim();
    }
}