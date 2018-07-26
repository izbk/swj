package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.IncubationParkAssessment;
/**
 * 孵化园企业考核
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 17:42:05
 */
public class IncubationParkAssessmentLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<IncubationParkAssessment> incubationParkAssessmentLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<IncubationParkAssessment> getIncubationParkAssessmentLt() {
		return incubationParkAssessmentLt;
	}
	public void setIncubationParkAssessmentLt(List<IncubationParkAssessment> incubationParkAssessmentLt) {
		this.incubationParkAssessmentLt = incubationParkAssessmentLt;
	}
}
