package cn.com.yuanwei.center.mapper;

import cn.com.yuanwei.center.entity.StatisticianReward;
import cn.com.yuanwei.center.entity.StatisticianRewardExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface StatisticianRewardMapper {
    int countByExample(StatisticianRewardExample example);

    int deleteByExample(StatisticianRewardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatisticianReward record);

    int insertSelective(StatisticianReward record);

    List<StatisticianReward> selectByExampleWithRowbounds(StatisticianRewardExample example, RowBounds rowBounds);

    List<StatisticianReward> selectByExample(StatisticianRewardExample example);

    StatisticianReward selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatisticianReward record, @Param("example") StatisticianRewardExample example);

    int updateByExample(@Param("record") StatisticianReward record, @Param("example") StatisticianRewardExample example);

    int updateByPrimaryKeySelective(StatisticianReward record);

    int updateByPrimaryKey(StatisticianReward record);
}