package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.WeixinSubscribe;
/**
 * 订阅消息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 11:09:42
 */
public class WeixinSubscribeLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<WeixinSubscribe> weixinSubscribeLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<WeixinSubscribe> getWeixinSubscribeLt() {
		return weixinSubscribeLt;
	}
	public void setWeixinSubscribeLt(List<WeixinSubscribe> weixinSubscribeLt) {
		this.weixinSubscribeLt = weixinSubscribeLt;
	}
}
