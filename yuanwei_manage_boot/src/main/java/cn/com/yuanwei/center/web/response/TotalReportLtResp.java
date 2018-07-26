package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.TotalReport;
/**
 * 总量数据表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-01 15:57:22
 */
public class TotalReportLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<TotalReport> totalReportLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<TotalReport> getTotalReportLt() {
		return totalReportLt;
	}
	public void setTotalReportLt(List<TotalReport> totalReportLt) {
		this.totalReportLt = totalReportLt;
	}
}
