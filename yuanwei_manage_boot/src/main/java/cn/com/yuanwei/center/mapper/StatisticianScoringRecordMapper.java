package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.StatisticianScoringRecord;
import cn.com.yuanwei.center.entity.StatisticianScoringRecordExample;
@Mapper
public interface StatisticianScoringRecordMapper {
    int countByExample(StatisticianScoringRecordExample example);

    int deleteByExample(StatisticianScoringRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatisticianScoringRecord record);

    int insertSelective(StatisticianScoringRecord record);

    List<StatisticianScoringRecord> selectByExampleWithRowbounds(StatisticianScoringRecordExample example, RowBounds rowBounds);

    List<StatisticianScoringRecord> selectByExample(StatisticianScoringRecordExample example);

    StatisticianScoringRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatisticianScoringRecord record, @Param("example") StatisticianScoringRecordExample example);

    int updateByExample(@Param("record") StatisticianScoringRecord record, @Param("example") StatisticianScoringRecordExample example);

    int updateByPrimaryKeySelective(StatisticianScoringRecord record);

    int updateByPrimaryKey(StatisticianScoringRecord record);
}