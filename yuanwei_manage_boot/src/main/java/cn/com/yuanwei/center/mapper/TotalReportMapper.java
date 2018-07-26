package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.TotalReport;
import cn.com.yuanwei.center.entity.TotalReportExample;
@Mapper
public interface TotalReportMapper {
    int countByExample(TotalReportExample example);

    int deleteByExample(TotalReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TotalReport record);

    int insertSelective(TotalReport record);

    List<TotalReport> selectByExampleWithRowbounds(TotalReportExample example, RowBounds rowBounds);

    List<TotalReport> selectByExample(TotalReportExample example);

    TotalReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TotalReport record, @Param("example") TotalReportExample example);

    int updateByExample(@Param("record") TotalReport record, @Param("example") TotalReportExample example);

    int updateByPrimaryKeySelective(TotalReport record);

    int updateByPrimaryKey(TotalReport record);
}