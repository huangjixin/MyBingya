package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.Test;
import com.jcin.cms.domain.system.TestCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    int insertBatch(List<Test> list);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    int countByExample(TestCriteria example);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    int deleteByExample(TestCriteria example);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    int insert(Test record);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    int insertSelective(Test record);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    List<Test> selectByExample(TestCriteria example);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    Test selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestCriteria example);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    int updateByExample(@Param("record") Test record, @Param("example") TestCriteria example);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    int updateByPrimaryKeySelective(Test record);

    /**
     * 该方法由系统生成 tb_test
     *
     * @mbggenerated 2015年05月08日 15时28分20秒 星期五
     */
    int updateByPrimaryKey(Test record);
}