package com.jcin.cms.domain.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class RoleAuthorization implements Serializable {
    /**
     *   所属表字段为tb_role_authorization.id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    private String id;

    /**
     *   所属表字段为tb_role_authorization.role_id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    private String roleId;

    /**
     *   所属表字段为tb_role_authorization.authorization_id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    private String authorizationId;

    /**
     * 该字段对应数据库表 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_role_authorization.id
     *
     * @return 返回 tb_role_authorization.id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_role_authorization.id
     *
     * @param id 赋值 tb_role_authorization.id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_role_authorization.role_id
     *
     * @return 返回 tb_role_authorization.role_id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * setter方法 tb_role_authorization.role_id
     *
     * @param roleId 赋值 tb_role_authorization.role_id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * 所属表字段为 tb_role_authorization.authorization_id
     *
     * @return 返回 tb_role_authorization.authorization_id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public String getAuthorizationId() {
        return authorizationId;
    }

    /**
     * setter方法 tb_role_authorization.authorization_id
     *
     * @param authorizationId 赋值 tb_role_authorization.authorization_id
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId == null ? null : authorizationId.trim();
    }
}