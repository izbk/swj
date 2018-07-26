package cn.com.yuanwei.center.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.Type;
import cn.com.yuanwei.center.entity.TypeExample;
import cn.com.yuanwei.center.entity.TypeVo;
@Mapper
public interface TypeMapper {
    int countByExample(TypeExample example);

    int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExampleWithRowbounds(TypeExample example, RowBounds rowBounds);

    List<Type> selectByExample(TypeExample example);
    
    List<TypeVo> selectCommonTypeList(Map<String,Object> param);

    Type selectByPrimaryKey(Integer id);
    
    String selectTypeCodesToString(TypeExample example);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}