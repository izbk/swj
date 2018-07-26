package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.ServiceLogsExample;
@Mapper
public interface ServiceLogsMapper {
    int countByExample(ServiceLogsExample example);

    int deleteByExample(ServiceLogsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceLogs record);

    int insertSelective(ServiceLogs record);
    
    int batchInsert(List<ServiceLogs> list);

    List<ServiceLogs> selectByExampleWithRowbounds(ServiceLogsExample example, RowBounds rowBounds);

    List<ServiceLogs> selectByExample(ServiceLogsExample example);

    ServiceLogs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceLogs record, @Param("example") ServiceLogsExample example);

    int updateByExample(@Param("record") ServiceLogs record, @Param("example") ServiceLogsExample example);

    int updateByPrimaryKeySelective(ServiceLogs record);

    int updateByPrimaryKey(ServiceLogs record);
}