package com.jcin.cms.dao;

import com.jcin.cms.domain.Asset;
import com.jcin.cms.domain.AssetCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetMapper {
    int deleteBatch(List list);

    int insertBatch(List<Asset> list);

    int countByExample(AssetCriteria example);

    int deleteByExample(AssetCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Asset record);

    int insertSelective(Asset record);

    List<Asset> selectByExample(AssetCriteria example);

    Asset selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Asset record, @Param("example") AssetCriteria example);

    int updateByExample(@Param("record") Asset record, @Param("example") AssetCriteria example);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);
}