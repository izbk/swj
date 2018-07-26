package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.EnterpriseRise;
/**
 * 企业预测增幅设置
 * 
 * @author zbk
 * @email 
 * @date 2017-05-12 17:10:44
 */
public class EnterpriseRiseLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<EnterpriseRise> enterpriseRiseLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<EnterpriseRise> getEnterpriseRiseLt() {
		return enterpriseRiseLt;
	}
	public void setEnterpriseRiseLt(List<EnterpriseRise> enterpriseRiseLt) {
		this.enterpriseRiseLt = enterpriseRiseLt;
	}
}
