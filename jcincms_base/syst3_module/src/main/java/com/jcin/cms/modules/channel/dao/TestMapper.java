package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.Test;
import com.jcin.cms.modules.channel.domain.TestCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int insertBatch(List<Test> list);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int countByExample(TestCriteria example);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int deleteByExample(TestCriteria example);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int insert(Test record);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int insertSelective(Test record);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    List<Test> selectByExample(TestCriteria example);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    Test selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestCriteria example);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByExample(@Param("record") Test record, @Param("example") TestCriteria example);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByPrimaryKeySelective(Test record);

    /**
     * 该方法由系统生成 test
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByPrimaryKey(Test record);
}