package com.jcin.cms.modules.bet.dao;

import com.jcin.cms.modules.bet.domain.FruitRecord;
import com.jcin.cms.modules.bet.domain.FruitRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FruitRecordMapper {
    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int insertBatch(List<FruitRecord> list);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int countByExample(FruitRecordCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int deleteByExample(FruitRecordCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int insert(FruitRecord record);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int insertSelective(FruitRecord record);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    List<FruitRecord> selectByExample(FruitRecordCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    FruitRecord selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByExampleSelective(@Param("record") FruitRecord record, @Param("example") FruitRecordCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByExample(@Param("record") FruitRecord record, @Param("example") FruitRecordCriteria example);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByPrimaryKeySelective(FruitRecord record);

    /**
     * 该方法由系统生成 tb_fruit_record
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    int updateByPrimaryKey(FruitRecord record);
}