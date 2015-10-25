package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.DocumentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int insertBatch(List<Document> list);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int countByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int deleteByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int insert(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int insertSelective(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    List<Document> selectByExampleWithBLOBs(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    List<Document> selectByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    Document selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByExampleWithBLOBs(@Param("record") Document record, @Param("example") DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByExample(@Param("record") Document record, @Param("example") DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByPrimaryKeySelective(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByPrimaryKeyWithBLOBs(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByPrimaryKey(Document record);
}