package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.Category;
import com.jcin.cms.modules.pro.domain.CategoryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertBatch(List<Category> list);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int countByExample(CategoryCriteria example);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByExample(CategoryCriteria example);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insert(Category record);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertSelective(Category record);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<Category> selectByExample(CategoryCriteria example);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    Category selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryCriteria example);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExample(@Param("record") Category record, @Param("example") CategoryCriteria example);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * 该方法由系统生成 pro_category
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKey(Category record);
}