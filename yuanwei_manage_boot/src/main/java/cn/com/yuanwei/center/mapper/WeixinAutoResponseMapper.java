package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.WeixinAutoResponse;
import cn.com.yuanwei.center.entity.WeixinAutoResponseExample;
@Mapper
public interface WeixinAutoResponseMapper {
    int countByExample(WeixinAutoResponseExample example);

    int deleteByExample(WeixinAutoResponseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WeixinAutoResponse record);

    int insertSelective(WeixinAutoResponse record);

    List<WeixinAutoResponse> selectByExampleWithRowbounds(WeixinAutoResponseExample example, RowBounds rowBounds);

    List<WeixinAutoResponse> selectByExample(WeixinAutoResponseExample example);

    WeixinAutoResponse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WeixinAutoResponse record, @Param("example") WeixinAutoResponseExample example);

    int updateByExample(@Param("record") WeixinAutoResponse record, @Param("example") WeixinAutoResponseExample example);

    int updateByPrimaryKeySelective(WeixinAutoResponse record);

    int updateByPrimaryKey(WeixinAutoResponse record);
}