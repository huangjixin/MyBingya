package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.Organization;
import com.jcin.cms.modules.syst.domain.OrganizationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper {
    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int insertBatch(List<Organization> list);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int countByExample(OrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int deleteByExample(OrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int insert(Organization record);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int insertSelective(Organization record);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    List<Organization> selectByExample(OrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    Organization selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationCriteria example);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int updateByPrimaryKeySelective(Organization record);

    /**
     * 该方法由系统生成 tb_organization
     *
     * @mbggenerated 2015年10月11日 09时03分48秒 星期日
     */
    int updateByPrimaryKey(Organization record);

	/**
	 * 根据用户名查询组织。
	 * @param username
	 * @return
	 */
	List<Organization> selectByUsername(String username);
}