package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.Order;
import com.jcin.cms.modules.pro.domain.OrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    int insertBatch(List<Order> list);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    int countByExample(OrderCriteria example);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    int deleteByExample(OrderCriteria example);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    int insert(Order record);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    int insertSelective(Order record);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    List<Order> selectByExample(OrderCriteria example);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    Order selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderCriteria example);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderCriteria example);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月24日 22时01分11秒 星期日
     */
    int updateByPrimaryKey(Order record);
}