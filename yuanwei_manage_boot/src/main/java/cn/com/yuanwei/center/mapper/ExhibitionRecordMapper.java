package cn.com.yuanwei.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.ExhibitionRecord;
import cn.com.yuanwei.center.entity.ExhibitionRecordExample;
@Mapper
public interface ExhibitionRecordMapper {
    int countByExample(ExhibitionRecordExample example);

    int deleteByExample(ExhibitionRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExhibitionRecord record);

    int insertSelective(ExhibitionRecord record);

    List<ExhibitionRecord> selectByExampleWithRowbounds(ExhibitionRecordExample example, RowBounds rowBounds);

    List<ExhibitionRecord> selectByExample(ExhibitionRecordExample example);

    ExhibitionRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExhibitionRecord record, @Param("example") ExhibitionRecordExample example);

    int updateByExample(@Param("record") ExhibitionRecord record, @Param("example") ExhibitionRecordExample example);

    int updateByPrimaryKeySelective(ExhibitionRecord record);

    int updateByPrimaryKey(ExhibitionRecord record);
}