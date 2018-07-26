package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.WeixinTemplate;
import cn.com.yuanwei.center.entity.WeixinTemplateExample;
@Mapper
public interface WeixinTemplateMapper {
    int countByExample(WeixinTemplateExample example);

    int deleteByExample(WeixinTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WeixinTemplate record);

    int insertSelective(WeixinTemplate record);

    List<WeixinTemplate> selectByExampleWithRowbounds(WeixinTemplateExample example, RowBounds rowBounds);

    List<WeixinTemplate> selectByExample(WeixinTemplateExample example);

    WeixinTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WeixinTemplate record, @Param("example") WeixinTemplateExample example);

    int updateByExample(@Param("record") WeixinTemplate record, @Param("example") WeixinTemplateExample example);

    int updateByPrimaryKeySelective(WeixinTemplate record);

    int updateByPrimaryKey(WeixinTemplate record);
}