package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.WeixinTemplate;
import cn.com.yuanwei.center.web.request.WeixinTemplateReq;
import cn.com.yuanwei.center.web.response.WeixinTemplateLtResp;
/**
 * 微信模板消息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 16:18:41
 */
public interface WeixinTemplateService {
   /**
	 * Desc:查询微信模板消息
	 * @param Integer id
	 * @return  WeixinTemplate
	 * @author zbk
	 * @date 2017-06-05 16:18:41
	 */
	public WeixinTemplate queryById(Integer id) throws Exception;
   /**
	 * Desc:查询微信模板消息列表
	 * @param WeixinTemplateReq req
	 * @return WeixinTemplateLtResp
	 * @author zbk
	 * @date 2017-06-05 16:18:41
	 */
	public WeixinTemplateLtResp queryList(WeixinTemplateReq req) throws Exception;
   /**
	 * Desc:新增微信模板消息
	 * @param WeixinTemplate weixinTemplate
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-05 16:18:41
	 */
	public Integer save(WeixinTemplate weixinTemplate) throws Exception;
	/**
	 * Desc:更新微信模板消息
	 * @param WeixinTemplate weixinTemplate
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-05 16:18:41
	 */
	public Integer update(WeixinTemplate weixinTemplate) throws Exception;
	/**
	 * Desc:删除微信模板消息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-05 16:18:41
	 */
	public Integer delete(List<Integer> req) throws Exception;
	/**
	 * Desc:发送微信模板消息
	 * @param List<Integer> userIds
	 * @param integer id
	 * @return	 Long affectRows
	 * @author zbk
	 * @date 2017-06-05 16:18:41
	 */
	public void send(List<Integer> userIds,Integer id) throws Exception;
}
