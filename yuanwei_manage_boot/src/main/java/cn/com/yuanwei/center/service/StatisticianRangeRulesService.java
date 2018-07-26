package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianRangeRules;
import cn.com.yuanwei.center.web.request.StatisticianRangeRulesReq;
import cn.com.yuanwei.center.web.response.StatisticianRangeRulesLtResp;
/**
 * 统计员排位得分规则
 * 
 * @author zbk
 * @email 
 * @date 2017-06-19 11:58:18
 */
public interface StatisticianRangeRulesService {
   /**
	 * Desc:查询统计员排位得分规则
	 * @param Integer id
	 * @return  StatisticianRangeRules
	 * @author zbk
	 * @date 2017-06-19 11:58:18
	 */
	public StatisticianRangeRules queryById(Integer id) throws Exception;
   /**
	 * Desc:查询统计员排位得分规则列表
	 * @param StatisticianRangeRulesReq req
	 * @return StatisticianRangeRulesLtResp
	 * @author zbk
	 * @date 2017-06-19 11:58:18
	 */
	public StatisticianRangeRulesLtResp queryList(StatisticianRangeRulesReq req) throws Exception;
   /**
	 * Desc:新增统计员排位得分规则
	 * @param StatisticianRangeRules statisticianRangeRules
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-19 11:58:18
	 */
	public Integer save(StatisticianRangeRules statisticianRangeRules) throws Exception;
	/**
	 * Desc:更新统计员排位得分规则
	 * @param StatisticianRangeRules statisticianRangeRules
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-19 11:58:18
	 */
	public Integer update(StatisticianRangeRules statisticianRangeRules) throws Exception;
	/**
	 * Desc:删除统计员排位得分规则
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-19 11:58:18
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
