package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.User;
import com.jcin.cms.domain.system.UserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int insertBatch(List<User> list);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int countByExample(UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int deleteByExample(UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int insert(User record);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int insertSelective(User record);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    List<User> selectByExample(UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    User selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年06月21日 12时42分58秒 星期日
     */
    int updateByPrimaryKey(User record);
}