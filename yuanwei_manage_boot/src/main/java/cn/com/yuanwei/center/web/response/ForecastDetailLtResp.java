package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.ForecastDetail;
/**
 * 企业预测结果表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-07 12:13:22
 */
public class ForecastDetailLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<ForecastDetail> forecastDetailLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<ForecastDetail> getForecastDetailLt() {
		return forecastDetailLt;
	}
	public void setForecastDetailLt(List<ForecastDetail> forecastDetailLt) {
		this.forecastDetailLt = forecastDetailLt;
	}
}
