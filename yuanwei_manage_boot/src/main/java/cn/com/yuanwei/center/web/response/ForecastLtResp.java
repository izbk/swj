package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Forecast;
/**
 * 总量预测结果表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-07 11:55:52
 */
public class ForecastLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Forecast> forecastLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Forecast> getForecastLt() {
		return forecastLt;
	}
	public void setForecastLt(List<Forecast> forecastLt) {
		this.forecastLt = forecastLt;
	}
}
