package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.UserGroup;
import com.jcin.cms.domain.system.UserGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupMapper {
    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int insertBatch(List<UserGroup> list);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int countByExample(UserGroupCriteria example);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int deleteByExample(UserGroupCriteria example);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int insert(UserGroup record);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int insertSelective(UserGroup record);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    List<UserGroup> selectByExample(UserGroupCriteria example);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    UserGroup selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByExampleSelective(@Param("record") UserGroup record, @Param("example") UserGroupCriteria example);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByExample(@Param("record") UserGroup record, @Param("example") UserGroupCriteria example);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByPrimaryKeySelective(UserGroup record);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByPrimaryKey(UserGroup record);
}