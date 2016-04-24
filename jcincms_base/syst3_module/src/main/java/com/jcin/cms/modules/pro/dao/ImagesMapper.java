package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.Images;
import com.jcin.cms.modules.pro.domain.ImagesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImagesMapper {
    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    int insertBatch(List<Images> list);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    int countByExample(ImagesCriteria example);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    int deleteByExample(ImagesCriteria example);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    int insert(Images record);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    int insertSelective(Images record);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    List<Images> selectByExample(ImagesCriteria example);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    Images selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    int updateByExampleSelective(@Param("record") Images record, @Param("example") ImagesCriteria example);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    int updateByExample(@Param("record") Images record, @Param("example") ImagesCriteria example);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    int updateByPrimaryKeySelective(Images record);

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月24日 21时17分21秒 星期日
     */
    int updateByPrimaryKey(Images record);
}