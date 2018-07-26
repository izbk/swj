package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.TownshipAnnualTask;
import cn.com.yuanwei.center.entity.TownshipAnnualTaskExample;
@Mapper
public interface TownshipAnnualTaskMapper {
    int countByExample(TownshipAnnualTaskExample example);

    int deleteByExample(TownshipAnnualTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TownshipAnnualTask record);

    int insertSelective(TownshipAnnualTask record);

    List<TownshipAnnualTask> selectByExampleWithRowbounds(TownshipAnnualTaskExample example, RowBounds rowBounds);

    List<TownshipAnnualTask> selectByExample(TownshipAnnualTaskExample example);

    TownshipAnnualTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TownshipAnnualTask record, @Param("example") TownshipAnnualTaskExample example);

    int updateByExample(@Param("record") TownshipAnnualTask record, @Param("example") TownshipAnnualTaskExample example);

    int updateByPrimaryKeySelective(TownshipAnnualTask record);

    int updateByPrimaryKey(TownshipAnnualTask record);
}