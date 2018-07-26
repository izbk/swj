package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.SettleRegister;
/**
 * 入园申请登记表
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:28:04
 */
public class SettleRegisterLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<SettleRegister> settleRegisterLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<SettleRegister> getSettleRegisterLt() {
		return settleRegisterLt;
	}
	public void setSettleRegisterLt(List<SettleRegister> settleRegisterLt) {
		this.settleRegisterLt = settleRegisterLt;
	}
}
