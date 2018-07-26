package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.EnterpriseFeedback;
/**
 * 样本企业反馈信息
 * 
 * @author zbk
 * @email 
 * @date 2017-08-22 09:19:28
 */
public class EnterpriseFeedbackLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<EnterpriseFeedback> enterpriseFeedbackLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<EnterpriseFeedback> getEnterpriseFeedbackLt() {
		return enterpriseFeedbackLt;
	}
	public void setEnterpriseFeedbackLt(List<EnterpriseFeedback> enterpriseFeedbackLt) {
		this.enterpriseFeedbackLt = enterpriseFeedbackLt;
	}
}
