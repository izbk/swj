package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.AuditConfig;
import cn.com.yuanwei.center.web.request.AuditConfigReq;
import cn.com.yuanwei.center.web.response.AuditConfigLtResp;
/**
 * 审核配置
 * 
 * @author zbk
 * @email 
 * @date 2017-06-26 17:15:27
 */
public interface AuditConfigService {
   /**
	 * Desc:查询审核配置
	 * @param Integer id
	 * @return  AuditConfig
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public AuditConfig queryById(Integer id) throws Exception;
   /**
	 * Desc:查询审核配置列表
	 * @param AuditConfigReq req
	 * @return AuditConfigLtResp
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public AuditConfigLtResp queryList(AuditConfigReq req) throws Exception;
   /**
	 * Desc:新增审核配置
	 * @param AuditConfig auditConfig
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer save(AuditConfig auditConfig) throws Exception;
	/**
	 * Desc:更新审核配置
	 * @param AuditConfig auditConfig
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer update(AuditConfig auditConfig) throws Exception;
	/**
	 * Desc:删除审核配置
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
