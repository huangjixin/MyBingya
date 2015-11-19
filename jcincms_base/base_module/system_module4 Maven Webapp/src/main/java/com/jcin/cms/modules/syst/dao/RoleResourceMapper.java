package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.RoleResource;
import com.jcin.cms.modules.syst.domain.RoleResourceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResourceMapper {
    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    int insertBatch(List<RoleResource> list);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    int countByExample(RoleResourceCriteria example);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    int deleteByExample(RoleResourceCriteria example);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    int insert(RoleResource record);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    int insertSelective(RoleResource record);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    List<RoleResource> selectByExample(RoleResourceCriteria example);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    RoleResource selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    int updateByExampleSelective(@Param("record") RoleResource record, @Param("example") RoleResourceCriteria example);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    int updateByExample(@Param("record") RoleResource record, @Param("example") RoleResourceCriteria example);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    int updateByPrimaryKeySelective(RoleResource record);

    /**
     * 该方法由系统生成 tb_role_resource
     *
     * @mbggenerated 2015年10月11日 15时24分37秒 星期日
     */
    int updateByPrimaryKey(RoleResource record);
}