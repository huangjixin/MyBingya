package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.ChannelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelMapper {
    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int insertBatch(List<Channel> list);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int countByExample(ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int deleteByExample(ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int insert(Channel record);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int insertSelective(Channel record);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    List<Channel> selectByExample(ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    Channel selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByExampleSelective(@Param("record") Channel record, @Param("example") ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByExample(@Param("record") Channel record, @Param("example") ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByPrimaryKeySelective(Channel record);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    int updateByPrimaryKey(Channel record);
}