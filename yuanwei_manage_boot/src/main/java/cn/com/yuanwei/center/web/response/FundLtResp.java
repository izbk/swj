package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Fund;
/**
 * 项目资金信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 11:03:17
 */
public class FundLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Fund> fundLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Fund> getFundLt() {
		return fundLt;
	}
	public void setFundLt(List<Fund> fundLt) {
		this.fundLt = fundLt;
	}
}
