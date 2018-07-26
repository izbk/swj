package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.AuditConfig;
import cn.com.yuanwei.center.entity.AuditConfigExample;
@Mapper
public interface AuditConfigMapper {
    int countByExample(AuditConfigExample example);

    int deleteByExample(AuditConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuditConfig record);

    int insertSelective(AuditConfig record);

    List<AuditConfig> selectByExampleWithRowbounds(AuditConfigExample example, RowBounds rowBounds);

    List<AuditConfig> selectByExample(AuditConfigExample example);
    
    List<AuditConfig> selectByAuditConfig(AuditConfig record);

    AuditConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuditConfig record, @Param("example") AuditConfigExample example);

    int updateByExample(@Param("record") AuditConfig record, @Param("example") AuditConfigExample example);

    int updateByPrimaryKeySelective(AuditConfig record);

    int updateByPrimaryKey(AuditConfig record);
}