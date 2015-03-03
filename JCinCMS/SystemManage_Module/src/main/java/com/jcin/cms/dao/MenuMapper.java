package com.jcin.cms.dao;

import com.jcin.cms.domain.Menu;
import com.jcin.cms.domain.MenuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    int deleteBatch(List list);

    int insertBatch(List<Menu> list);

    int countByExample(MenuCriteria example);

    int deleteByExample(MenuCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuCriteria example);

    Menu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuCriteria example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuCriteria example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}