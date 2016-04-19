package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.Brand;
import com.jcin.cms.modules.pro.domain.BrandCriteria;
import com.jcin.cms.modules.pro.domain.BrandWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertBatch(List<Brand> list);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int countByExample(BrandCriteria example);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByExample(BrandCriteria example);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insert(BrandWithBLOBs record);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertSelective(BrandWithBLOBs record);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<BrandWithBLOBs> selectByExampleWithBLOBs(BrandCriteria example);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<Brand> selectByExample(BrandCriteria example);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    BrandWithBLOBs selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleSelective(@Param("record") BrandWithBLOBs record, @Param("example") BrandCriteria example);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleWithBLOBs(@Param("record") BrandWithBLOBs record, @Param("example") BrandCriteria example);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExample(@Param("record") Brand record, @Param("example") BrandCriteria example);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeySelective(BrandWithBLOBs record);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeyWithBLOBs(BrandWithBLOBs record);

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKey(Brand record);
}