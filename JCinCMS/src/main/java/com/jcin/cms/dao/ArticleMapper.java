package com.jcin.cms.dao;

import com.jcin.cms.domain.Article;
import com.jcin.cms.domain.ArticleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    int countByExample(ArticleCriteria example);

    int deleteByExample(ArticleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleCriteria example);

    Article selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}