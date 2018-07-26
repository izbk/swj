package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.ArticleType;
import cn.com.yuanwei.center.entity.ArticleTypeExample;
@Mapper
public interface ArticleTypeMapper {
    int countByExample(ArticleTypeExample example);

    int deleteByExample(ArticleTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    List<ArticleType> selectByExampleWithRowbounds(ArticleTypeExample example, RowBounds rowBounds);

    List<ArticleType> selectByExample(ArticleTypeExample example);

    ArticleType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByExample(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);
}