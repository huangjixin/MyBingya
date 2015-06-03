package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.UserRole;
import com.jcin.cms.domain.system.UserRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insertBatch(List<UserRole> list);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int countByExample(UserRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteByExample(UserRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insert(UserRole record);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insertSelective(UserRole record);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    List<UserRole> selectByExample(UserRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    UserRole selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByPrimaryKey(UserRole record);
}