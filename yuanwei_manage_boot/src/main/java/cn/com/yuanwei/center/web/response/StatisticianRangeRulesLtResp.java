package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianRangeRules;
/**
 * 统计员排位得分规则
 * 
 * @author zbk
 * @email 
 * @date 2017-06-19 11:58:18
 */
public class StatisticianRangeRulesLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<StatisticianRangeRules> statisticianRangeRulesLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<StatisticianRangeRules> getStatisticianRangeRulesLt() {
		return statisticianRangeRulesLt;
	}
	public void setStatisticianRangeRulesLt(List<StatisticianRangeRules> statisticianRangeRulesLt) {
		this.statisticianRangeRulesLt = statisticianRangeRulesLt;
	}
}
