package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.WeixinTemplateRecord;
import cn.com.yuanwei.center.web.request.WeixinTemplateRecordReq;
import cn.com.yuanwei.center.web.response.WeixinTemplateRecordLtResp;
/**
 * 微信模板消息发送记录
 * 
 * @author zbk
 * @email 
 * @date 2017-06-26 17:15:28
 */
public interface WeixinTemplateRecordService {
   /**
	 * Desc:查询微信模板消息发送记录
	 * @param Integer id
	 * @return  WeixinTemplateRecord
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public WeixinTemplateRecord queryById(Integer id) throws Exception;
   /**
	 * Desc:查询微信模板消息发送记录列表
	 * @param WeixinTemplateRecordReq req
	 * @return WeixinTemplateRecordLtResp
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public WeixinTemplateRecordLtResp queryList(WeixinTemplateRecordReq req) throws Exception;
   /**
	 * Desc:新增微信模板消息发送记录
	 * @param WeixinTemplateRecord weixinTemplateRecord
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public Integer save(WeixinTemplateRecord weixinTemplateRecord) throws Exception;
	/**
	 * Desc:更新微信模板消息发送记录
	 * @param WeixinTemplateRecord weixinTemplateRecord
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public Integer update(WeixinTemplateRecord weixinTemplateRecord) throws Exception;
	/**
	 * Desc:删除微信模板消息发送记录
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:28
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
