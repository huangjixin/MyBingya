package com.jcin.cms.modules.channel.dao;

import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.ChannelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelMapper {
    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int insertBatch(List<Channel> list);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int countByExample(ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int deleteByExample(ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int insert(Channel record);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int insertSelective(Channel record);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    List<Channel> selectByExample(ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    Channel selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int updateByExampleSelective(@Param("record") Channel record, @Param("example") ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int updateByExample(@Param("record") Channel record, @Param("example") ChannelCriteria example);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int updateByPrimaryKeySelective(Channel record);

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    int updateByPrimaryKey(Channel record);
}