package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.IncubationParkCompany;
import cn.com.yuanwei.center.web.request.IncubationParkCompanyReq;
import cn.com.yuanwei.center.web.response.IncubationParkCompanyLtResp;
/**
 * 孵化园企业信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 17:26:50
 */
public interface IncubationParkCompanyService {
   /**
	 * Desc:查询孵化园企业信息
	 * @param Integer id
	 * @return  IncubationParkCompany
	 * @author zbk
	 * @date 2017-07-04 17:26:50
	 */
	public IncubationParkCompany queryById(Integer id) throws Exception;
   /**
	 * Desc:查询孵化园企业信息列表
	 * @param IncubationParkCompanyReq req
	 * @return IncubationParkCompanyLtResp
	 * @author zbk
	 * @date 2017-07-04 17:26:50
	 */
	public IncubationParkCompanyLtResp queryList(IncubationParkCompanyReq req) throws Exception;
   /**
	 * Desc:新增孵化园企业信息
	 * @param IncubationParkCompany incubationParkCompany
	 * @return Integer id
	 * @author zbk
	 * @date 2017-07-04 17:26:50
	 */
	public Integer save(IncubationParkCompany incubationParkCompany) throws Exception;
	/**
	 * Desc:更新孵化园企业信息
	 * @param IncubationParkCompany incubationParkCompany
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-04 17:26:50
	 */
	public Integer update(IncubationParkCompany incubationParkCompany) throws Exception;
	/**
	 * Desc:删除孵化园企业信息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-04 17:26:50
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
