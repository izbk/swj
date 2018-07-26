package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Enterprise;
/**
 * 限上企业信息表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-16 14:55:57
 */
public class EnterpriseLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Enterprise> enterpriseLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Enterprise> getEnterpriseLt() {
		return enterpriseLt;
	}
	public void setEnterpriseLt(List<Enterprise> enterpriseLt) {
		this.enterpriseLt = enterpriseLt;
	}
}
