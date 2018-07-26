package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.Enterprise;
import cn.com.yuanwei.center.entity.EnterpriseExample;
@Mapper
public interface EnterpriseMapper {
    int countByExample(EnterpriseExample example);

    int deleteByExample(EnterpriseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    List<Enterprise> selectByExampleWithRowbounds(EnterpriseExample example, RowBounds rowBounds);

    List<Enterprise> selectByExample(EnterpriseExample example);

    Enterprise selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Enterprise record, @Param("example") EnterpriseExample example);

    int updateByExample(@Param("record") Enterprise record, @Param("example") EnterpriseExample example);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);
}