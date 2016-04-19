package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.ProPackage;
import com.jcin.cms.modules.pro.domain.ProPackageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProPackageMapper {
    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertBatch(List<ProPackage> list);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int countByExample(ProPackageCriteria example);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByExample(ProPackageCriteria example);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insert(ProPackage record);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertSelective(ProPackage record);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<ProPackage> selectByExample(ProPackageCriteria example);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    ProPackage selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleSelective(@Param("record") ProPackage record, @Param("example") ProPackageCriteria example);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExample(@Param("record") ProPackage record, @Param("example") ProPackageCriteria example);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeySelective(ProPackage record);

    /**
     * 该方法由系统生成 pro_package
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKey(ProPackage record);
}