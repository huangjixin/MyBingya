package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.domain.ResourceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    int insertBatch(List<Resource> list);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    int countByExample(ResourceCriteria example);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    int deleteByExample(ResourceCriteria example);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    int insert(Resource record);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    int insertSelective(Resource record);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    List<Resource> selectByExample(ResourceCriteria example);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    Resource selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceCriteria example);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    int updateByExample(@Param("record") Resource record, @Param("example") ResourceCriteria example);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年12月13日 10时47分30秒 星期日
     */
    int updateByPrimaryKey(Resource record);
    

    /**
     * 根据用户名查询资源。
     * @param username
     * @return
     */
    List<Resource> selectByUsername(String username);
    
    /**
     * 根据用户名通过组织查询资源。
     * @param username
     * @return
     */
    List<Resource> selectOnOrgByUsername(String username);
    
    /**
	 * 根据角色id查询权限
	 * @param username
	 * @return
	 */
	List<Resource> selectByRoleId(String roleId);

	/**
	 * 根据组织id查询权限
	 * @param orgId
	 * @return
	 */
	List<Resource> selectByOrgId(String orgId);
}