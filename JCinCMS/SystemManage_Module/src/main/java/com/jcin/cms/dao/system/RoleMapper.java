package com.jcin.cms.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.RoleCriteria;

public interface RoleMapper {
    int deleteBatch(List list);

    int insertBatch(List<Role> list);

    int countByExample(RoleCriteria example);

    int deleteByExample(RoleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleCriteria example);

    Role selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleCriteria example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleCriteria example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    ////////////// 自定义
    List<Role> getRolesByUserId(String userId);
    
    List<Authorization> getAuthorizationsByRoleId(String id);
    
}