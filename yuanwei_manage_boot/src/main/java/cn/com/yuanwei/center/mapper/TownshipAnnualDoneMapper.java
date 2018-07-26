package cn.com.yuanwei.center.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.com.yuanwei.center.entity.CheckMonthVo;
import cn.com.yuanwei.center.entity.TownshipAnnualDone;
import cn.com.yuanwei.center.entity.TownshipAnnualDoneExample;
import cn.com.yuanwei.center.entity.TownshipAnnualDoneVo;
@Mapper
public interface TownshipAnnualDoneMapper {
    int countByExample(TownshipAnnualDoneExample example);

    int deleteByExample(TownshipAnnualDoneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TownshipAnnualDone record);

    int insertSelective(TownshipAnnualDone record);

    List<TownshipAnnualDone> selectByExampleWithRowbounds(TownshipAnnualDoneExample example, RowBounds rowBounds);

    List<TownshipAnnualDone> selectByExample(TownshipAnnualDoneExample example);
    
    List<TownshipAnnualDoneVo> selectTownshipAnnualDoneList(Map<String,Object> param);
    
    Integer selectCountAnnualTask(Integer year);
    
    CheckMonthVo selectCountRealReport(Integer year);

    TownshipAnnualDone selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TownshipAnnualDone record, @Param("example") TownshipAnnualDoneExample example);

    int updateByExample(@Param("record") TownshipAnnualDone record, @Param("example") TownshipAnnualDoneExample example);

    int updateByPrimaryKeySelective(TownshipAnnualDone record);

    int updateByPrimaryKey(TownshipAnnualDone record);
}