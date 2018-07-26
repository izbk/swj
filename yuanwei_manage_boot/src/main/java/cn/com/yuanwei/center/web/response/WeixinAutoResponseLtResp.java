package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.WeixinAutoResponse;
/**
 * 自动回复
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 11:09:43
 */
public class WeixinAutoResponseLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<WeixinAutoResponse> weixinAutoResponseLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<WeixinAutoResponse> getWeixinAutoResponseLt() {
		return weixinAutoResponseLt;
	}
	public void setWeixinAutoResponseLt(List<WeixinAutoResponse> weixinAutoResponseLt) {
		this.weixinAutoResponseLt = weixinAutoResponseLt;
	}
}
