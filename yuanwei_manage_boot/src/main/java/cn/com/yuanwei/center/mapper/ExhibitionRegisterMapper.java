package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.ExhibitionRegister;
import cn.com.yuanwei.center.entity.ExhibitionRegisterExample;
import cn.com.yuanwei.center.entity.ExhibitionRegisterVo;
@Mapper
public interface ExhibitionRegisterMapper {
    int countByExample(ExhibitionRegisterExample example);

    int deleteByExample(ExhibitionRegisterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExhibitionRegister record);

    int insertSelective(ExhibitionRegister record);

    List<ExhibitionRegister> selectByExampleWithRowbounds(ExhibitionRegisterExample example, RowBounds rowBounds);

    List<ExhibitionRegister> selectByExample(ExhibitionRegisterExample example);
    
    List<ExhibitionRegisterVo> selectByExampleForExport(ExhibitionRegisterExample example);

    ExhibitionRegister selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExhibitionRegister record, @Param("example") ExhibitionRegisterExample example);

    int updateByExample(@Param("record") ExhibitionRegister record, @Param("example") ExhibitionRegisterExample example);

    int updateByPrimaryKeySelective(ExhibitionRegister record);

    int updateByPrimaryKey(ExhibitionRegister record);
}