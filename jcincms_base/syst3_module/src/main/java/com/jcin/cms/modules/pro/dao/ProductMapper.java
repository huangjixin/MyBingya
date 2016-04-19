package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.Product;
import com.jcin.cms.modules.pro.domain.ProductCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertBatch(List<Product> list);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int countByExample(ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByExample(ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insert(Product record);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertSelective(Product record);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<Product> selectByExampleWithBLOBs(ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<Product> selectByExample(ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    Product selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleWithBLOBs(@Param("record") Product record, @Param("example") ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExample(@Param("record") Product record, @Param("example") ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeyWithBLOBs(Product record);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKey(Product record);
}