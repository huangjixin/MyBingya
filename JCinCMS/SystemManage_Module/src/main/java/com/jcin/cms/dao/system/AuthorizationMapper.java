package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.AuthorizationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorizationMapper {
    int deleteBatch(List list);

    int insertBatch(List<Authorization> list);

    int countByExample(AuthorizationCriteria example);

    int deleteByExample(AuthorizationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Authorization record);

    int insertSelective(Authorization record);

    List<Authorization> selectByExample(AuthorizationCriteria example);

    Authorization selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Authorization record, @Param("example") AuthorizationCriteria example);

    int updateByExample(@Param("record") Authorization record, @Param("example") AuthorizationCriteria example);

    int updateByPrimaryKeySelective(Authorization record);

    int updateByPrimaryKey(Authorization record);
    
    /**
     * 根据菜单查询访问列表。
     * @param userId
     * @return
     */
    List<Authorization> selectByUserId(String userId);
}