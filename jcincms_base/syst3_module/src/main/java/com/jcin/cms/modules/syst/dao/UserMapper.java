package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.domain.UserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    int insertBatch(List<User> list);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    int countByExample(UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    int deleteByExample(UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    int insert(User record);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    int insertSelective(User record);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    List<User> selectByExample(UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    User selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年09月27日 15时41分15秒 星期日
     */
    int updateByPrimaryKey(User record);
}