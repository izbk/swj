package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.EnterpriseManage;
import cn.com.yuanwei.center.web.request.EnterpriseManageReq;
import cn.com.yuanwei.center.web.response.EnterpriseManageLtResp;
/**
 * 企业进退库管理表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-26 17:15:27
 */
public interface EnterpriseManageService {
   /**
	 * Desc:查询企业进退库管理表
	 * @param Integer id
	 * @return  EnterpriseManage
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public EnterpriseManage queryById(Integer id) throws Exception;
   /**
	 * Desc:查询企业进退库管理表列表
	 * @param EnterpriseManageReq req
	 * @return EnterpriseManageLtResp
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public EnterpriseManageLtResp queryList(EnterpriseManageReq req) throws Exception;
   /**
	 * Desc:新增企业进退库管理表
	 * @param EnterpriseManage enterpriseManage
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer save(EnterpriseManage enterpriseManage) throws Exception;
	/**
	 * Desc:更新企业进退库管理表
	 * @param EnterpriseManage enterpriseManage
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer update(EnterpriseManage enterpriseManage) throws Exception;
	/**
	 * Desc:删除企业进退库管理表
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
