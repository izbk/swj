package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.TownshipAnnualTask;
/**
 * 镇乡年度目标任务表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-15 15:17:36
 */
public class TownshipAnnualTaskLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<TownshipAnnualTask> townshipAnnualTaskLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<TownshipAnnualTask> getTownshipAnnualTaskLt() {
		return townshipAnnualTaskLt;
	}
	public void setTownshipAnnualTaskLt(List<TownshipAnnualTask> townshipAnnualTaskLt) {
		this.townshipAnnualTaskLt = townshipAnnualTaskLt;
	}
}
