package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.Images;
import com.jcin.cms.modules.pro.domain.ImagesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImagesMapper {
    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertBatch(List<Images> list);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int countByExample(ImagesCriteria example);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByExample(ImagesCriteria example);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insert(Images record);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertSelective(Images record);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<Images> selectByExample(ImagesCriteria example);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    Images selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleSelective(@Param("record") Images record, @Param("example") ImagesCriteria example);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExample(@Param("record") Images record, @Param("example") ImagesCriteria example);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeySelective(Images record);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKey(Images record);
}