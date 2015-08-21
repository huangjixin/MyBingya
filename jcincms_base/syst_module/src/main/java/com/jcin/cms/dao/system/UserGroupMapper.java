package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.UserGroup;
import com.jcin.cms.domain.system.UserGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupMapper {
    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    int insertBatch(List<UserGroup> list);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    int countByExample(UserGroupCriteria example);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    int deleteByExample(UserGroupCriteria example);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    int insert(UserGroup record);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    int insertSelective(UserGroup record);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    List<UserGroup> selectByExample(UserGroupCriteria example);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    UserGroup selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    int updateByExampleSelective(@Param("record") UserGroup record, @Param("example") UserGroupCriteria example);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    int updateByExample(@Param("record") UserGroup record, @Param("example") UserGroupCriteria example);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    int updateByPrimaryKeySelective(UserGroup record);

    /**
     * 该方法由系统生成 tb_user_group
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    int updateByPrimaryKey(UserGroup record);
}