package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.DocumentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int insertBatch(List<Document> list);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int countByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int deleteByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int insert(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int insertSelective(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    List<Document> selectByExampleWithBLOBs(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    List<Document> selectByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    Document selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int updateByExampleWithBLOBs(@Param("record") Document record, @Param("example") DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int updateByExample(@Param("record") Document record, @Param("example") DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int updateByPrimaryKeySelective(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int updateByPrimaryKeyWithBLOBs(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int updateByPrimaryKey(Document record);
}