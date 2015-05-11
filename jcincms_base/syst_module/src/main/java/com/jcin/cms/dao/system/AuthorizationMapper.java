package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.AuthorizationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorizationMapper {
    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int insertBatch(List<Authorization> list);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int countByExample(AuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int deleteByExample(AuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int insert(Authorization record);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int insertSelective(Authorization record);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    List<Authorization> selectByExample(AuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    Authorization selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int updateByExampleSelective(@Param("record") Authorization record, @Param("example") AuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int updateByExample(@Param("record") Authorization record, @Param("example") AuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int updateByPrimaryKeySelective(Authorization record);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int updateByPrimaryKey(Authorization record);
}