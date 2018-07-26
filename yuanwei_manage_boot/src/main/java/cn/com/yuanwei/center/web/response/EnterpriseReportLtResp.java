package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.com.yuanwei.center.entity.EnterpriseReportVo;
/**
 * 企业数据上报
 * 
 * @author zbk
 * @email 
 * @date 2017-05-12 21:01:40
 */
public class EnterpriseReportLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<EnterpriseReportVo> enterpriseReportLt;
	private Map<String,Object> rise;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<EnterpriseReportVo> getEnterpriseReportLt() {
		return enterpriseReportLt;
	}
	public void setEnterpriseReportLt(List<EnterpriseReportVo> enterpriseReportLt) {
		this.enterpriseReportLt = enterpriseReportLt;
	}
	public Map<String, Object> getRise() {
		return rise;
	}
	public void setRise(Map<String, Object> rise) {
		this.rise = rise;
	}

}
