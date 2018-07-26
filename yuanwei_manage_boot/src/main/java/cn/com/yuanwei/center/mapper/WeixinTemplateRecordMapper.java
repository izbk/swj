package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.WeixinTemplateRecord;
import cn.com.yuanwei.center.entity.WeixinTemplateRecordExample;
@Mapper
public interface WeixinTemplateRecordMapper {
    int countByExample(WeixinTemplateRecordExample example);

    int deleteByExample(WeixinTemplateRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WeixinTemplateRecord record);

    int insertSelective(WeixinTemplateRecord record);

    List<WeixinTemplateRecord> selectByExampleWithRowbounds(WeixinTemplateRecordExample example, RowBounds rowBounds);

    List<WeixinTemplateRecord> selectByExample(WeixinTemplateRecordExample example);

    WeixinTemplateRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WeixinTemplateRecord record, @Param("example") WeixinTemplateRecordExample example);

    int updateByExample(@Param("record") WeixinTemplateRecord record, @Param("example") WeixinTemplateRecordExample example);

    int updateByPrimaryKeySelective(WeixinTemplateRecord record);

    int updateByPrimaryKey(WeixinTemplateRecord record);
}