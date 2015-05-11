package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.domain.system.MenuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int insertBatch(List<Menu> list);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int countByExample(MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int deleteByExample(MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int insert(Menu record);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int insertSelective(Menu record);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    List<Menu> selectByExample(MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    Menu selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月11日 11时56分31秒 星期一
     */
    int updateByPrimaryKey(Menu record);
}