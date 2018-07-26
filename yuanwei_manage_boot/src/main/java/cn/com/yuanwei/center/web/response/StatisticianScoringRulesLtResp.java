package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianScoringRules;
/**
 * 统计员计分细则
 * 
 * @author zbk
 * @email 
 * @date 2017-06-15 15:17:36
 */
public class StatisticianScoringRulesLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<StatisticianScoringRules> statisticianScoringRulesLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<StatisticianScoringRules> getStatisticianScoringRulesLt() {
		return statisticianScoringRulesLt;
	}
	public void setStatisticianScoringRulesLt(List<StatisticianScoringRules> statisticianScoringRulesLt) {
		this.statisticianScoringRulesLt = statisticianScoringRulesLt;
	}
}
