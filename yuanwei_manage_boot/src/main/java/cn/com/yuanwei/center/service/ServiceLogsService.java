package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.web.request.ServiceLogsReq;
import cn.com.yuanwei.center.web.response.ServiceLogsLtResp;
/**
 * 系统日志
 * 
 * @author zbk
 * @email 
 * @date 2017-06-22 10:57:25
 */
public interface ServiceLogsService {
   /**
	 * Desc:查询系统日志
	 * @param Integer id
	 * @return  ServiceLogs
	 * @author zbk
	 * @date 2017-06-22 10:57:25
	 */
	public ServiceLogs queryById(Integer id) throws Exception;
   /**
	 * Desc:查询系统日志列表
	 * @param ServiceLogsReq req
	 * @return ServiceLogsLtResp
	 * @author zbk
	 * @date 2017-06-22 10:57:25
	 */
	public ServiceLogsLtResp queryList(ServiceLogsReq req) throws Exception;
   /**
	 * Desc:新增系统日志
	 * @param ServiceLogs serviceLogs
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-22 10:57:25
	 */
	public Integer save(ServiceLogs serviceLogs) throws Exception;
	/**
	 * Desc:更新系统日志
	 * @param ServiceLogs serviceLogs
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-22 10:57:25
	 */
	public Integer update(ServiceLogs serviceLogs) throws Exception;
	/**
	 * Desc:删除系统日志
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-22 10:57:25
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
