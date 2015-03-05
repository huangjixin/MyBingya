package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.RoleAuthorization;
import com.jcin.cms.domain.system.RoleAuthorizationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAuthorizationMapper {
    int deleteBatch(List list);

    int insertBatch(List<RoleAuthorization> list);

    int countByExample(RoleAuthorizationCriteria example);

    int deleteByExample(RoleAuthorizationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RoleAuthorization record);

    int insertSelective(RoleAuthorization record);

    List<RoleAuthorization> selectByExample(RoleAuthorizationCriteria example);

    RoleAuthorization selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleAuthorization record, @Param("example") RoleAuthorizationCriteria example);

    int updateByExample(@Param("record") RoleAuthorization record, @Param("example") RoleAuthorizationCriteria example);

    int updateByPrimaryKeySelective(RoleAuthorization record);

    int updateByPrimaryKey(RoleAuthorization record);
}