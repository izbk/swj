package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.ServiceLogs;
/**
 * 系统日志
 * 
 * @author zbk
 * @email 
 * @date 2017-06-22 10:57:25
 */
public class ServiceLogsLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<ServiceLogs> serviceLogsLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<ServiceLogs> getServiceLogsLt() {
		return serviceLogsLt;
	}
	public void setServiceLogsLt(List<ServiceLogs> serviceLogsLt) {
		this.serviceLogsLt = serviceLogsLt;
	}
}
