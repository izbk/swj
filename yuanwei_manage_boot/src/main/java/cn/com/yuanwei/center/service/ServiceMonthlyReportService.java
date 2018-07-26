package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.ServiceMonthlyReport;
import cn.com.yuanwei.center.web.request.ServiceMonthlyReportReq;
import cn.com.yuanwei.center.web.response.ServiceMonthlyReportLtResp;
/**
 * 服务业企业数据月报
 * 
 * @author zbk
 * @email 
 * @date 2017-06-07 11:55:52
 */
public interface ServiceMonthlyReportService {
   /**
	 * Desc:查询服务业企业数据月报
	 * @param Integer id
	 * @return  ServiceMonthlyReport
	 * @author zbk
	 * @date 2017-06-07 11:55:52
	 */
	public ServiceMonthlyReport queryById(Integer id) throws Exception;
   /**
	 * Desc:查询服务业企业数据月报列表
	 * @param ServiceMonthlyReportReq req
	 * @return ServiceMonthlyReportLtResp
	 * @author zbk
	 * @date 2017-06-07 11:55:52
	 */
	public ServiceMonthlyReportLtResp queryList(ServiceMonthlyReportReq req) throws Exception;
   /**
	 * Desc:新增服务业企业数据月报
	 * @param ServiceMonthlyReport serviceMonthlyReport
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-07 11:55:52
	 */
	public Integer save(ServiceMonthlyReport serviceMonthlyReport) throws Exception;
	/**
	 * Desc:更新服务业企业数据月报
	 * @param ServiceMonthlyReport serviceMonthlyReport
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-07 11:55:52
	 */
	public Integer update(ServiceMonthlyReport serviceMonthlyReport) throws Exception;
	/**
	 * Desc:删除服务业企业数据月报
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-07 11:55:52
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
