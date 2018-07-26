package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.IncubationParkRegister;
import cn.com.yuanwei.center.web.request.IncubationParkRegisterReq;
import cn.com.yuanwei.center.web.response.IncubationParkRegisterLtResp;
/**
 * 孵化园申请登记信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-03 17:59:11
 */
public interface IncubationParkRegisterService {
   /**
	 * Desc:查询孵化园申请登记信息
	 * @param Integer id
	 * @return  IncubationParkRegister
	 * @author zbk
	 * @date 2017-07-03 17:59:11
	 */
	public IncubationParkRegister queryById(Integer id) throws Exception;
   /**
	 * Desc:查询孵化园申请登记信息列表
	 * @param IncubationParkRegisterReq req
	 * @return IncubationParkRegisterLtResp
	 * @author zbk
	 * @date 2017-07-03 17:59:11
	 */
	public IncubationParkRegisterLtResp queryList(IncubationParkRegisterReq req) throws Exception;
   /**
	 * Desc:新增孵化园申请登记信息
	 * @param IncubationParkRegister incubationParkRegister
	 * @return Integer id
	 * @author zbk
	 * @date 2017-07-03 17:59:11
	 */
	public Integer save(IncubationParkRegister incubationParkRegister) throws Exception;
	/**
	 * Desc:更新孵化园申请登记信息
	 * @param IncubationParkRegister incubationParkRegister
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-03 17:59:11
	 */
	public Integer update(IncubationParkRegister incubationParkRegister) throws Exception;
	/**
	 * Desc:删除孵化园申请登记信息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-03 17:59:11
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
