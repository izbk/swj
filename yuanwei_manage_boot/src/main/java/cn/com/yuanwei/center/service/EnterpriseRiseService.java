package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.EnterpriseRise;
import cn.com.yuanwei.center.web.request.EnterpriseRiseReq;
import cn.com.yuanwei.center.web.response.EnterpriseRiseLtResp;
/**
 * 企业预测增幅设置
 * 
 * @author zbk
 * @email 
 * @date 2017-06-26 17:15:27
 */
public interface EnterpriseRiseService {
   /**
	 * Desc:查询企业预测增幅设置
	 * @param Integer id
	 * @return  EnterpriseRise
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public EnterpriseRise queryById(Integer id) throws Exception;
   /**
	 * Desc:查询企业预测增幅设置列表
	 * @param EnterpriseRiseReq req
	 * @return EnterpriseRiseLtResp
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public EnterpriseRiseLtResp queryList(EnterpriseRiseReq req) throws Exception;
   /**
	 * Desc:新增企业预测增幅设置
	 * @param EnterpriseRise enterpriseRise
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer save(EnterpriseRise enterpriseRise) throws Exception;
	/**
	 * Desc:更新企业预测增幅设置
	 * @param EnterpriseRise enterpriseRise
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer update(EnterpriseRise enterpriseRise) throws Exception;
	/**
	 * Desc:删除企业预测增幅设置
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
