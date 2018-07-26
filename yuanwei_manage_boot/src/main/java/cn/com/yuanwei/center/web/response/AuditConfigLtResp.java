package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.AuditConfig;
/**
 * 审核配置
 * 
 * @author zbk
 * @email 
 * @date 2017-05-16 11:11:22
 */
public class AuditConfigLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<AuditConfig> auditConfigLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<AuditConfig> getAuditConfigLt() {
		return auditConfigLt;
	}
	public void setAuditConfigLt(List<AuditConfig> auditConfigLt) {
		this.auditConfigLt = auditConfigLt;
	}
}
