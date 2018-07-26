package cn.com.yuanwei.center.service;

import java.util.List;
import java.util.Map;

import cn.com.yuanwei.center.entity.EnterpriseReport;
import cn.com.yuanwei.center.web.request.EnterpriseReportReq;
import cn.com.yuanwei.center.web.response.EnterpriseReportLtResp;
/**
 * 企业数据上报
 * 
 * @author zbk
 * @email 
 * @date 2017-05-12 21:01:40
 */
public interface EnterpriseReportService {
   /**
	 * Desc:查询企业数据上报
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	public EnterpriseReport queryById(Integer id) throws Exception;
   /**
	 * Desc:查询企业数据上报列表
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	public EnterpriseReportLtResp queryList(EnterpriseReportReq req) throws Exception;
	/**
	 * Desc:查询企业同期数据
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	public Map<String,Object> queryTqs(EnterpriseReportReq req) throws Exception;
   /**
	 * Desc:新增企业数据上报
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	public void save(EnterpriseReport enterpriseReport) throws Exception;
	/**
	 * Desc:更新企业数据上报
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	public void update(EnterpriseReport enterpriseReport) throws Exception;
	/**
	 * Desc:删除企业数据上报
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	public void delete(List<Integer> req) throws Exception;
	
   /**
	 * Desc:查导出列表
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	public List<EnterpriseReport> queryExport(EnterpriseReportReq req) throws Exception;
}
