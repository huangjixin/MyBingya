package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.Log;
import com.jcin.cms.modules.syst.domain.LogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogMapper {
    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    int insertBatch(List<Log> list);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    int countByExample(LogCriteria example);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    int deleteByExample(LogCriteria example);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    int insert(Log record);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    int insertSelective(Log record);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    List<Log> selectByExample(LogCriteria example);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    Log selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogCriteria example);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    int updateByExample(@Param("record") Log record, @Param("example") LogCriteria example);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    int updateByPrimaryKeySelective(Log record);

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    int updateByPrimaryKey(Log record);
}