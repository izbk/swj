package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.EnterpriseFeedback;
import cn.com.yuanwei.center.web.request.EnterpriseFeedbackReq;
import cn.com.yuanwei.center.web.response.EnterpriseFeedbackLtResp;
/**
 * 样本企业反馈信息
 * 
 * @author zbk
 * @email 
 * @date 2017-08-22 09:19:28
 */
public interface EnterpriseFeedbackService {
   /**
	 * Desc:查询样本企业反馈信息
	 * @param Integer id
	 * @return  EnterpriseFeedback
	 * @author zbk
	 * @date 2017-08-22 09:19:28
	 */
	public EnterpriseFeedback queryById(Integer id) throws Exception;
   /**
	 * Desc:查询样本企业反馈信息列表
	 * @param EnterpriseFeedbackReq req
	 * @return EnterpriseFeedbackLtResp
	 * @author zbk
	 * @date 2017-08-22 09:19:28
	 */
	public EnterpriseFeedbackLtResp queryList(EnterpriseFeedbackReq req) throws Exception;
   /**
	 * Desc:新增样本企业反馈信息
	 * @param EnterpriseFeedback enterpriseFeedback
	 * @return Integer id
	 * @author zbk
	 * @date 2017-08-22 09:19:28
	 */
	public Integer save(EnterpriseFeedback enterpriseFeedback) throws Exception;
	/**
	 * Desc:更新样本企业反馈信息
	 * @param EnterpriseFeedback enterpriseFeedback
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-08-22 09:19:28
	 */
	public Integer update(EnterpriseFeedback enterpriseFeedback) throws Exception;
	/**
	 * Desc:删除样本企业反馈信息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-08-22 09:19:28
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
