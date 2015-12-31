package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.DocumentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int insertBatch(List<Document> list);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int countByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int deleteByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int insert(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int insertSelective(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    List<Document> selectByExampleWithBLOBs(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    List<Document> selectByExample(DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    Document selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int updateByExampleWithBLOBs(@Param("record") Document record, @Param("example") DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int updateByExample(@Param("record") Document record, @Param("example") DocumentCriteria example);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int updateByPrimaryKeySelective(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
     */
    int updateByPrimaryKeyWithBLOBs(Document record);

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年12月31日 16时24分26秒 星期四
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
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    List<Document> selectTopClickCount(DocumentCriteria example);
    
    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年11月14日 11时16分29秒 星期六
     */
    int selectCountTopClickCount(DocumentCriteria example);
    
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