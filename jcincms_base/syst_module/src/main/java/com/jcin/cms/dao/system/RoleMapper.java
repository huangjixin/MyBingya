package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.RoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insertBatch(List<Role> list);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int countByExample(RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteByExample(RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insert(Role record);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insertSelective(Role record);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    List<Role> selectByExample(RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    Role selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByPrimaryKey(Role record);
}