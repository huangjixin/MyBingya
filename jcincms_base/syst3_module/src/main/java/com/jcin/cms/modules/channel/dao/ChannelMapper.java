package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.ChannelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelMapper {
    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    int insertBatch(List<Channel> list);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    int countByExample(ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    int deleteByExample(ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    int insert(Channel record);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    int insertSelective(Channel record);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    List<Channel> selectByExample(ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    Channel selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    int updateByExampleSelective(@Param("record") Channel record, @Param("example") ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    int updateByExample(@Param("record") Channel record, @Param("example") ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    int updateByPrimaryKeySelective(Channel record);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    int updateByPrimaryKey(Channel record);
}