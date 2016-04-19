package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.Order;
import com.jcin.cms.modules.pro.domain.OrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertBatch(List<Order> list);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int countByExample(OrderCriteria example);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByExample(OrderCriteria example);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insert(Order record);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertSelective(Order record);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<Order> selectByExample(OrderCriteria example);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    Order selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderCriteria example);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderCriteria example);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * 该方法由系统生成 order
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKey(Order record);
}