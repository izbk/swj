package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Company;
import cn.com.yuanwei.center.web.request.CompanyReq;
import cn.com.yuanwei.center.web.response.CompanyLtResp;
/**
 * 企业信息表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-01 17:42:25
 */
public interface CompanyService {
   /**
	 * Desc:查询企业信息表
	 * @param Integer id
	 * @return  Company
	 * @author zbk
	 * @date 2017-06-01 17:42:25
	 */
	public Company queryById(Integer id) throws Exception;
   /**
	 * Desc:查询企业信息表列表
	 * @param CompanyReq req
	 * @return CompanyLtResp
	 * @author zbk
	 * @date 2017-06-01 17:42:25
	 */
	public CompanyLtResp queryList(CompanyReq req) throws Exception;
   /**
	 * Desc:新增企业信息表
	 * @param Company company
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-01 17:42:25
	 */
	public Integer save(Company company) throws Exception;
	/**
	 * Desc:更新企业信息表
	 * @param Company company
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-01 17:42:25
	 */
	public Integer update(Company company) throws Exception;
	/**
	 * Desc:删除企业信息表
	 * @param List<Integer> ids
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-01 17:42:25
	 */
	public Integer delete(List<Integer> ids) throws Exception;
}
