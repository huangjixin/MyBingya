package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.ProductValue;
import com.jcin.cms.modules.pro.domain.ProductValueCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductValueMapper {
    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertBatch(List<ProductValue> list);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int countByExample(ProductValueCriteria example);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByExample(ProductValueCriteria example);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insert(ProductValue record);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertSelective(ProductValue record);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<ProductValue> selectByExample(ProductValueCriteria example);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    ProductValue selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleSelective(@Param("record") ProductValue record, @Param("example") ProductValueCriteria example);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExample(@Param("record") ProductValue record, @Param("example") ProductValueCriteria example);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeySelective(ProductValue record);

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKey(ProductValue record);
}