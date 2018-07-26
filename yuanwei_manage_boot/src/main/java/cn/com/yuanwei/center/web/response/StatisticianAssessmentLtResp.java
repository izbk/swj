package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianAssessment;
/**
 * 统计员任务考核
 * 
 * @author zbk
 * @email 
 * @date 2017-06-15 15:17:36
 */
public class StatisticianAssessmentLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<StatisticianAssessment> statisticianAssessmentLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<StatisticianAssessment> getStatisticianAssessmentLt() {
		return statisticianAssessmentLt;
	}
	public void setStatisticianAssessmentLt(List<StatisticianAssessment> statisticianAssessmentLt) {
		this.statisticianAssessmentLt = statisticianAssessmentLt;
	}
}
