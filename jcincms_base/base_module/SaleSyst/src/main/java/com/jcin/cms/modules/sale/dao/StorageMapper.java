package com.jcin.cms.modules.sale.dao;

import com.jcin.cms.modules.sale.domain.Storage;
import com.jcin.cms.modules.sale.domain.StorageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper {
    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    int insertBatch(List<Storage> list);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    int countByExample(StorageCriteria example);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    int deleteByExample(StorageCriteria example);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    int insert(Storage record);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    int insertSelective(Storage record);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    List<Storage> selectByExample(StorageCriteria example);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    Storage selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageCriteria example);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    int updateByExample(@Param("record") Storage record, @Param("example") StorageCriteria example);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    int updateByPrimaryKeySelective(Storage record);

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分56秒 星期二
     */
    int updateByPrimaryKey(Storage record);
}