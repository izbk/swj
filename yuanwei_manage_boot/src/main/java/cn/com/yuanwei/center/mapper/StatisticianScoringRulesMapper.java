package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.StatisticianScoringRules;
import cn.com.yuanwei.center.entity.StatisticianScoringRulesExample;
@Mapper
public interface StatisticianScoringRulesMapper {
    int countByExample(StatisticianScoringRulesExample example);

    int deleteByExample(StatisticianScoringRulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatisticianScoringRules record);

    int insertSelective(StatisticianScoringRules record);

    List<StatisticianScoringRules> selectByExampleWithRowbounds(StatisticianScoringRulesExample example, RowBounds rowBounds);

    List<StatisticianScoringRules> selectByExample(StatisticianScoringRulesExample example);

    StatisticianScoringRules selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatisticianScoringRules record, @Param("example") StatisticianScoringRulesExample example);

    int updateByExample(@Param("record") StatisticianScoringRules record, @Param("example") StatisticianScoringRulesExample example);

    int updateByPrimaryKeySelective(StatisticianScoringRules record);

    int updateByPrimaryKey(StatisticianScoringRules record);
}