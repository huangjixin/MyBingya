package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.Guestbook;
import com.jcin.cms.modules.syst.domain.GuestbookCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuestbookMapper {
    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    int insertBatch(List<Guestbook> list);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    int countByExample(GuestbookCriteria example);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    int deleteByExample(GuestbookCriteria example);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    int insert(Guestbook record);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    int insertSelective(Guestbook record);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    List<Guestbook> selectByExample(GuestbookCriteria example);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    Guestbook selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    int updateByExampleSelective(@Param("record") Guestbook record, @Param("example") GuestbookCriteria example);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    int updateByExample(@Param("record") Guestbook record, @Param("example") GuestbookCriteria example);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    int updateByPrimaryKeySelective(Guestbook record);

    /**
     * 该方法由系统生成 tb_guestbook
     *
     * @mbggenerated 2016年04月04日 07时26分00秒 星期一
     */
    int updateByPrimaryKey(Guestbook record);
}