package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.EnterpriseManage;
/**
 * 企业进退库管理表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-16 14:55:57
 */
public class EnterpriseManageLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<EnterpriseManage> enterpriseManageLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<EnterpriseManage> getEnterpriseManageLt() {
		return enterpriseManageLt;
	}
	public void setEnterpriseManageLt(List<EnterpriseManage> enterpriseManageLt) {
		this.enterpriseManageLt = enterpriseManageLt;
	}
}
