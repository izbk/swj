package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.FundDetail;
/**
 * 项目资金拨付信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 11:03:17
 */
public class FundDetailLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<FundDetail> fundDetailLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<FundDetail> getFundDetailLt() {
		return fundDetailLt;
	}
	public void setFundDetailLt(List<FundDetail> fundDetailLt) {
		this.fundDetailLt = fundDetailLt;
	}
}
