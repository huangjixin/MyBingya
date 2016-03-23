package com.jcin.cms.modules.bet.dao;

import com.jcin.cms.modules.bet.domain.Account;
import com.jcin.cms.modules.bet.domain.AccountCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int insertBatch(List<Account> list);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int countByExample(AccountCriteria example);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int deleteByExample(AccountCriteria example);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int insert(Account record);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int insertSelective(Account record);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    List<Account> selectByExample(AccountCriteria example);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    Account selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountCriteria example);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int updateByExample(@Param("record") Account record, @Param("example") AccountCriteria example);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * 该方法由系统生成 tb_account
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int updateByPrimaryKey(Account record);
}