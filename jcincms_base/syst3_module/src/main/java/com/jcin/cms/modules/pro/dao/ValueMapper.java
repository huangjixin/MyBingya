package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.Value;
import com.jcin.cms.modules.pro.domain.ValueCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ValueMapper {
    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertBatch(List<Value> list);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int countByExample(ValueCriteria example);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByExample(ValueCriteria example);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insert(Value record);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertSelective(Value record);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<Value> selectByExample(ValueCriteria example);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    Value selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleSelective(@Param("record") Value record, @Param("example") ValueCriteria example);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExample(@Param("record") Value record, @Param("example") ValueCriteria example);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeySelective(Value record);

    /**
     * 该方法由系统生成 pro_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKey(Value record);
}