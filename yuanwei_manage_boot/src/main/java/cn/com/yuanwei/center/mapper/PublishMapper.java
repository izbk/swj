package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.Publish;
import cn.com.yuanwei.center.entity.PublishExample;
@Mapper
public interface PublishMapper {
    int countByExample(PublishExample example);

    int deleteByExample(PublishExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Publish record);

    int insertSelective(Publish record);

    List<Publish> selectByExampleWithBLOBsWithRowbounds(PublishExample example, RowBounds rowBounds);

    List<Publish> selectByExampleWithBLOBs(PublishExample example);

    List<Publish> selectByExampleWithRowbounds(PublishExample example, RowBounds rowBounds);

    List<Publish> selectByExample(PublishExample example);

    Publish selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Publish record, @Param("example") PublishExample example);

    int updateByExampleWithBLOBs(@Param("record") Publish record, @Param("example") PublishExample example);

    int updateByExample(@Param("record") Publish record, @Param("example") PublishExample example);

    int updateByPrimaryKeySelective(Publish record);

    int updateByPrimaryKeyWithBLOBs(Publish record);

    int updateByPrimaryKey(Publish record);
}