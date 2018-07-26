package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.ServiceDefine;
import cn.com.yuanwei.center.web.request.ServiceDefineReq;
import cn.com.yuanwei.center.web.response.ServiceDefineLtResp;
/**
 * 服务业企业数据定义
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:44
 */
public interface ServiceDefineService {
   /**
	 * Desc:查询服务业企业数据定义
	 * @author zbk
	 * @date 2017-04-24 10:29:44
	 */
	public ServiceDefine queryById(Integer id) throws Exception;
   /**
	 * Desc:查询服务业企业数据定义列表
	 * @author zbk
	 * @date 2017-04-24 10:29:44
	 */
	public ServiceDefineLtResp queryList(ServiceDefineReq req) throws Exception;
   /**
	 * Desc:新增服务业企业数据定义
	 * @author zbk
	 * @date 2017-04-24 10:29:44
	 */
	public void save(ServiceDefine serviceDefine) throws Exception;
	/**
	 * Desc:更新服务业企业数据定义
	 * @author zbk
	 * @date 2017-04-24 10:29:44
	 */
	public void update(ServiceDefine serviceDefine) throws Exception;
	/**
	 * Desc:删除服务业企业数据定义
	 * @author zbk
	 * @date 2017-04-24 10:29:44
	 */
	public void delete(List<Integer> req) throws Exception;
}
