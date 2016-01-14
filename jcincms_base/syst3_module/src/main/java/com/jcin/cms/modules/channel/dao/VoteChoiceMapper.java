package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.VoteChoice;
import com.jcin.cms.modules.channel.domain.VoteChoiceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteChoiceMapper {
    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int insertBatch(List<VoteChoice> list);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int countByExample(VoteChoiceCriteria example);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int deleteByExample(VoteChoiceCriteria example);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int insert(VoteChoice record);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int insertSelective(VoteChoice record);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    List<VoteChoice> selectByExample(VoteChoiceCriteria example);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    VoteChoice selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int updateByExampleSelective(@Param("record") VoteChoice record, @Param("example") VoteChoiceCriteria example);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int updateByExample(@Param("record") VoteChoice record, @Param("example") VoteChoiceCriteria example);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int updateByPrimaryKeySelective(VoteChoice record);

    /**
     * 该方法由系统生成 tb_vote_choice
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int updateByPrimaryKey(VoteChoice record);
}