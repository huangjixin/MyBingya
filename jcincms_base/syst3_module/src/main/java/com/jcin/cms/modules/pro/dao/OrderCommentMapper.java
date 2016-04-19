package com.jcin.cms.modules.pro.dao;

import com.jcin.cms.modules.pro.domain.OrderComment;
import com.jcin.cms.modules.pro.domain.OrderCommentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCommentMapper {
    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertBatch(List<OrderComment> list);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int countByExample(OrderCommentCriteria example);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByExample(OrderCommentCriteria example);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insert(OrderComment record);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int insertSelective(OrderComment record);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    List<OrderComment> selectByExample(OrderCommentCriteria example);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    OrderComment selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExampleSelective(@Param("record") OrderComment record, @Param("example") OrderCommentCriteria example);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByExample(@Param("record") OrderComment record, @Param("example") OrderCommentCriteria example);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKeySelective(OrderComment record);

    /**
     * 该方法由系统生成 order_comment
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    int updateByPrimaryKey(OrderComment record);
}