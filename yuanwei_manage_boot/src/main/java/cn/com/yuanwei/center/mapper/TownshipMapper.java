package cn.com.yuanwei.center.mapper;

import cn.com.yuanwei.center.entity.Township;
import cn.com.yuanwei.center.entity.TownshipExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface TownshipMapper {
    int countByExample(TownshipExample example);

    int deleteByExample(TownshipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Township record);

    int insertSelective(Township record);

    List<Township> selectByExampleWithRowbounds(TownshipExample example, RowBounds rowBounds);

    List<Township> selectByExample(TownshipExample example);

    Township selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Township record, @Param("example") TownshipExample example);

    int updateByExample(@Param("record") Township record, @Param("example") TownshipExample example);

    int updateByPrimaryKeySelective(Township record);

    int updateByPrimaryKey(Township record);
}