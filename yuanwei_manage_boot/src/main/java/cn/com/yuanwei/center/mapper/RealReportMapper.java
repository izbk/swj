package cn.com.yuanwei.center.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.RealReport;
import cn.com.yuanwei.center.entity.RealReportExample;
import cn.com.yuanwei.center.entity.RealReportVo;
@Mapper
public interface RealReportMapper {
    int countByExample(RealReportExample example);

    int deleteByExample(RealReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RealReport record);
    
    int batchInsert(List<RealReport> list);

    int insertSelective(RealReport record);

    List<RealReport> selectByExampleWithRowbounds(RealReportExample example, RowBounds rowBounds);

    List<RealReportVo> selectByExampleWithInTypes(@Param("inTypes") List<Integer> inTypes,@Param("record") RealReport record);
    
    List<RealReport> selectByExample(RealReportExample example);

    RealReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RealReport record, @Param("example") RealReportExample example);

    int updateByExample(@Param("record") RealReport record, @Param("example") RealReportExample example);

    int updateByPrimaryKeySelective(RealReport record);

    int updateByPrimaryKey(RealReport record);
    
    List<RealReportVo> selectRetailSalesForSum(Map<String,Object> param);
    List<RealReportVo> selectRetailSalesForReduce(Map<String,Object> param);
    List<Integer> selectDistinctMonths(Map<String,Object> param);
    List<RealReport> selectByMap(Map<String,Object> param);
    RealReport selectSumByMap(Map<String,Object> param);
    List<Integer> selectCheckData(Map<String,Object> param);
    int deleteByMap(Map<String,Object> param);
}