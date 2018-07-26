package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riversoft.weixin.common.message.MsgType;
import com.riversoft.weixin.common.message.XmlMessageHeader;
import com.riversoft.weixin.common.message.xml.TextXmlMessage;

import cn.com.yuanwei.center.entity.WeixinSubscribe;
import cn.com.yuanwei.center.entity.WeixinSubscribeExample;
import cn.com.yuanwei.center.mapper.WeixinSubscribeMapper;
import cn.com.yuanwei.center.service.WechatService;
import cn.com.yuanwei.center.util.ValidateUtil;
@Service
public class WechatServiceImpl implements WechatService {
	private Log logger =  LogFactory.getLog(this.getClass());
	@Autowired
	WeixinSubscribeMapper weixinSubscribeMapper;
	
	@Override
	public XmlMessageHeader coreService(XmlMessageHeader message) {
		// 发送方帐号（open_id）
		String fromUserName = message.getFromUser();
		// 公众帐号
		String toUserName = message.getToUser();
		// 消息类型
		MsgType msgType = message.getMsgType();
		
		logger.info("------------微信客户端发送请求---------------------   |   fromUserName:"+fromUserName+"   |   ToUserName:"+toUserName+"   |   msgType:"+msgType);
		
		List<WeixinSubscribe> list = weixinSubscribeMapper.selectByExample(new WeixinSubscribeExample());
		String welcome = "欢迎关注";
		if(!ValidateUtil.isEmpty(list)){
			WeixinSubscribe subscribe = list.get(0);
			welcome = subscribe.getWelcome();
		}
		
		TextXmlMessage resp = new TextXmlMessage();
		resp.setContent(welcome);
		resp.setFromUser(toUserName);
		resp.setToUser(fromUserName);
		resp.setMsgType(MsgType.text);
		resp.setCreateTime(new Date());
		return resp;
	}

}
