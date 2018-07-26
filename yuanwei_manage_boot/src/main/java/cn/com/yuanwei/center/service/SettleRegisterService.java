package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.SettleRegister;
import cn.com.yuanwei.center.web.request.SettleRegisterReq;
import cn.com.yuanwei.center.web.response.SettleRegisterLtResp;
/**
 * 入园申请登记表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-26 17:15:27
 */
public interface SettleRegisterService {
   /**
	 * Desc:查询入园申请登记表
	 * @param Integer id
	 * @return  SettleRegister
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public SettleRegister queryById(Integer id) throws Exception;
   /**
	 * Desc:查询入园申请登记表列表
	 * @param SettleRegisterReq req
	 * @return SettleRegisterLtResp
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public SettleRegisterLtResp queryList(SettleRegisterReq req) throws Exception;
   /**
	 * Desc:新增入园申请登记表
	 * @param SettleRegister settleRegister
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer save(SettleRegister settleRegister) throws Exception;
	/**
	 * Desc:更新入园申请登记表
	 * @param SettleRegister settleRegister
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer update(SettleRegister settleRegister) throws Exception;
	/**
	 * Desc:删除入园申请登记表
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
