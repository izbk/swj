package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianReportPointVo;
/**
 * 统计员直报考核记录表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-20 16:57:34
 */
public class StatisticianReportPointLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<StatisticianReportPointVo> statisticianReportPointLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<StatisticianReportPointVo> getStatisticianReportPointLt() {
		return statisticianReportPointLt;
	}
	public void setStatisticianReportPointLt(List<StatisticianReportPointVo> statisticianReportPointLt) {
		this.statisticianReportPointLt = statisticianReportPointLt;
	}
}
