package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.StatisticianRangeRules;
import cn.com.yuanwei.center.entity.StatisticianRangeRulesExample;
@Mapper
public interface StatisticianRangeRulesMapper {
    int countByExample(StatisticianRangeRulesExample example);

    int deleteByExample(StatisticianRangeRulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatisticianRangeRules record);

    int insertSelective(StatisticianRangeRules record);

    List<StatisticianRangeRules> selectByExampleWithRowbounds(StatisticianRangeRulesExample example, RowBounds rowBounds);

    List<StatisticianRangeRules> selectByExample(StatisticianRangeRulesExample example);

    StatisticianRangeRules selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatisticianRangeRules record, @Param("example") StatisticianRangeRulesExample example);

    int updateByExample(@Param("record") StatisticianRangeRules record, @Param("example") StatisticianRangeRulesExample example);

    int updateByPrimaryKeySelective(StatisticianRangeRules record);

    int updateByPrimaryKey(StatisticianRangeRules record);
}