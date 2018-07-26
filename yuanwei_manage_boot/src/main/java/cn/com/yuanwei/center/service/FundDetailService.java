package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.FundDetail;
import cn.com.yuanwei.center.web.request.FundDetailReq;
import cn.com.yuanwei.center.web.response.FundDetailLtResp;
/**
 * 项目资金拨付信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 11:03:17
 */
public interface FundDetailService {
   /**
	 * Desc:查询项目资金拨付信息
	 * @param Integer id
	 * @return  FundDetail
	 * @author zbk
	 * @date 2017-07-04 11:03:17
	 */
	public FundDetail queryById(Integer id) throws Exception;
   /**
	 * Desc:查询项目资金拨付信息列表
	 * @param FundDetailReq req
	 * @return FundDetailLtResp
	 * @author zbk
	 * @date 2017-07-04 11:03:17
	 */
	public FundDetailLtResp queryList(FundDetailReq req) throws Exception;
   /**
	 * Desc:新增项目资金拨付信息
	 * @param FundDetail fundDetail
	 * @return Integer id
	 * @author zbk
	 * @date 2017-07-04 11:03:17
	 */
	public Integer save(FundDetail fundDetail) throws Exception;
	/**
	 * Desc:更新项目资金拨付信息
	 * @param FundDetail fundDetail
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-04 11:03:17
	 */
	public Integer update(FundDetail fundDetail) throws Exception;
	/**
	 * Desc:删除项目资金拨付信息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-04 11:03:17
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
