package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.WeixinNewsitem;
import cn.com.yuanwei.center.entity.WeixinNewsitemExample;
@Mapper
public interface WeixinNewsitemMapper {
    int countByExample(WeixinNewsitemExample example);

    int deleteByExample(WeixinNewsitemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WeixinNewsitem record);

    int insertSelective(WeixinNewsitem record);

    List<WeixinNewsitem> selectByExampleWithBLOBsWithRowbounds(WeixinNewsitemExample example, RowBounds rowBounds);

    List<WeixinNewsitem> selectByExampleWithBLOBs(WeixinNewsitemExample example);

    List<WeixinNewsitem> selectByExampleWithRowbounds(WeixinNewsitemExample example, RowBounds rowBounds);

    List<WeixinNewsitem> selectByExample(WeixinNewsitemExample example);

    WeixinNewsitem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WeixinNewsitem record, @Param("example") WeixinNewsitemExample example);

    int updateByExampleWithBLOBs(@Param("record") WeixinNewsitem record, @Param("example") WeixinNewsitemExample example);

    int updateByExample(@Param("record") WeixinNewsitem record, @Param("example") WeixinNewsitemExample example);

    int updateByPrimaryKeySelective(WeixinNewsitem record);

    int updateByPrimaryKeyWithBLOBs(WeixinNewsitem record);

    int updateByPrimaryKey(WeixinNewsitem record);
}