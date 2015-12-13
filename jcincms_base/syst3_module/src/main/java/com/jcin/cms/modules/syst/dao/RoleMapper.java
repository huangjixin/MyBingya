package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.Role;
import com.jcin.cms.modules.syst.domain.RoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    int insertBatch(List<Role> list);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    int countByExample(RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    int deleteByExample(RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    int insert(Role record);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    int insertSelective(Role record);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    List<Role> selectByExample(RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    Role selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年12月13日 09时14分07秒 星期日
     */
    int updateByPrimaryKey(Role record);
    
    /**
     * 根据用户名查询角色。
     * @param username
     * @return
     */
    List<Role> selectByUsername(String username);
}