package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.Company;
import cn.com.yuanwei.center.entity.CompanyExample;
@Mapper
public interface CompanyMapper {
    int countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExampleWithBLOBsWithRowbounds(CompanyExample example, RowBounds rowBounds);

    List<Company> selectByExampleWithBLOBs(CompanyExample example);

    List<Company> selectByExampleWithRowbounds(CompanyExample example, RowBounds rowBounds);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExampleWithBLOBs(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKeyWithBLOBs(Company record);

    int updateByPrimaryKey(Company record);
}