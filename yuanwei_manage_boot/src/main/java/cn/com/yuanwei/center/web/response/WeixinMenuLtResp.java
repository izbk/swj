package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.WeixinMenu;
/**
 * 微信菜单
 * 
 * @author zbk
 * @email 
 * @date 2017-06-08 15:01:39
 */
public class WeixinMenuLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<WeixinMenu> weixinMenuLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<WeixinMenu> getWeixinMenuLt() {
		return weixinMenuLt;
	}
	public void setWeixinMenuLt(List<WeixinMenu> weixinMenuLt) {
		this.weixinMenuLt = weixinMenuLt;
	}
}
