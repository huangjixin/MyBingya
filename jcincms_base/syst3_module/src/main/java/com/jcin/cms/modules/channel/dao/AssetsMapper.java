package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.Assets;
import com.jcin.cms.modules.channel.domain.AssetsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetsMapper {
    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    int insertBatch(List<Assets> list);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    int countByExample(AssetsCriteria example);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    int deleteByExample(AssetsCriteria example);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    int insert(Assets record);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    int insertSelective(Assets record);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    List<Assets> selectByExample(AssetsCriteria example);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    Assets selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    int updateByExampleSelective(@Param("record") Assets record, @Param("example") AssetsCriteria example);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    int updateByExample(@Param("record") Assets record, @Param("example") AssetsCriteria example);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    int updateByPrimaryKeySelective(Assets record);

    /**
     * 该方法由系统生成 tb_assets
     *
     * @mbggenerated 2015年11月09日 17时57分36秒 星期一
     */
    int updateByPrimaryKey(Assets record);
}