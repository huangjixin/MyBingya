package com.jcin.cms.modules.sale.dao;

import com.jcin.cms.modules.sale.domain.Sale;
import com.jcin.cms.modules.sale.domain.SaleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleMapper {
    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    int insertBatch(List<Sale> list);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    int countByExample(SaleCriteria example);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    int deleteByExample(SaleCriteria example);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    int insert(Sale record);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    int insertSelective(Sale record);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    List<Sale> selectByExample(SaleCriteria example);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    Sale selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    int updateByExampleSelective(@Param("record") Sale record, @Param("example") SaleCriteria example);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    int updateByExample(@Param("record") Sale record, @Param("example") SaleCriteria example);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    int updateByPrimaryKeySelective(Sale record);

    /**
     * 该方法由系统生成 tb_sale
     *
     * @mbggenerated 2016年03月21日 13时48分43秒 星期一
     */
    int updateByPrimaryKey(Sale record);
}