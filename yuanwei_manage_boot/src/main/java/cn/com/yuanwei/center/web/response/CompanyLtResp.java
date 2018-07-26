package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Company;
/**
 * 企业信息表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-07 14:35:42
 */
public class CompanyLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Company> companyLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Company> getCompanyLt() {
		return companyLt;
	}
	public void setCompanyLt(List<Company> companyLt) {
		this.companyLt = companyLt;
	}
}
