package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.IncubationParkRegister;
import cn.com.yuanwei.center.entity.IncubationParkRegisterExample;
@Mapper
public interface IncubationParkRegisterMapper {
    int countByExample(IncubationParkRegisterExample example);

    int deleteByExample(IncubationParkRegisterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IncubationParkRegister record);

    int insertSelective(IncubationParkRegister record);

    List<IncubationParkRegister> selectByExampleWithRowbounds(IncubationParkRegisterExample example, RowBounds rowBounds);

    List<IncubationParkRegister> selectByExample(IncubationParkRegisterExample example);

    IncubationParkRegister selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IncubationParkRegister record, @Param("example") IncubationParkRegisterExample example);

    int updateByExample(@Param("record") IncubationParkRegister record, @Param("example") IncubationParkRegisterExample example);

    int updateByPrimaryKeySelective(IncubationParkRegister record);

    int updateByPrimaryKey(IncubationParkRegister record);
}