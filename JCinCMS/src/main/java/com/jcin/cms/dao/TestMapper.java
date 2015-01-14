package com.jcin.cms.dao;

import com.jcin.cms.domain.Test;
import com.jcin.cms.domain.TestCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    int deleteBatch(List list);

    int insertBatch(List<Test> list);

    int countByExample(TestCriteria example);

    int deleteByExample(TestCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExampleWithBLOBs(TestCriteria example);

    List<Test> selectByExample(TestCriteria example);

    Test selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestCriteria example);

    int updateByExampleWithBLOBs(@Param("record") Test record, @Param("example") TestCriteria example);

    int updateByExample(@Param("record") Test record, @Param("example") TestCriteria example);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKeyWithBLOBs(Test record);
}