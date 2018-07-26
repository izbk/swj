package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.IncubationParkRegister;
/**
 * 孵化园申请登记信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-03 17:59:11
 */
public class IncubationParkRegisterLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<IncubationParkRegister> incubationParkRegisterLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<IncubationParkRegister> getIncubationParkRegisterLt() {
		return incubationParkRegisterLt;
	}
	public void setIncubationParkRegisterLt(List<IncubationParkRegister> incubationParkRegisterLt) {
		this.incubationParkRegisterLt = incubationParkRegisterLt;
	}
}
