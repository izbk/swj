package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.EnterpriseRise;
import cn.com.yuanwei.center.entity.EnterpriseRiseExample;
@Mapper
public interface EnterpriseRiseMapper {
    int countByExample(EnterpriseRiseExample example);

    int deleteByExample(EnterpriseRiseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EnterpriseRise record);

    int insertSelective(EnterpriseRise record);

    List<EnterpriseRise> selectByExampleWithRowbounds(EnterpriseRiseExample example, RowBounds rowBounds);

    List<EnterpriseRise> selectByExample(EnterpriseRiseExample example);

    EnterpriseRise selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EnterpriseRise record, @Param("example") EnterpriseRiseExample example);

    int updateByExample(@Param("record") EnterpriseRise record, @Param("example") EnterpriseRiseExample example);

    int updateByPrimaryKeySelective(EnterpriseRise record);

    int updateByPrimaryKey(EnterpriseRise record);
}