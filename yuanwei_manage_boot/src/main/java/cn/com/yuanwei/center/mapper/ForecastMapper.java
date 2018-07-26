package cn.com.yuanwei.center.mapper;

import cn.com.yuanwei.center.entity.Forecast;
import cn.com.yuanwei.center.entity.ForecastExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface ForecastMapper {
    int countByExample(ForecastExample example);

    int deleteByExample(ForecastExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Forecast record);

    int insertSelective(Forecast record);

    List<Forecast> selectByExampleWithRowbounds(ForecastExample example, RowBounds rowBounds);

    List<Forecast> selectByExample(ForecastExample example);

    Forecast selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Forecast record, @Param("example") ForecastExample example);

    int updateByExample(@Param("record") Forecast record, @Param("example") ForecastExample example);

    int updateByPrimaryKeySelective(Forecast record);

    int updateByPrimaryKey(Forecast record);
}