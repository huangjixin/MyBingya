package com.jcin.cms.modules.sale.dao;

import com.jcin.cms.modules.sale.domain.Buy;
import com.jcin.cms.modules.sale.domain.BuyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuyMapper {
    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int insertBatch(List<Buy> list);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int countByExample(BuyCriteria example);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int deleteByExample(BuyCriteria example);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int insert(Buy record);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int insertSelective(Buy record);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    List<Buy> selectByExample(BuyCriteria example);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    Buy selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int updateByExampleSelective(@Param("record") Buy record, @Param("example") BuyCriteria example);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int updateByExample(@Param("record") Buy record, @Param("example") BuyCriteria example);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int updateByPrimaryKeySelective(Buy record);

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int updateByPrimaryKey(Buy record);
}