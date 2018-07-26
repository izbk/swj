package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianAssessment;
import cn.com.yuanwei.center.web.request.StatisticianAssessmentReq;
import cn.com.yuanwei.center.web.response.StatisticianAssessmentLtResp;
/**
 * 统计员任务考核
 * 
 * @author zbk
 * @email 
 * @date 2017-06-15 15:17:36
 */
public interface StatisticianAssessmentService {
   /**
	 * Desc:查询统计员任务考核
	 * @param Integer id
	 * @return  StatisticianAssessment
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public StatisticianAssessment queryById(Integer id) throws Exception;
   /**
	 * Desc:查询统计员任务考核列表
	 * @param StatisticianAssessmentReq req
	 * @return StatisticianAssessmentLtResp
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public StatisticianAssessmentLtResp queryList(StatisticianAssessmentReq req) throws Exception;
   /**
	 * Desc:新增统计员任务考核
	 * @param StatisticianAssessment statisticianAssessment
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer save(StatisticianAssessmentReq req) throws Exception;
	/**
	 * Desc:更新统计员任务考核
	 * @param StatisticianAssessment statisticianAssessment
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer update(StatisticianAssessment statisticianAssessment) throws Exception;
	/**
	 * Desc:删除统计员任务考核
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
