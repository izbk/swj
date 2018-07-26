package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.WeixinSubscribe;
import cn.com.yuanwei.center.entity.WeixinSubscribeExample;
@Mapper
public interface WeixinSubscribeMapper {
    int countByExample(WeixinSubscribeExample example);

    int deleteByExample(WeixinSubscribeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WeixinSubscribe record);

    int insertSelective(WeixinSubscribe record);

    List<WeixinSubscribe> selectByExampleWithRowbounds(WeixinSubscribeExample example, RowBounds rowBounds);

    List<WeixinSubscribe> selectByExample(WeixinSubscribeExample example);

    WeixinSubscribe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WeixinSubscribe record, @Param("example") WeixinSubscribeExample example);

    int updateByExample(@Param("record") WeixinSubscribe record, @Param("example") WeixinSubscribeExample example);

    int updateByPrimaryKeySelective(WeixinSubscribe record);

    int updateByPrimaryKey(WeixinSubscribe record);
}