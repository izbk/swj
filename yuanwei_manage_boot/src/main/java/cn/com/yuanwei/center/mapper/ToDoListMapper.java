package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.ToDoList;
import cn.com.yuanwei.center.entity.ToDoListExample;
@Mapper
public interface ToDoListMapper {
    int countByExample(ToDoListExample example);

    int deleteByExample(ToDoListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ToDoList record);

    int insertSelective(ToDoList record);

    List<ToDoList> selectByExampleWithRowbounds(ToDoListExample example, RowBounds rowBounds);

    List<ToDoList> selectByExample(ToDoListExample example);

    ToDoList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ToDoList record, @Param("example") ToDoListExample example);

    int updateByExample(@Param("record") ToDoList record, @Param("example") ToDoListExample example);

    int updateByPrimaryKeySelective(ToDoList record);

    int updateByPrimaryKey(ToDoList record);
}