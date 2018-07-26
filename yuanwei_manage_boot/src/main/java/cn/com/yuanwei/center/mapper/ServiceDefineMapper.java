package cn.com.yuanwei.center.mapper;

import cn.com.yuanwei.center.entity.ServiceDefine;
import cn.com.yuanwei.center.entity.ServiceDefineExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface ServiceDefineMapper {
    int countByExample(ServiceDefineExample example);

    int deleteByExample(ServiceDefineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceDefine record);

    int insertSelective(ServiceDefine record);

    List<ServiceDefine> selectByExampleWithRowbounds(ServiceDefineExample example, RowBounds rowBounds);

    List<ServiceDefine> selectByExample(ServiceDefineExample example);

    ServiceDefine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceDefine record, @Param("example") ServiceDefineExample example);

    int updateByExample(@Param("record") ServiceDefine record, @Param("example") ServiceDefineExample example);

    int updateByPrimaryKeySelective(ServiceDefine record);

    int updateByPrimaryKey(ServiceDefine record);
}