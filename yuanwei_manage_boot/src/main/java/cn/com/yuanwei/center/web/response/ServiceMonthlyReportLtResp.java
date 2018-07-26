package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.ServiceMonthlyReport;
/**
 * 服务业企业数据月报
 * 
 * @author zbk
 * @email 
 * @date 2017-06-07 11:55:52
 */
public class ServiceMonthlyReportLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<ServiceMonthlyReport> serviceMonthlyReportLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<ServiceMonthlyReport> getServiceMonthlyReportLt() {
		return serviceMonthlyReportLt;
	}
	public void setServiceMonthlyReportLt(List<ServiceMonthlyReport> serviceMonthlyReportLt) {
		this.serviceMonthlyReportLt = serviceMonthlyReportLt;
	}
}
