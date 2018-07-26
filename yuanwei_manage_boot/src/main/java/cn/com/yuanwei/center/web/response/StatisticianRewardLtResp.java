package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianReward;
/**
 * 统计员补助金额信息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-15 15:17:36
 */
public class StatisticianRewardLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<StatisticianReward> statisticianRewardLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<StatisticianReward> getStatisticianRewardLt() {
		return statisticianRewardLt;
	}
	public void setStatisticianRewardLt(List<StatisticianReward> statisticianRewardLt) {
		this.statisticianRewardLt = statisticianRewardLt;
	}
}
