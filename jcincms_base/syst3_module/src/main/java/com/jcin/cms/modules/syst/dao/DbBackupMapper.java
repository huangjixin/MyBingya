package com.jcin.cms.modules.syst.dao;

import com.jcin.cms.modules.syst.domain.DbBackup;
import com.jcin.cms.modules.syst.domain.DbBackupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbBackupMapper {
    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    int deleteBatch(List list);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    int insertBatch(List<DbBackup> list);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    int countByExample(DbBackupCriteria example);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    int deleteByExample(DbBackupCriteria example);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    int deleteByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    int insert(DbBackup record);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    int insertSelective(DbBackup record);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    List<DbBackup> selectByExample(DbBackupCriteria example);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    DbBackup selectByPrimaryKey(String id);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    int updateByExampleSelective(@Param("record") DbBackup record, @Param("example") DbBackupCriteria example);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    int updateByExample(@Param("record") DbBackup record, @Param("example") DbBackupCriteria example);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    int updateByPrimaryKeySelective(DbBackup record);

    /**
     * 该方法由系统生成 tb_db_backup
     *
     * @mbggenerated 2015年10月16日 17时01分04秒 星期五
     */
    int updateByPrimaryKey(DbBackup record);
}