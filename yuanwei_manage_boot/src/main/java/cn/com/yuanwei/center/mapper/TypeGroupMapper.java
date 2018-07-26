package cn.com.yuanwei.center.mapper;

import cn.com.yuanwei.center.entity.TypeGroup;
import cn.com.yuanwei.center.entity.TypeGroupExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface TypeGroupMapper {
    int countByExample(TypeGroupExample example);

    int deleteByExample(TypeGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TypeGroup record);

    int insertSelective(TypeGroup record);

    List<TypeGroup> selectByExampleWithRowbounds(TypeGroupExample example, RowBounds rowBounds);

    List<TypeGroup> selectByExample(TypeGroupExample example);

    TypeGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TypeGroup record, @Param("example") TypeGroupExample example);

    int updateByExample(@Param("record") TypeGroup record, @Param("example") TypeGroupExample example);

    int updateByPrimaryKeySelective(TypeGroup record);

    int updateByPrimaryKey(TypeGroup record);
}