package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.Product;
import com.jcin.cms.modules.pro.domain.ProductCriteria;
import com.jcin.cms.modules.pro.domain.ProductWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int insertBatch(List<Product> list);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int countByExample(ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int deleteByExample(ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int insert(ProductWithBLOBs record);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int insertSelective(ProductWithBLOBs record);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    List<ProductWithBLOBs> selectByExampleWithBLOBs(ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    List<Product> selectByExample(ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    ProductWithBLOBs selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int updateByExampleSelective(@Param("record") ProductWithBLOBs record, @Param("example") ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int updateByExampleWithBLOBs(@Param("record") ProductWithBLOBs record, @Param("example") ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int updateByExample(@Param("record") Product record, @Param("example") ProductCriteria example);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int updateByPrimaryKeySelective(ProductWithBLOBs record);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int updateByPrimaryKeyWithBLOBs(ProductWithBLOBs record);

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分18秒 星期日
     */
    int updateByPrimaryKey(Product record);
}