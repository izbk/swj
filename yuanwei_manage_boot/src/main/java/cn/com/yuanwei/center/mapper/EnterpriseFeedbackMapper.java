package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.EnterpriseFeedback;
import cn.com.yuanwei.center.entity.EnterpriseFeedbackExample;
@Mapper
public interface EnterpriseFeedbackMapper {
    int countByExample(EnterpriseFeedbackExample example);

    int deleteByExample(EnterpriseFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EnterpriseFeedback record);

    int insertSelective(EnterpriseFeedback record);

    List<EnterpriseFeedback> selectByExampleWithRowbounds(EnterpriseFeedbackExample example, RowBounds rowBounds);

    List<EnterpriseFeedback> selectByExample(EnterpriseFeedbackExample example);

    EnterpriseFeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EnterpriseFeedback record, @Param("example") EnterpriseFeedbackExample example);

    int updateByExample(@Param("record") EnterpriseFeedback record, @Param("example") EnterpriseFeedbackExample example);

    int updateByPrimaryKeySelective(EnterpriseFeedback record);

    int updateByPrimaryKey(EnterpriseFeedback record);
}