package cn.com.yuanwei.center.mapper;

import cn.com.yuanwei.center.entity.Department;
import cn.com.yuanwei.center.entity.DepartmentExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface DepartmentMapper {
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExampleWithBLOBsWithRowbounds(DepartmentExample example, RowBounds rowBounds);

    List<Department> selectByExampleWithBLOBs(DepartmentExample example);

    List<Department> selectByExampleWithRowbounds(DepartmentExample example, RowBounds rowBounds);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExampleWithBLOBs(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKeyWithBLOBs(Department record);

    int updateByPrimaryKey(Department record);
}