package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class UserRole implements Serializable {
    /**
     *   所属表字段为tb_user_role.id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private String id;

    /**
     *   所属表字段为tb_user_role.user_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private String userId;

    /**
     *   所属表字段为tb_user_role.tb_role_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private String tbRoleId;

    /**
     * 该字段对应数据库表 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_user_role.id
     *
     * @return 返回 tb_user_role.id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_user_role.id
     *
     * @param id 赋值 tb_user_role.id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_user_role.user_id
     *
     * @return 返回 tb_user_role.user_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public String getUserId() {
        return userId;
    }

    /**
     * setter方法 tb_user_role.user_id
     *
     * @param userId 赋值 tb_user_role.user_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 所属表字段为 tb_user_role.tb_role_id
     *
     * @return 返回 tb_user_role.tb_role_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public String getTbRoleId() {
        return tbRoleId;
    }

    /**
     * setter方法 tb_user_role.tb_role_id
     *
     * @param tbRoleId 赋值 tb_user_role.tb_role_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setTbRoleId(String tbRoleId) {
        this.tbRoleId = tbRoleId == null ? null : tbRoleId.trim();
    }
}