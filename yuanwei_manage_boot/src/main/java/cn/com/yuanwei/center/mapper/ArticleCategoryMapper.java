package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.ArticleCategory;
import cn.com.yuanwei.center.entity.ArticleCategoryExample;
@Mapper
public interface ArticleCategoryMapper {
    int countByExample(ArticleCategoryExample example);

    int deleteByExample(ArticleCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleCategory record);

    int insertSelective(ArticleCategory record);

    List<ArticleCategory> selectByExampleWithRowbounds(ArticleCategoryExample example, RowBounds rowBounds);

    List<ArticleCategory> selectByExample(ArticleCategoryExample example);

    ArticleCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleCategory record, @Param("example") ArticleCategoryExample example);

    int updateByExample(@Param("record") ArticleCategory record, @Param("example") ArticleCategoryExample example);

    int updateByPrimaryKeySelective(ArticleCategory record);

    int updateByPrimaryKey(ArticleCategory record);
}