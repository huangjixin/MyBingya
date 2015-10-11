package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.Menu;
import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.domain.ResourceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    int insertBatch(List<Resource> list);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    int countByExample(ResourceCriteria example);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    int deleteByExample(ResourceCriteria example);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    int insert(Resource record);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    int insertSelective(Resource record);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    List<Resource> selectByExample(ResourceCriteria example);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    Resource selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceCriteria example);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    int updateByExample(@Param("record") Resource record, @Param("example") ResourceCriteria example);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     * 该方法由系统生成 tb_resource
     *
     * @mbggenerated 2015年09月29日 16时42分33秒 星期二
     */
    int updateByPrimaryKey(Resource record);
    
    /**
     * 根据用户名查询角色。
     * @param username
     * @return
     */
    List<Resource> selectByUsername(String username);
}