package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.ServiceDefine;
/**
 * 服务业企业数据定义
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:44
 */
public class ServiceDefineLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<ServiceDefine> serviceDefineLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<ServiceDefine> getServiceDefineLt() {
		return serviceDefineLt;
	}
	public void setServiceDefineLt(List<ServiceDefine> serviceDefineLt) {
		this.serviceDefineLt = serviceDefineLt;
	}
}
