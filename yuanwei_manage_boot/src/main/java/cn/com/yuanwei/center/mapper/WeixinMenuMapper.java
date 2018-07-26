package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.WeixinMenu;
import cn.com.yuanwei.center.entity.WeixinMenuExample;
@Mapper
public interface WeixinMenuMapper {
    int countByExample(WeixinMenuExample example);

    int deleteByExample(WeixinMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WeixinMenu record);

    int insertSelective(WeixinMenu record);

    List<WeixinMenu> selectByExampleWithRowbounds(WeixinMenuExample example, RowBounds rowBounds);

    List<WeixinMenu> selectByExample(WeixinMenuExample example);

    WeixinMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WeixinMenu record, @Param("example") WeixinMenuExample example);

    int updateByExample(@Param("record") WeixinMenu record, @Param("example") WeixinMenuExample example);

    int updateByPrimaryKeySelective(WeixinMenu record);

    int updateByPrimaryKey(WeixinMenu record);
}