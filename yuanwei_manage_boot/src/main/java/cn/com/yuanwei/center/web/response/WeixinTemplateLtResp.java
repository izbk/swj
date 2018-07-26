package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.WeixinTemplate;
/**
 * 微信模板消息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 16:18:41
 */
public class WeixinTemplateLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<WeixinTemplate> weixinTemplateLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<WeixinTemplate> getWeixinTemplateLt() {
		return weixinTemplateLt;
	}
	public void setWeixinTemplateLt(List<WeixinTemplate> weixinTemplateLt) {
		this.weixinTemplateLt = weixinTemplateLt;
	}
}
