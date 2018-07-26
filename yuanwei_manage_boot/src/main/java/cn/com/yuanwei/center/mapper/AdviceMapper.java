package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.Advice;
import cn.com.yuanwei.center.entity.AdviceExample;
@Mapper
public interface AdviceMapper {
    int countByExample(AdviceExample example);

    int deleteByExample(AdviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Advice record);

    int insertSelective(Advice record);

    List<Advice> selectByExampleWithBLOBsWithRowbounds(AdviceExample example, RowBounds rowBounds);

    List<Advice> selectByExampleWithBLOBs(AdviceExample example);

    List<Advice> selectByExampleWithRowbounds(AdviceExample example, RowBounds rowBounds);

    List<Advice> selectByExample(AdviceExample example);

    Advice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Advice record, @Param("example") AdviceExample example);

    int updateByExampleWithBLOBs(@Param("record") Advice record, @Param("example") AdviceExample example);

    int updateByExample(@Param("record") Advice record, @Param("example") AdviceExample example);

    int updateByPrimaryKeySelective(Advice record);

    int updateByPrimaryKeyWithBLOBs(Advice record);

    int updateByPrimaryKey(Advice record);
}