package cn.com.yuanwei.center.service;

import com.riversoft.weixin.common.message.XmlMessageHeader;
public interface WechatService {
	public XmlMessageHeader coreService(XmlMessageHeader message);
}
