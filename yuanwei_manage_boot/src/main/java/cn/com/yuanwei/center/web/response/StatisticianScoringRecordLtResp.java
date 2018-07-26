package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianScoringRecord;
/**
 * 统计员得分记录
 * 
 * @author zbk
 * @email 
 * @date 2017-06-19 11:52:16
 */
public class StatisticianScoringRecordLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<StatisticianScoringRecord> statisticianScoringRecordLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<StatisticianScoringRecord> getStatisticianScoringRecordLt() {
		return statisticianScoringRecordLt;
	}
	public void setStatisticianScoringRecordLt(List<StatisticianScoringRecord> statisticianScoringRecordLt) {
		this.statisticianScoringRecordLt = statisticianScoringRecordLt;
	}
}
