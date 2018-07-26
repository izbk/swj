package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.WeixinTemplateRecord;
/**
 * 微信模板消息发送记录
 * 
 * @author zbk
 * @email 
 * @date 2017-06-09 17:41:23
 */
public class WeixinTemplateRecordLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<WeixinTemplateRecord> weixinTemplateRecordLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<WeixinTemplateRecord> getWeixinTemplateRecordLt() {
		return weixinTemplateRecordLt;
	}
	public void setWeixinTemplateRecordLt(List<WeixinTemplateRecord> weixinTemplateRecordLt) {
		this.weixinTemplateRecordLt = weixinTemplateRecordLt;
	}
}
