package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.Exhibition;
import cn.com.yuanwei.center.entity.ExhibitionExample;
@Mapper
public interface ExhibitionMapper {
    int countByExample(ExhibitionExample example);

    int deleteByExample(ExhibitionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Exhibition record);

    int insertSelective(Exhibition record);

    List<Exhibition> selectByExampleWithRowbounds(ExhibitionExample example, RowBounds rowBounds);

    List<Exhibition> selectByExample(ExhibitionExample example);

    Exhibition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Exhibition record, @Param("example") ExhibitionExample example);

    int updateByExample(@Param("record") Exhibition record, @Param("example") ExhibitionExample example);

    int updateByPrimaryKeySelective(Exhibition record);

    int updateByPrimaryKey(Exhibition record);
}