package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.TownshipAnnualDone;
import cn.com.yuanwei.center.web.request.TownshipAnnualDoneReq;
import cn.com.yuanwei.center.web.response.TownshipAnnualDoneLtResp;
/**
 * 镇乡年度任务完成情况
 * 
 * @author zbk
 * @email 
 * @date 2017-06-15 15:17:36
 */
public interface TownshipAnnualDoneService {
   /**
	 * Desc:查询镇乡年度任务完成情况
	 * @param Integer id
	 * @return  TownshipAnnualDone
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public TownshipAnnualDone queryById(Integer id) throws Exception;
   /**
	 * Desc:查询镇乡年度任务完成情况列表
	 * @param TownshipAnnualDoneReq req
	 * @return TownshipAnnualDoneLtResp
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public TownshipAnnualDoneLtResp queryList(TownshipAnnualDoneReq req) throws Exception;
   /**
	 * Desc:新增镇乡年度任务完成情况
	 * @param TownshipAnnualDone townshipAnnualDone
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer save(TownshipAnnualDone townshipAnnualDone) throws Exception;
	/**
	 * Desc:更新镇乡年度任务完成情况
	 * @param TownshipAnnualDone townshipAnnualDone
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer update(TownshipAnnualDone townshipAnnualDone) throws Exception;
	/**
	 * Desc:删除镇乡年度任务完成情况
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
