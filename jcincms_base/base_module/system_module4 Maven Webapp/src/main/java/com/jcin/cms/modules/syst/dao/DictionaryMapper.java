package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.Dictionary;
import com.jcin.cms.modules.syst.domain.DictionaryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryMapper {
    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    int insertBatch(List<Dictionary> list);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    int countByExample(DictionaryCriteria example);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    int deleteByExample(DictionaryCriteria example);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    int insert(Dictionary record);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    int insertSelective(Dictionary record);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    List<Dictionary> selectByExample(DictionaryCriteria example);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    Dictionary selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    int updateByExampleSelective(@Param("record") Dictionary record, @Param("example") DictionaryCriteria example);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    int updateByExample(@Param("record") Dictionary record, @Param("example") DictionaryCriteria example);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    int updateByPrimaryKeySelective(Dictionary record);

    /**
     * 该方法由系统生成 tb_dictionary
     *
     * @mbggenerated 2015年10月10日 18时30分54秒 星期六
     */
    int updateByPrimaryKey(Dictionary record);
}