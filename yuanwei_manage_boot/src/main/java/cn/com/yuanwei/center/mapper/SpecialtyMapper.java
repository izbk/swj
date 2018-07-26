package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.Specialty;
import cn.com.yuanwei.center.entity.SpecialtyExample;
@Mapper
public interface SpecialtyMapper {
    int countByExample(SpecialtyExample example);

    int deleteByExample(SpecialtyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Specialty record);

    int insertSelective(Specialty record);

    List<Specialty> selectByExampleWithBLOBsWithRowbounds(SpecialtyExample example, RowBounds rowBounds);

    List<Specialty> selectByExampleWithBLOBs(SpecialtyExample example);

    List<Specialty> selectByExampleWithRowbounds(SpecialtyExample example, RowBounds rowBounds);

    List<Specialty> selectByExample(SpecialtyExample example);

    Specialty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Specialty record, @Param("example") SpecialtyExample example);

    int updateByExampleWithBLOBs(@Param("record") Specialty record, @Param("example") SpecialtyExample example);

    int updateByExample(@Param("record") Specialty record, @Param("example") SpecialtyExample example);

    int updateByPrimaryKeySelective(Specialty record);

    int updateByPrimaryKeyWithBLOBs(Specialty record);

    int updateByPrimaryKey(Specialty record);
}