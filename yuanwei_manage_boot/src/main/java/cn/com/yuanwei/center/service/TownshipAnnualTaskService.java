package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.TownshipAnnualTask;
import cn.com.yuanwei.center.web.request.TownshipAnnualTaskReq;
import cn.com.yuanwei.center.web.response.TownshipAnnualTaskLtResp;
/**
 * 镇乡年度目标任务表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-15 15:17:36
 */
public interface TownshipAnnualTaskService {
   /**
	 * Desc:查询镇乡年度目标任务表
	 * @param Integer id
	 * @return  TownshipAnnualTask
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public TownshipAnnualTask queryById(Integer id) throws Exception;
   /**
	 * Desc:查询镇乡年度目标任务表列表
	 * @param TownshipAnnualTaskReq req
	 * @return TownshipAnnualTaskLtResp
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public TownshipAnnualTaskLtResp queryList(TownshipAnnualTaskReq req) throws Exception;
   /**
	 * Desc:新增镇乡年度目标任务表
	 * @param TownshipAnnualTask townshipAnnualTask
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer save(TownshipAnnualTask townshipAnnualTask) throws Exception;
	/**
	 * Desc:更新镇乡年度目标任务表
	 * @param TownshipAnnualTask townshipAnnualTask
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer update(TownshipAnnualTask townshipAnnualTask) throws Exception;
	/**
	 * Desc:删除镇乡年度目标任务表
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
