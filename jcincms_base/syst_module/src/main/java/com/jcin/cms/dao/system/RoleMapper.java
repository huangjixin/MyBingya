package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.RoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int insertBatch(List<Role> list);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int countByExample(RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int deleteByExample(RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int insert(Role record);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int insertSelective(Role record);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    List<Role> selectByExample(RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    Role selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleCriteria example);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * 该方法由系统生成 tb_role
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByPrimaryKey(Role record);
}