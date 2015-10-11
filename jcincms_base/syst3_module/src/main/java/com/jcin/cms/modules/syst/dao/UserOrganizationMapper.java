package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.UserOrganization;
import com.jcin.cms.modules.syst.domain.UserOrganizationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOrganizationMapper {
    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int insertBatch(List<UserOrganization> list);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int countByExample(UserOrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int deleteByExample(UserOrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int insert(UserOrganization record);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int insertSelective(UserOrganization record);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    List<UserOrganization> selectByExample(UserOrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    UserOrganization selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int updateByExampleSelective(@Param("record") UserOrganization record, @Param("example") UserOrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int updateByExample(@Param("record") UserOrganization record, @Param("example") UserOrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int updateByPrimaryKeySelective(UserOrganization record);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int updateByPrimaryKey(UserOrganization record);
}