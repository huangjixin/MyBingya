package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.UserRole;
import com.jcin.cms.domain.system.UserRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int deleteBatch(List list);

    int insertBatch(List<UserRole> list);

    int countByExample(UserRoleCriteria example);

    int deleteByExample(UserRoleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleCriteria example);

    UserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}