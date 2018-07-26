package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.WeixinText;
import cn.com.yuanwei.center.entity.WeixinTextExample;
@Mapper
public interface WeixinTextMapper {
    int countByExample(WeixinTextExample example);

    int deleteByExample(WeixinTextExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WeixinText record);

    int insertSelective(WeixinText record);

    List<WeixinText> selectByExampleWithRowbounds(WeixinTextExample example, RowBounds rowBounds);

    List<WeixinText> selectByExample(WeixinTextExample example);

    WeixinText selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WeixinText record, @Param("example") WeixinTextExample example);

    int updateByExample(@Param("record") WeixinText record, @Param("example") WeixinTextExample example);

    int updateByPrimaryKeySelective(WeixinText record);

    int updateByPrimaryKey(WeixinText record);
}