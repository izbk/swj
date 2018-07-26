package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.WeixinNewsitem;
import cn.com.yuanwei.center.web.request.WeixinNewsitemReq;
import cn.com.yuanwei.center.web.response.WeixinNewsitemLtResp;
/**
 * 微信图文消息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 11:09:42
 */
public interface WeixinNewsitemService {
   /**
	 * Desc:查询微信图文消息
	 * @param Integer id
	 * @return  WeixinNewsitem
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public WeixinNewsitem queryById(Integer id) throws Exception;
   /**
	 * Desc:查询微信图文消息列表
	 * @param WeixinNewsitemReq req
	 * @return WeixinNewsitemLtResp
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public WeixinNewsitemLtResp queryList(WeixinNewsitemReq req) throws Exception;
   /**
	 * Desc:新增微信图文消息
	 * @param WeixinNewsitem weixinNewsitem
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public Integer save(WeixinNewsitem weixinNewsitem) throws Exception;
	/**
	 * Desc:更新微信图文消息
	 * @param WeixinNewsitem weixinNewsitem
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public Integer update(WeixinNewsitem weixinNewsitem) throws Exception;
	/**
	 * Desc:删除微信图文消息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public Integer delete(List<Integer> req) throws Exception;
	/**
	 * Desc:发送微信图文消息
	 * @param List<Integer> req
	 * @return	 Long msgId
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public Long send(List<Integer> req) throws Exception;
}
