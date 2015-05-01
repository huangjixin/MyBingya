package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.Test;
import com.jcin.cms.domain.system.TestCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int deleteBatch(List list);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int insertBatch(List<Test> list);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int countByExample(TestCriteria example);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int deleteByExample(TestCriteria example);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int insert(Test record);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int insertSelective(Test record);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    List<Test> selectByExampleWithBLOBs(TestCriteria example);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    List<Test> selectByExample(TestCriteria example);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    Test selectByPrimaryKey(String id);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestCriteria example);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int updateByExampleWithBLOBs(@Param("record") Test record, @Param("example") TestCriteria example);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int updateByExample(@Param("record") Test record, @Param("example") TestCriteria example);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int updateByPrimaryKeySelective(Test record);

    /**
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated 2015年04月30日 14时27分52秒 星期四
     */
    int updateByPrimaryKeyWithBLOBs(Test record);
}