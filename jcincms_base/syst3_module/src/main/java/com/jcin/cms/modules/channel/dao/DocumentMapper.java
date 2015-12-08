package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.DocumentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    int insertBatch(List<Document> list);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    int countByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    int deleteByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    int insert(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    int insertSelective(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    List<Document> selectByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    Document selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    int updateByExample(@Param("record") Document record, @Param("example") DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    int updateByPrimaryKeySelective(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月30日 12时12分10秒 星期一
     */
    int updateByPrimaryKey(Document record);
    
    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    List<Document> selectByChannelCodeExample(DocumentCriteria example);
    
    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    int selectCountByChannelCodeExample(DocumentCriteria example);
    
    /**
     * 查询上一条记录
     * @param id
     * @return
     */
    Document selectLastRecord(Document document);
    /**
     * 查询下一条记录
     * @param id
     * @return
     */
    Document selectNextRecord(Document document);
}