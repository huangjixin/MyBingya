package com.jcin.cms.modules.syst.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

public class RoleMenu implements Serializable {
    /**
     *   所属表字段为tb_role_menu.id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private String id;

    /**
     *   所属表字段为tb_role_menu.role_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private String roleId;

    /**
     *   所属表字段为tb_role_menu.menu_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private String menuId;

    /**
     * 该字段对应数据库表 tb_role_menu
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 tb_role_menu.id
     *
     * @return 返回 tb_role_menu.id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public String getId() {
        return id;
    }

    /**
     * setter方法 tb_role_menu.id
     *
     * @param id 赋值 tb_role_menu.id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 所属表字段为 tb_role_menu.role_id
     *
     * @return 返回 tb_role_menu.role_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * setter方法 tb_role_menu.role_id
     *
     * @param roleId 赋值 tb_role_menu.role_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * 所属表字段为 tb_role_menu.menu_id
     *
     * @return 返回 tb_role_menu.menu_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * setter方法 tb_role_menu.menu_id
     *
     * @param menuId 赋值 tb_role_menu.menu_id
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}