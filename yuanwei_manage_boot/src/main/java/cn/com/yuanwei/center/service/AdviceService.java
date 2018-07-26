package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Advice;
import cn.com.yuanwei.center.web.request.AdviceReq;
import cn.com.yuanwei.center.web.response.AdviceLtResp;
/**
 * 投诉建议
 * 
 * @author zbk
 * @email 
 * @date 2017-06-06 17:56:58
 */
public interface AdviceService {
   /**
	 * Desc:查询投诉建议
	 * @param Integer id
	 * @return  Advice
	 * @author zbk
	 * @date 2017-06-06 17:56:58
	 */
	public Advice queryById(Integer id) throws Exception;
   /**
	 * Desc:查询投诉建议列表
	 * @param AdviceReq req
	 * @return AdviceLtResp
	 * @author zbk
	 * @date 2017-06-06 17:56:58
	 */
	public AdviceLtResp queryList(AdviceReq req) throws Exception;
   /**
	 * Desc:新增投诉建议
	 * @param Advice advice
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-06 17:56:58
	 */
	public Integer save(Advice advice) throws Exception;
	/**
	 * Desc:更新投诉建议
	 * @param Advice advice
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-06 17:56:58
	 */
	public Integer update(Advice advice) throws Exception;
	/**
	 * Desc:删除投诉建议
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-06 17:56:58
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
