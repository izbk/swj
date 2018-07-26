package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Advice;
/**
 * 投诉建议
 * 
 * @author zbk
 * @email 
 * @date 2017-06-06 17:56:58
 */
public class AdviceLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Advice> adviceLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Advice> getAdviceLt() {
		return adviceLt;
	}
	public void setAdviceLt(List<Advice> adviceLt) {
		this.adviceLt = adviceLt;
	}
}
