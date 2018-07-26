package cn.com.yuanwei.center.mapper;

import cn.com.yuanwei.center.entity.UserDepart;
import cn.com.yuanwei.center.entity.UserDepartExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface UserDepartMapper {
    int countByExample(UserDepartExample example);

    int deleteByExample(UserDepartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDepart record);

    int insertSelective(UserDepart record);

    List<UserDepart> selectByExampleWithRowbounds(UserDepartExample example, RowBounds rowBounds);

    List<UserDepart> selectByExample(UserDepartExample example);

    UserDepart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDepart record, @Param("example") UserDepartExample example);

    int updateByExample(@Param("record") UserDepart record, @Param("example") UserDepartExample example);

    int updateByPrimaryKeySelective(UserDepart record);

    int updateByPrimaryKey(UserDepart record);
}