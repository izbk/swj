package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.ServiceMonthlyReport;
import cn.com.yuanwei.center.entity.ServiceMonthlyReportExample;
@Mapper
public interface ServiceMonthlyReportMapper {
    int countByExample(ServiceMonthlyReportExample example);

    int deleteByExample(ServiceMonthlyReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceMonthlyReport record);

    int insertSelective(ServiceMonthlyReport record);

    List<ServiceMonthlyReport> selectByExampleWithRowbounds(ServiceMonthlyReportExample example, RowBounds rowBounds);

    List<ServiceMonthlyReport> selectByExample(ServiceMonthlyReportExample example);
    
    List<ServiceMonthlyReport> selectServiceMonthlyReportByMonth(ServiceMonthlyReportExample example);

    ServiceMonthlyReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceMonthlyReport record, @Param("example") ServiceMonthlyReportExample example);

    int updateByExample(@Param("record") ServiceMonthlyReport record, @Param("example") ServiceMonthlyReportExample example);

    int updateByPrimaryKeySelective(ServiceMonthlyReport record);

    int updateByPrimaryKey(ServiceMonthlyReport record);
}