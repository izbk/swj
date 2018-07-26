package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.FundDetail;
import cn.com.yuanwei.center.entity.FundDetailExample;
@Mapper
public interface FundDetailMapper {
    int countByExample(FundDetailExample example);

    int deleteByExample(FundDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FundDetail record);

    int insertSelective(FundDetail record);

    List<FundDetail> selectByExampleWithRowbounds(FundDetailExample example, RowBounds rowBounds);

    List<FundDetail> selectByExample(FundDetailExample example);

    FundDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FundDetail record, @Param("example") FundDetailExample example);

    int updateByExample(@Param("record") FundDetail record, @Param("example") FundDetailExample example);

    int updateByPrimaryKeySelective(FundDetail record);

    int updateByPrimaryKey(FundDetail record);
}