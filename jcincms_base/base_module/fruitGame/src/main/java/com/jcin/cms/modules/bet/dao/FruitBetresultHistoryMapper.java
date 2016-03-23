package com.jcin.cms.modules.bet.dao;

import com.jcin.cms.modules.bet.domain.FruitBetresultHistory;
import com.jcin.cms.modules.bet.domain.FruitBetresultHistoryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FruitBetresultHistoryMapper {
    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int insertBatch(List<FruitBetresultHistory> list);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int countByExample(FruitBetresultHistoryCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int deleteByExample(FruitBetresultHistoryCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int insert(FruitBetresultHistory record);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int insertSelective(FruitBetresultHistory record);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    List<FruitBetresultHistory> selectByExample(FruitBetresultHistoryCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    FruitBetresultHistory selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByExampleSelective(@Param("record") FruitBetresultHistory record, @Param("example") FruitBetresultHistoryCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByExample(@Param("record") FruitBetresultHistory record, @Param("example") FruitBetresultHistoryCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByPrimaryKeySelective(FruitBetresultHistory record);

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByPrimaryKey(FruitBetresultHistory record);
}