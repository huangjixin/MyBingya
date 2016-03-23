package com.jcin.cms.modules.bet.dao;

import com.jcin.cms.modules.bet.domain.FruitBetresult;
import com.jcin.cms.modules.bet.domain.FruitBetresultCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FruitBetresultMapper {
    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int insertBatch(List<FruitBetresult> list);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int countByExample(FruitBetresultCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int deleteByExample(FruitBetresultCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int insert(FruitBetresult record);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int insertSelective(FruitBetresult record);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    List<FruitBetresult> selectByExample(FruitBetresultCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    FruitBetresult selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByExampleSelective(@Param("record") FruitBetresult record, @Param("example") FruitBetresultCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByExample(@Param("record") FruitBetresult record, @Param("example") FruitBetresultCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByPrimaryKeySelective(FruitBetresult record);

    /**
     * 该方法由系统生成 tb_fruit_betresult
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByPrimaryKey(FruitBetresult record);
}