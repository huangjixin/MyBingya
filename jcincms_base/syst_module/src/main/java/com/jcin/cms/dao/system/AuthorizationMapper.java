package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.AuthorizationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorizationMapper {
    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insertBatch(List<Authorization> list);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int countByExample(AuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteByExample(AuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insert(Authorization record);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insertSelective(Authorization record);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    List<Authorization> selectByExample(AuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    Authorization selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByExampleSelective(@Param("record") Authorization record, @Param("example") AuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByExample(@Param("record") Authorization record, @Param("example") AuthorizationCriteria example);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByPrimaryKeySelective(Authorization record);

    /**
     * 该方法由系统生成 tb_authorization
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByPrimaryKey(Authorization record);
}