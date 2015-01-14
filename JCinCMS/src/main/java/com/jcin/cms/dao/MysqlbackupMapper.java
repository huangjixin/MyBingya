package com.jcin.cms.dao;

import com.jcin.cms.domain.Mysqlbackup;
import com.jcin.cms.domain.MysqlbackupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MysqlbackupMapper {
    int deleteBatch(List list);

    int insertBatch(List<Mysqlbackup> list);

    int countByExample(MysqlbackupCriteria example);

    int deleteByExample(MysqlbackupCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Mysqlbackup record);

    int insertSelective(Mysqlbackup record);

    List<Mysqlbackup> selectByExample(MysqlbackupCriteria example);

    Mysqlbackup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Mysqlbackup record, @Param("example") MysqlbackupCriteria example);

    int updateByExample(@Param("record") Mysqlbackup record, @Param("example") MysqlbackupCriteria example);

    int updateByPrimaryKeySelective(Mysqlbackup record);

    int updateByPrimaryKey(Mysqlbackup record);
}