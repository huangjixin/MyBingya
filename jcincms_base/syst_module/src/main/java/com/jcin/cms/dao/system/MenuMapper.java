package com.jcin.cms.dao.system;

import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.domain.system.MenuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int insertBatch(List<Menu> list);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int countByExample(MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int deleteByExample(MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int insert(Menu record);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int insertSelective(Menu record);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    List<Menu> selectByExample(MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    Menu selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuCriteria example);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * 该方法由系统生成 tb_menu
     *
     * @mbggenerated 2015年05月22日 18时15分56秒 星期五
     */
    int updateByPrimaryKey(Menu record);
}