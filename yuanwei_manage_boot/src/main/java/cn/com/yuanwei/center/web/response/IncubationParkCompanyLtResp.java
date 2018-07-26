package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.IncubationParkCompany;
/**
 * 孵化园企业信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 17:26:50
 */
public class IncubationParkCompanyLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<IncubationParkCompany> incubationParkCompanyLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<IncubationParkCompany> getIncubationParkCompanyLt() {
		return incubationParkCompanyLt;
	}
	public void setIncubationParkCompanyLt(List<IncubationParkCompany> incubationParkCompanyLt) {
		this.incubationParkCompanyLt = incubationParkCompanyLt;
	}
}
