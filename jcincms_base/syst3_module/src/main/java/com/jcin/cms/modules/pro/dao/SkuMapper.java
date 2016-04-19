package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.Sku;
import com.jcin.cms.modules.pro.domain.SkuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkuMapper {
    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertBatch(List<Sku> list);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int countByExample(SkuCriteria example);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByExample(SkuCriteria example);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insert(Sku record);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertSelective(Sku record);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<Sku> selectByExample(SkuCriteria example);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    Sku selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleSelective(@Param("record") Sku record, @Param("example") SkuCriteria example);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExample(@Param("record") Sku record, @Param("example") SkuCriteria example);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeySelective(Sku record);

    /**
     * 该方法由系统生成 pro_sku
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKey(Sku record);
}