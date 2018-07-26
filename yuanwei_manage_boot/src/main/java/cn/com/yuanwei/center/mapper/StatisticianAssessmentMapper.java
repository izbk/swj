package cn.com.yuanwei.center.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.CheckMonthVo;
import cn.com.yuanwei.center.entity.StatisticianAssessment;
import cn.com.yuanwei.center.entity.StatisticianAssessmentExample;
@Mapper
public interface StatisticianAssessmentMapper {
    int countByExample(StatisticianAssessmentExample example);

    int deleteByExample(StatisticianAssessmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatisticianAssessment record);

    int insertSelective(StatisticianAssessment record);

    List<StatisticianAssessment> selectByExampleWithRowbounds(StatisticianAssessmentExample example, RowBounds rowBounds);
    
    List<StatisticianAssessment> selectByExample(StatisticianAssessmentExample example);
    
    List<StatisticianAssessment> selectStatisticianDoneList(Map<String,Object> param);
    
    List<StatisticianAssessment> selectReportPointDoneList(Map<String,Object> param);
    
    CheckMonthVo selectCountRealReportByMonth(Map<String,Object> param);
    
    StatisticianAssessment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatisticianAssessment record, @Param("example") StatisticianAssessmentExample example);

    int updateByExample(@Param("record") StatisticianAssessment record, @Param("example") StatisticianAssessmentExample example);

    int updateByPrimaryKeySelective(StatisticianAssessment record);

    int updateByPrimaryKey(StatisticianAssessment record);
}