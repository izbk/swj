package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Enterprise;
import cn.com.yuanwei.center.web.request.EnterpriseReq;
import cn.com.yuanwei.center.web.response.EnterpriseLtResp;
/**
 * 限上企业信息表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-16 14:55:57
 */
public interface EnterpriseService {
   /**
	 * Desc:查询限上企业信息表
	 * @param Integer id
	 * @return  Enterprise
	 * @author zbk
	 * @date 2017-06-16 14:55:57
	 */
	public Enterprise queryById(Integer id) throws Exception;
   /**
	 * Desc:查询限上企业信息表列表
	 * @param EnterpriseReq req
	 * @return EnterpriseLtResp
	 * @author zbk
	 * @date 2017-06-16 14:55:57
	 */
	public EnterpriseLtResp queryList(EnterpriseReq req) throws Exception;
   /**
	 * Desc:新增限上企业信息表
	 * @param Enterprise enterprise
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-16 14:55:57
	 */
	public Integer save(Enterprise enterprise) throws Exception;
	/**
	 * Desc:更新限上企业信息表
	 * @param Enterprise enterprise
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-16 14:55:57
	 */
	public Integer update(Enterprise enterprise) throws Exception;
	/**
	 * Desc:删除限上企业信息表
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-16 14:55:57
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
