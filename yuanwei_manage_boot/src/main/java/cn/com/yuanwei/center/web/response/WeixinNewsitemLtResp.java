package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.WeixinNewsitem;
/**
 * 微信图文消息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 11:09:42
 */
public class WeixinNewsitemLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<WeixinNewsitem> weixinNewsitemLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<WeixinNewsitem> getWeixinNewsitemLt() {
		return weixinNewsitemLt;
	}
	public void setWeixinNewsitemLt(List<WeixinNewsitem> weixinNewsitemLt) {
		this.weixinNewsitemLt = weixinNewsitemLt;
	}
}
