package com.jcin.cms.dao;

import com.jcin.cms.domain.NotPayed;
import com.jcin.cms.domain.NotPayedCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotPayedMapper {
    int deleteBatch(List list);

    int insertBatch(List<NotPayed> list);

    int countByExample(NotPayedCriteria example);

    int deleteByExample(NotPayedCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(NotPayed record);

    int insertSelective(NotPayed record);

    List<NotPayed> selectByExample(NotPayedCriteria example);

    NotPayed selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NotPayed record, @Param("example") NotPayedCriteria example);

    int updateByExample(@Param("record") NotPayed record, @Param("example") NotPayedCriteria example);

    int updateByPrimaryKeySelective(NotPayed record);

    int updateByPrimaryKey(NotPayed record);
    
    double getTotalGoodsMoney(NotPayedCriteria example);
}