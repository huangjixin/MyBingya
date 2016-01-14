package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.VoteTopic;
import com.jcin.cms.modules.channel.domain.VoteTopicCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteTopicMapper {
    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int insertBatch(List<VoteTopic> list);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int countByExample(VoteTopicCriteria example);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int deleteByExample(VoteTopicCriteria example);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int insert(VoteTopic record);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int insertSelective(VoteTopic record);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    List<VoteTopic> selectByExample(VoteTopicCriteria example);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    VoteTopic selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int updateByExampleSelective(@Param("record") VoteTopic record, @Param("example") VoteTopicCriteria example);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int updateByExample(@Param("record") VoteTopic record, @Param("example") VoteTopicCriteria example);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int updateByPrimaryKeySelective(VoteTopic record);

    /**
     * 该方法由系统生成 tb_vote_topic
     *
     * @mbggenerated 2016年01月13日 22时19分42秒 星期三
     */
    int updateByPrimaryKey(VoteTopic record);
}