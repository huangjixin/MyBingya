package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.domain.UserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    int insertBatch(List<User> list);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    int countByExample(UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    int deleteByExample(UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    int insert(User record);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    int insertSelective(User record);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    List<User> selectByExample(UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    User selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 该方法由系统生成 tb_user
     *
     * @mbggenerated 2015年12月11日 11时12分30秒 星期五
     */
    int updateByPrimaryKey(User record);
    
    /**
     * @param userCriteria
     * @return
     */
    List<User> selectByOrgId(UserCriteria userCriteria);
    
    /**
     * @param userCriteria
     * @return
     */
    int countByOrgId(UserCriteria userCriteria);

	List<User> selectByRoleId(UserCriteria userCriteria);

	int countByRoleId(UserCriteria userCriteria);
}