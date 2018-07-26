package cn.com.yuanwei.center.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riversoft.weixin.common.decrypt.MessageDecryption;
import com.riversoft.weixin.common.decrypt.SHA1;
import com.riversoft.weixin.common.jsapi.JsAPISignature;
import com.riversoft.weixin.common.message.XmlMessageHeader;
import com.riversoft.weixin.mp.base.AppSetting;
import com.riversoft.weixin.mp.jsapi.JsAPIs;
import com.riversoft.weixin.mp.message.MpXmlMessages;

import cn.com.yuanwei.center.service.WechatService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.response.base.Result;

@Controller
@RequestMapping("/wechats")
public class WechatController {

	@Autowired
	private WechatService wechatService;

	@GetMapping
	public void wechatGet(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "signature") String signature, 
			@RequestParam(value = "timestamp") String timestamp,
			@RequestParam(value = "nonce") String nonce, 
			@RequestParam(value = "echostr") String echostr) throws Exception {
		
		AppSetting appSetting = AppSetting.defaultSettings();
		//验证签名
		if (SHA1.getSHA1(appSetting.getToken(), timestamp, nonce).equals(signature)) {
			response.getWriter().print(echostr);
		}
	}

	@PostMapping
	public void wechatPost(HttpServletRequest request, HttpServletResponse response,
			@RequestBody(required = false) String content) throws Exception {
		
		AppSetting appSetting = AppSetting.defaultSettings();
		PrintWriter out = response.getWriter();
		XmlMessageHeader xmlRequest = null;
		String signature = request.getParameter("msg_signature");//请求中的消息签名 
		String timestamp = request.getParameter("timestamp");//时间戳 
		String nonce = request.getParameter("nonce");//无序数列 
		String encrypt_type = request.getParameter("encrypt_type");//加密方式
		//安全模式
		if ("aes".equals(encrypt_type)) {
			MessageDecryption messageDecryption = new MessageDecryption(appSetting.getToken(), appSetting.getAesKey(),appSetting.getAppId());
			xmlRequest = MpXmlMessages.fromXml(messageDecryption.decrypt(signature, timestamp, nonce, content));
			//service处理
			XmlMessageHeader xmlResponse = wechatService.coreService(xmlRequest);

			if (xmlResponse != null) {
				out.print(messageDecryption.encrypt(MpXmlMessages.toXml(xmlResponse), timestamp, nonce));
				out.close();
			}
		} else {//明文模式
			xmlRequest = MpXmlMessages.fromXml(content);
			//service处理
			XmlMessageHeader xmlResponse = wechatService.coreService(xmlRequest);
			if (xmlResponse != null) {
				out.print(MpXmlMessages.toXml(xmlResponse));
				out.close();
			}
		}
	}
	
	@GetMapping(value="jssign")
	@ResponseBody
	public Result getJsAPISignature(@RequestParam(value="url") String url) throws Exception{
		if(ValidateUtil.isEmpty(url)){
			throw new Exception("签名URL为空");
		}
		String urls = url.substring(0,url.indexOf("#"));
		JsAPISignature signature = JsAPIs.defaultJsAPIs().createJsAPISignature(urls);
		Result re = new Result(signature);
		return re;
	}
}
