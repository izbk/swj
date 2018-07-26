package cn.com.yuanwei.center.mapper;

import cn.com.yuanwei.center.entity.EnterpriseManage;
import cn.com.yuanwei.center.entity.EnterpriseManageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface EnterpriseManageMapper {
    int countByExample(EnterpriseManageExample example);

    int deleteByExample(EnterpriseManageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EnterpriseManage record);

    int insertSelective(EnterpriseManage record);

    List<EnterpriseManage> selectByExampleWithRowbounds(EnterpriseManageExample example, RowBounds rowBounds);

    List<EnterpriseManage> selectByExample(EnterpriseManageExample example);

    EnterpriseManage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EnterpriseManage record, @Param("example") EnterpriseManageExample example);

    int updateByExample(@Param("record") EnterpriseManage record, @Param("example") EnterpriseManageExample example);

    int updateByPrimaryKeySelective(EnterpriseManage record);

    int updateByPrimaryKey(EnterpriseManage record);
}