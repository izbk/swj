package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianScoringRules;
import cn.com.yuanwei.center.web.request.StatisticianScoringRulesReq;
import cn.com.yuanwei.center.web.response.StatisticianScoringRulesLtResp;
/**
 * 统计员计分细则
 * 
 * @author zbk
 * @email 
 * @date 2017-06-15 15:17:36
 */
public interface StatisticianScoringRulesService {
   /**
	 * Desc:查询统计员计分细则
	 * @param Integer id
	 * @return  StatisticianScoringRules
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public StatisticianScoringRules queryById(Integer id) throws Exception;
   /**
	 * Desc:查询统计员计分细则列表
	 * @param StatisticianScoringRulesReq req
	 * @return StatisticianScoringRulesLtResp
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public StatisticianScoringRulesLtResp queryList(StatisticianScoringRulesReq req) throws Exception;
   /**
	 * Desc:新增统计员计分细则
	 * @param StatisticianScoringRules statisticianScoringRules
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer save(StatisticianScoringRules statisticianScoringRules) throws Exception;
	/**
	 * Desc:更新统计员计分细则
	 * @param StatisticianScoringRules statisticianScoringRules
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer update(StatisticianScoringRules statisticianScoringRules) throws Exception;
	/**
	 * Desc:删除统计员计分细则
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
