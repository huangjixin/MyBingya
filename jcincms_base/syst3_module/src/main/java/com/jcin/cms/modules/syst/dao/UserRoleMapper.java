package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.UserRole;
import com.jcin.cms.modules.syst.domain.UserRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    int insertBatch(List<UserRole> list);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    int countByExample(UserRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    int deleteByExample(UserRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    int insert(UserRole record);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    int insertSelective(UserRole record);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    List<UserRole> selectByExample(UserRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    UserRole selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    int updateByPrimaryKey(UserRole record);
}