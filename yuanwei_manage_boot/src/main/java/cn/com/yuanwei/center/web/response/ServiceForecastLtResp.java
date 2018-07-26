package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.ServiceForecast;
/**
 * 服务业企业数据预测
 * 
 * @author zbk
 * @email 
 * @date 2017-06-09 10:02:26
 */
public class ServiceForecastLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<ServiceForecast> serviceForecastLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<ServiceForecast> getServiceForecastLt() {
		return serviceForecastLt;
	}
	public void setServiceForecastLt(List<ServiceForecast> serviceForecastLt) {
		this.serviceForecastLt = serviceForecastLt;
	}
}
