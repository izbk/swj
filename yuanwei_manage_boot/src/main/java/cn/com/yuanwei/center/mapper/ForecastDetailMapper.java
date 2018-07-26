package cn.com.yuanwei.center.mapper;

import cn.com.yuanwei.center.entity.ForecastDetail;
import cn.com.yuanwei.center.entity.ForecastDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface ForecastDetailMapper {
    int countByExample(ForecastDetailExample example);

    int deleteByExample(ForecastDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ForecastDetail record);

    int insertSelective(ForecastDetail record);
    
    int batchInsert(List<ForecastDetail> list);

    List<ForecastDetail> selectByExampleWithRowbounds(ForecastDetailExample example, RowBounds rowBounds);

    List<ForecastDetail> selectByExample(ForecastDetailExample example);

    ForecastDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ForecastDetail record, @Param("example") ForecastDetailExample example);

    int updateByExample(@Param("record") ForecastDetail record, @Param("example") ForecastDetailExample example);

    int updateByPrimaryKeySelective(ForecastDetail record);

    int updateByPrimaryKey(ForecastDetail record);
}