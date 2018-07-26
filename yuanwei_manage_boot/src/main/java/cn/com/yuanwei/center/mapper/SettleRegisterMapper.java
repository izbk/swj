package cn.com.yuanwei.center.mapper;

import cn.com.yuanwei.center.entity.SettleRegister;
import cn.com.yuanwei.center.entity.SettleRegisterExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface SettleRegisterMapper {
    int countByExample(SettleRegisterExample example);

    int deleteByExample(SettleRegisterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SettleRegister record);

    int insertSelective(SettleRegister record);

    List<SettleRegister> selectByExampleWithRowbounds(SettleRegisterExample example, RowBounds rowBounds);

    List<SettleRegister> selectByExample(SettleRegisterExample example);

    SettleRegister selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SettleRegister record, @Param("example") SettleRegisterExample example);

    int updateByExample(@Param("record") SettleRegister record, @Param("example") SettleRegisterExample example);

    int updateByPrimaryKeySelective(SettleRegister record);

    int updateByPrimaryKey(SettleRegister record);
}