package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.UserGroupRole;
import com.jcin.cms.domain.system.UserGroupRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupRoleMapper {
    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int insertBatch(List<UserGroupRole> list);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int countByExample(UserGroupRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int deleteByExample(UserGroupRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int insert(UserGroupRole record);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int insertSelective(UserGroupRole record);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    List<UserGroupRole> selectByExample(UserGroupRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    UserGroupRole selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByExampleSelective(@Param("record") UserGroupRole record, @Param("example") UserGroupRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByExample(@Param("record") UserGroupRole record, @Param("example") UserGroupRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByPrimaryKeySelective(UserGroupRole record);

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByPrimaryKey(UserGroupRole record);
}