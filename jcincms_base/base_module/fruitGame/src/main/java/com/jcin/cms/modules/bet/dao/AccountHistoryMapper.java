package com.jcin.cms.modules.bet.dao;

import com.jcin.cms.modules.bet.domain.AccountHistory;
import com.jcin.cms.modules.bet.domain.AccountHistoryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountHistoryMapper {
    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int insertBatch(List<AccountHistory> list);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int countByExample(AccountHistoryCriteria example);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int deleteByExample(AccountHistoryCriteria example);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int insert(AccountHistory record);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int insertSelective(AccountHistory record);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    List<AccountHistory> selectByExample(AccountHistoryCriteria example);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    AccountHistory selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int updateByExampleSelective(@Param("record") AccountHistory record, @Param("example") AccountHistoryCriteria example);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int updateByExample(@Param("record") AccountHistory record, @Param("example") AccountHistoryCriteria example);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int updateByPrimaryKeySelective(AccountHistory record);

    /**
     * 该方法由系统生成 tb_account_history
     *
     * @mbggenerated 2016年03月20日 11时44分58秒 星期日
     */
    int updateByPrimaryKey(AccountHistory record);
}