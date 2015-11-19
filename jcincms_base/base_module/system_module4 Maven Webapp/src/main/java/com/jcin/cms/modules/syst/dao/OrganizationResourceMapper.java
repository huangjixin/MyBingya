package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.OrganizationResource;
import com.jcin.cms.modules.syst.domain.OrganizationResourceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationResourceMapper {
    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    int insertBatch(List<OrganizationResource> list);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    int countByExample(OrganizationResourceCriteria example);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    int deleteByExample(OrganizationResourceCriteria example);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    int insert(OrganizationResource record);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    int insertSelective(OrganizationResource record);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    List<OrganizationResource> selectByExample(OrganizationResourceCriteria example);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    OrganizationResource selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    int updateByExampleSelective(@Param("record") OrganizationResource record, @Param("example") OrganizationResourceCriteria example);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    int updateByExample(@Param("record") OrganizationResource record, @Param("example") OrganizationResourceCriteria example);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    int updateByPrimaryKeySelective(OrganizationResource record);

    /**
     * 该方法由系统生成 tb_organization_resource
     *
     * @mbggenerated 2015年10月11日 14时53分23秒 星期日
     */
    int updateByPrimaryKey(OrganizationResource record);
}