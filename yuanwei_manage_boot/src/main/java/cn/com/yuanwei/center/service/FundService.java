package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Fund;
import cn.com.yuanwei.center.web.request.FundReq;
import cn.com.yuanwei.center.web.response.FundLtResp;
import cn.com.yuanwei.center.web.response.FundResp;
/**
 * 项目资金信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 11:03:17
 */
public interface FundService {
   /**
	 * Desc:查询项目资金信息
	 * @param Integer id
	 * @return  Fund
	 * @author zbk
	 * @date 2017-07-04 11:03:17
	 */
	public Fund queryById(Integer id) throws Exception;
   /**
	 * Desc:查询项目资金信息列表
	 * @param FundReq req
	 * @return FundLtResp
	 * @author zbk
	 * @date 2017-07-04 11:03:17
	 */
	public FundLtResp queryList(FundReq req) throws Exception;
	/**
	 * Desc:查询项目资金信息树形列表
	 * @param FundReq req
	 * @return List<FundResp>
	 * @author zbk
	 * @date 2017-07-04 11:03:17
	 */
	public List<FundResp> queryAllList(FundReq req) throws Exception;
   /**
	 * Desc:新增项目资金信息
	 * @param Fund fund
	 * @return Integer id
	 * @author zbk
	 * @date 2017-07-04 11:03:17
	 */
	public Integer save(Fund fund) throws Exception;
	/**
	 * Desc:更新项目资金信息
	 * @param Fund fund
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-04 11:03:17
	 */
	public Integer update(Fund fund) throws Exception;
	/**
	 * Desc:删除项目资金信息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-04 11:03:17
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
