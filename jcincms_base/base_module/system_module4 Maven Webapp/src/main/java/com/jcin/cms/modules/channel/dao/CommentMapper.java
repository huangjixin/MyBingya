package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.Comment;
import com.jcin.cms.modules.channel.domain.CommentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    int insertBatch(List<Comment> list);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    int countByExample(CommentCriteria example);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    int deleteByExample(CommentCriteria example);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    int insert(Comment record);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    int insertSelective(Comment record);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    List<Comment> selectByExample(CommentCriteria example);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    Comment selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentCriteria example);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    int updateByExample(@Param("record") Comment record, @Param("example") CommentCriteria example);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    int updateByPrimaryKeySelective(Comment record);

    /**
     * 该方法由系统生成 busi_comment
     *
     * @mbggenerated 2015年10月30日 17时21分59秒 星期五
     */
    int updateByPrimaryKey(Comment record);
}