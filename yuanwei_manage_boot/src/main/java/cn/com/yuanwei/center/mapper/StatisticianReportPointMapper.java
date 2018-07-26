package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.StatisticianReportPoint;
import cn.com.yuanwei.center.entity.StatisticianReportPointExample;
import cn.com.yuanwei.center.entity.StatisticianReportPointVo;
@Mapper
public interface StatisticianReportPointMapper {
    int countByExample(StatisticianReportPointExample example);

    int deleteByExample(StatisticianReportPointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatisticianReportPoint record);

    int insertSelective(StatisticianReportPoint record);

    List<StatisticianReportPoint> selectByExampleWithRowbounds(StatisticianReportPointExample example, RowBounds rowBounds);

    List<StatisticianReportPoint> selectByExample(StatisticianReportPointExample example);
    
    List<StatisticianReportPointVo> selectEnterprisesForPoint(StatisticianReportPoint record);
    
    List<StatisticianReportPoint> selectScoringRecordForPoint(StatisticianReportPoint record);

    StatisticianReportPoint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatisticianReportPoint record, @Param("example") StatisticianReportPointExample example);

    int updateByExample(@Param("record") StatisticianReportPoint record, @Param("example") StatisticianReportPointExample example);

    int updateByPrimaryKeySelective(StatisticianReportPoint record);

    int updateByPrimaryKey(StatisticianReportPoint record);
}