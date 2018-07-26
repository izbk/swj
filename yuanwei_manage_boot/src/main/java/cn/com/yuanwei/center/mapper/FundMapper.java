package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.Fund;
import cn.com.yuanwei.center.entity.FundExample;
@Mapper
public interface FundMapper {
    int countByExample(FundExample example);

    int deleteByExample(FundExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Fund record);

    int insertSelective(Fund record);

    List<Fund> selectByExampleWithRowbounds(FundExample example, RowBounds rowBounds);

    List<Fund> selectByExample(FundExample example);

    Fund selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Fund record, @Param("example") FundExample example);

    int updateByExample(@Param("record") Fund record, @Param("example") FundExample example);

    int updateByPrimaryKeySelective(Fund record);

    int updateByPrimaryKey(Fund record);
}