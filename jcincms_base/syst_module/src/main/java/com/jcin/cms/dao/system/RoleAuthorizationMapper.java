package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.RoleAuthorization;
import com.jcin.cms.domain.system.RoleAuthorizationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAuthorizationMapper {
    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int insertBatch(List<RoleAuthorization> list);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int countByExample(RoleAuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int deleteByExample(RoleAuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int insert(RoleAuthorization record);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int insertSelective(RoleAuthorization record);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    List<RoleAuthorization> selectByExample(RoleAuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    RoleAuthorization selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByExampleSelective(@Param("record") RoleAuthorization record, @Param("example") RoleAuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByExample(@Param("record") RoleAuthorization record, @Param("example") RoleAuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByPrimaryKeySelective(RoleAuthorization record);

    /**
     * 该方法由系统生成 tb_role_authorization
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByPrimaryKey(RoleAuthorization record);
}