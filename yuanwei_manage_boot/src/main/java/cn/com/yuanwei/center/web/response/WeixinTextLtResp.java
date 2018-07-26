package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.WeixinText;
/**
 * 微信文本消息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 11:09:42
 */
public class WeixinTextLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<WeixinText> weixinTextLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<WeixinText> getWeixinTextLt() {
		return weixinTextLt;
	}
	public void setWeixinTextLt(List<WeixinText> weixinTextLt) {
		this.weixinTextLt = weixinTextLt;
	}
}
