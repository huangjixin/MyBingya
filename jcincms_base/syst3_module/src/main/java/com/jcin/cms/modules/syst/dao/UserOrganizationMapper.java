package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.UserOrganization;
import com.jcin.cms.modules.syst.domain.UserOrganizationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOrganizationMapper {
    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    int insertBatch(List<UserOrganization> list);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    int countByExample(UserOrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    int deleteByExample(UserOrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    int insert(UserOrganization record);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    int insertSelective(UserOrganization record);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    List<UserOrganization> selectByExample(UserOrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    UserOrganization selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    int updateByExampleSelective(@Param("record") UserOrganization record, @Param("example") UserOrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    int updateByExample(@Param("record") UserOrganization record, @Param("example") UserOrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    int updateByPrimaryKeySelective(UserOrganization record);

    /**
     * 该方法由系统生成 tb_user_organization
     *
     * @mbggenerated 2015年10月12日 19时55分54秒 星期一
     */
    int updateByPrimaryKey(UserOrganization record);
}