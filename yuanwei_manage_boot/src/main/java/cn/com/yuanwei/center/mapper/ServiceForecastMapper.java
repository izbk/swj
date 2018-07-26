package cn.com.yuanwei.center.mapper;

import cn.com.yuanwei.center.entity.ServiceForecast;
import cn.com.yuanwei.center.entity.ServiceForecastExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface ServiceForecastMapper {
    int countByExample(ServiceForecastExample example);

    int deleteByExample(ServiceForecastExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceForecast record);

    int insertSelective(ServiceForecast record);

    List<ServiceForecast> selectByExampleWithRowbounds(ServiceForecastExample example, RowBounds rowBounds);

    List<ServiceForecast> selectByExample(ServiceForecastExample example);

    ServiceForecast selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceForecast record, @Param("example") ServiceForecastExample example);

    int updateByExample(@Param("record") ServiceForecast record, @Param("example") ServiceForecastExample example);

    int updateByPrimaryKeySelective(ServiceForecast record);

    int updateByPrimaryKey(ServiceForecast record);
}