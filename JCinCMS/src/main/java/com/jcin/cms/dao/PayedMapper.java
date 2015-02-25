package com.jcin.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jcin.cms.domain.Payed;
import com.jcin.cms.domain.PayedCriteria;

public interface PayedMapper {
    int deleteBatch(List list);

    int insertBatch(List<Payed> list);

    int countByExample(PayedCriteria example);

    int deleteByExample(PayedCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Payed record);

    int insertSelective(Payed record);

    List<Payed> selectByExample(PayedCriteria example);

    Payed selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Payed record, @Param("example") PayedCriteria example);

    int updateByExample(@Param("record") Payed record, @Param("example") PayedCriteria example);

    int updateByPrimaryKeySelective(Payed record);

    int updateByPrimaryKey(Payed record);
    
    double getTotalGoodsMoney(PayedCriteria example);
}