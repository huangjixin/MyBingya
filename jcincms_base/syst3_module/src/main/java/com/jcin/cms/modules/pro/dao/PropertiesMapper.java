package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.Properties;
import com.jcin.cms.modules.pro.domain.PropertiesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropertiesMapper {
    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertBatch(List<Properties> list);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int countByExample(PropertiesCriteria example);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByExample(PropertiesCriteria example);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insert(Properties record);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertSelective(Properties record);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<Properties> selectByExample(PropertiesCriteria example);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    Properties selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleSelective(@Param("record") Properties record, @Param("example") PropertiesCriteria example);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExample(@Param("record") Properties record, @Param("example") PropertiesCriteria example);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeySelective(Properties record);

    /**
     * 该方法由系统生成 pro_properties
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKey(Properties record);
}