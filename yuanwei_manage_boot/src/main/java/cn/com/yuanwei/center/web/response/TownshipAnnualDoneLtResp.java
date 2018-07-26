package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.TownshipAnnualDone;
/**
 * 镇乡年度任务完成情况
 * 
 * @author zbk
 * @email 
 * @date 2017-06-15 15:17:36
 */
public class TownshipAnnualDoneLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<TownshipAnnualDone> townshipAnnualDoneLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<TownshipAnnualDone> getTownshipAnnualDoneLt() {
		return townshipAnnualDoneLt;
	}
	public void setTownshipAnnualDoneLt(List<TownshipAnnualDone> townshipAnnualDoneLt) {
		this.townshipAnnualDoneLt = townshipAnnualDoneLt;
	}
}
