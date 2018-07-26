package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.WeixinAutoResponse;
import cn.com.yuanwei.center.web.request.WeixinAutoResponseReq;
import cn.com.yuanwei.center.web.response.WeixinAutoResponseLtResp;
/**
 * 自动回复
 * 
 * @author zbk
 * @email 
 * @date 2017-06-26 17:15:28
 */
public interface WeixinAutoResponseService {
   /**
	 * Desc:查询自动回复
	 * @param Integer id
	 * @return  WeixinAutoResponse
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public WeixinAutoResponse queryById(Integer id) throws Exception;
   /**
	 * Desc:查询自动回复列表
	 * @param WeixinAutoResponseReq req
	 * @return WeixinAutoResponseLtResp
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public WeixinAutoResponseLtResp queryList(WeixinAutoResponseReq req) throws Exception;
   /**
	 * Desc:新增自动回复
	 * @param WeixinAutoResponse weixinAutoResponse
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public Integer save(WeixinAutoResponse weixinAutoResponse) throws Exception;
	/**
	 * Desc:更新自动回复
	 * @param WeixinAutoResponse weixinAutoResponse
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public Integer update(WeixinAutoResponse weixinAutoResponse) throws Exception;
	/**
	 * Desc:删除自动回复
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
