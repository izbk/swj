package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.EnterpriseReport;
import cn.com.yuanwei.center.entity.EnterpriseReportExample;
import cn.com.yuanwei.center.entity.EnterpriseReportVo;
@Mapper
public interface EnterpriseReportMapper {
    int countByExample(EnterpriseReportExample example);

    int deleteByExample(EnterpriseReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EnterpriseReport record);

    int insertSelective(EnterpriseReport record);

    List<EnterpriseReport> selectByExampleWithRowbounds(EnterpriseReportExample example, RowBounds rowBounds);

    List<EnterpriseReport> selectByExample(EnterpriseReportExample example);
    
    List<EnterpriseReportVo> selectEnterpriseVoByExample(EnterpriseReportExample example);
    
    List<EnterpriseReportVo> selectSumRetailSales(EnterpriseReport record);

    EnterpriseReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EnterpriseReport record, @Param("example") EnterpriseReportExample example);

    int updateByExample(@Param("record") EnterpriseReport record, @Param("example") EnterpriseReportExample example);

    int updateByPrimaryKeySelective(EnterpriseReport record);

    int updateByPrimaryKey(EnterpriseReport record);
}