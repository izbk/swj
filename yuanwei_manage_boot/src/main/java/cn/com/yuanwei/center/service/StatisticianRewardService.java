package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianReward;
import cn.com.yuanwei.center.web.request.StatisticianRewardReq;
import cn.com.yuanwei.center.web.response.StatisticianRewardLtResp;
/**
 * 统计员补助金额信息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-15 15:17:36
 */
public interface StatisticianRewardService {
   /**
	 * Desc:查询统计员补助金额信息
	 * @param Integer id
	 * @return  StatisticianReward
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public StatisticianReward queryById(Integer id) throws Exception;
   /**
	 * Desc:查询统计员补助金额信息列表
	 * @param StatisticianRewardReq req
	 * @return StatisticianRewardLtResp
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public StatisticianRewardLtResp queryList(StatisticianRewardReq req) throws Exception;
   /**
	 * Desc:新增统计员补助金额信息
	 * @param StatisticianReward statisticianReward
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer save(StatisticianReward statisticianReward) throws Exception;
	/**
	 * Desc:更新统计员补助金额信息
	 * @param StatisticianReward statisticianReward
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer update(StatisticianReward statisticianReward) throws Exception;
	/**
	 * Desc:删除统计员补助金额信息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
