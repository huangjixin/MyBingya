package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.domain.system.MenuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insertBatch(List<Menu> list);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int countByExample(MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteByExample(MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insert(Menu record);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int insertSelective(Menu record);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    List<Menu> selectByExample(MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    Menu selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年06月03日 12时08分12秒 星期三
     */
    int updateByPrimaryKey(Menu record);
}