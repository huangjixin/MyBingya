package com.jcin.cms.dao;

import com.jcin.cms.domain.Operationlog;
import com.jcin.cms.domain.OperationlogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationlogMapper {
    int insertBatch(List<Operationlog> list);

    int countByExample(OperationlogCriteria example);

    int deleteByExample(OperationlogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Operationlog record);

    int insertSelective(Operationlog record);

    List<Operationlog> selectByExample(OperationlogCriteria example);

    Operationlog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Operationlog record, @Param("example") OperationlogCriteria example);

    int updateByExample(@Param("record") Operationlog record, @Param("example") OperationlogCriteria example);

    int updateByPrimaryKeySelective(Operationlog record);

    int updateByPrimaryKey(Operationlog record);
}