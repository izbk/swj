package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.IncubationParkAssessment;
import cn.com.yuanwei.center.entity.IncubationParkAssessmentExample;
@Mapper
public interface IncubationParkAssessmentMapper {
    int countByExample(IncubationParkAssessmentExample example);

    int deleteByExample(IncubationParkAssessmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IncubationParkAssessment record);

    int insertSelective(IncubationParkAssessment record);

    List<IncubationParkAssessment> selectByExampleWithRowbounds(IncubationParkAssessmentExample example, RowBounds rowBounds);

    List<IncubationParkAssessment> selectByExample(IncubationParkAssessmentExample example);

    IncubationParkAssessment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IncubationParkAssessment record, @Param("example") IncubationParkAssessmentExample example);

    int updateByExample(@Param("record") IncubationParkAssessment record, @Param("example") IncubationParkAssessmentExample example);

    int updateByPrimaryKeySelective(IncubationParkAssessment record);

    int updateByPrimaryKey(IncubationParkAssessment record);
}