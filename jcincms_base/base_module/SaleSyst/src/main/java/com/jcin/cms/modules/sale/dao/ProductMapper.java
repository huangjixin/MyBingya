package com.jcin.cms.modules.sale.dao;

import com.jcin.cms.modules.sale.domain.Product;
import com.jcin.cms.modules.sale.domain.ProductCriteria;
import com.jcin.cms.modules.sale.domain.ProductSaleTj;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int insertBatch(List<Product> list);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int countByExample(ProductCriteria example);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int deleteByExample(ProductCriteria example);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int insert(Product record);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int insertSelective(Product record);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    List<Product> selectByExample(ProductCriteria example);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    Product selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductCriteria example);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int updateByExample(@Param("record") Product record, @Param("example") ProductCriteria example);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * 该方法由系统生成 tb_product
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    int updateByPrimaryKey(Product record);
    
    List<ProductSaleTj> selectTongjiByExample(@Param("record") Product record, @Param("example") ProductCriteria example);

	int countTongjiByExample(@Param("record") Product record, @Param("example") ProductCriteria example);
	
	List<ProductSaleTj> selectProByExample(@Param("record") Product record, @Param("example") ProductCriteria example);
	
	int countProByExample(@Param("record") Product record, @Param("example") ProductCriteria example);
}