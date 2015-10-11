package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.CreatedTb;
import com.jcin.cms.modules.syst.domain.TqunhuInfo;
import com.jcin.cms.modules.syst.domain.TqunhuInfoCriteria;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TqunhuInfoMapper {
    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    int insertBatch(List<TqunhuInfo> list);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    int countByExample(TqunhuInfoCriteria example);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    int deleteByExample(TqunhuInfoCriteria example);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    int insert(TqunhuInfo record);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    int insertSelective(TqunhuInfo record);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    List<TqunhuInfo> selectByExample(TqunhuInfoCriteria example);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    TqunhuInfo selectByPrimaryKey(Integer id);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    int updateByExampleSelective(@Param("record") TqunhuInfo record, @Param("example") TqunhuInfoCriteria example);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    int updateByExample(@Param("record") TqunhuInfo record, @Param("example") TqunhuInfoCriteria example);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    int updateByPrimaryKeySelective(TqunhuInfo record);

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    int updateByPrimaryKey(TqunhuInfo record);
    
    /**
     * 动态创建表。
     * @param table_name
     */
    void createTableSql(Map map);
    
    /**
     * 动态插入表。
     * @param map
     */
    void insertCreatedTb(CreatedTb createdTb);

    int insertCreatedTable(CreatedTb createdTb);
}