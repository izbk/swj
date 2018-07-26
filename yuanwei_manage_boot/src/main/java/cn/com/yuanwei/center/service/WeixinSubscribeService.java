package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.WeixinSubscribe;
import cn.com.yuanwei.center.web.request.WeixinSubscribeReq;
import cn.com.yuanwei.center.web.response.WeixinSubscribeLtResp;
/**
 * 订阅消息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-26 17:15:28
 */
public interface WeixinSubscribeService {
   /**
	 * Desc:查询订阅消息
	 * @param Integer id
	 * @return  WeixinSubscribe
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public WeixinSubscribe queryById(Integer id) throws Exception;
   /**
	 * Desc:查询订阅消息列表
	 * @param WeixinSubscribeReq req
	 * @return WeixinSubscribeLtResp
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public WeixinSubscribeLtResp queryList(WeixinSubscribeReq req) throws Exception;
   /**
	 * Desc:新增订阅消息
	 * @param WeixinSubscribe weixinSubscribe
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public Integer save(WeixinSubscribe weixinSubscribe) throws Exception;
	/**
	 * Desc:更新订阅消息
	 * @param WeixinSubscribe weixinSubscribe
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public Integer update(WeixinSubscribe weixinSubscribe) throws Exception;
	/**
	 * Desc:删除订阅消息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
