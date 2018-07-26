package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.IncubationParkCompany;
import cn.com.yuanwei.center.entity.IncubationParkCompanyExample;
@Mapper
public interface IncubationParkCompanyMapper {
    int countByExample(IncubationParkCompanyExample example);

    int deleteByExample(IncubationParkCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IncubationParkCompany record);

    int insertSelective(IncubationParkCompany record);

    List<IncubationParkCompany> selectByExampleWithRowbounds(IncubationParkCompanyExample example, RowBounds rowBounds);

    List<IncubationParkCompany> selectByExample(IncubationParkCompanyExample example);

    IncubationParkCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IncubationParkCompany record, @Param("example") IncubationParkCompanyExample example);

    int updateByExample(@Param("record") IncubationParkCompany record, @Param("example") IncubationParkCompanyExample example);

    int updateByPrimaryKeySelective(IncubationParkCompany record);

    int updateByPrimaryKey(IncubationParkCompany record);
}