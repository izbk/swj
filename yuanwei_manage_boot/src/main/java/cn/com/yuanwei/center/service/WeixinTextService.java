package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.WeixinText;
import cn.com.yuanwei.center.web.request.WeixinTextReq;
import cn.com.yuanwei.center.web.response.WeixinTextLtResp;
/**
 * 微信文本消息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 11:09:42
 */
public interface WeixinTextService {
   /**
	 * Desc:查询微信文本消息
	 * @param Integer id
	 * @return  WeixinText
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public WeixinText queryById(Integer id) throws Exception;
   /**
	 * Desc:查询微信文本消息列表
	 * @param WeixinTextReq req
	 * @return WeixinTextLtResp
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public WeixinTextLtResp queryList(WeixinTextReq req) throws Exception;
   /**
	 * Desc:新增微信文本消息
	 * @param WeixinText weixinText
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public Integer save(WeixinText weixinText) throws Exception;
	/**
	 * Desc:更新微信文本消息
	 * @param WeixinText weixinText
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public Integer update(WeixinText weixinText) throws Exception;
	/**
	 * Desc:删除微信文本消息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public Integer delete(List<Integer> req) throws Exception;
   /**
	 * Desc:发送微信文本消息
	 * @param Integer id
	 * @return  Long msgId
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public Long send(Integer id) throws Exception;
}
