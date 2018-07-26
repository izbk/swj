package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianScoringRecord;
import cn.com.yuanwei.center.web.request.StatisticianReportPointReq;
import cn.com.yuanwei.center.web.request.StatisticianScoringRecordReq;
import cn.com.yuanwei.center.web.response.StatisticianReportPointLtResp;
import cn.com.yuanwei.center.web.response.StatisticianScoringRecordLtResp;
/**
 * 统计员得分记录
 * 
 * @author zbk
 * @email 
 * @date 2017-06-19 11:52:16
 */
public interface StatisticianScoringRecordService {
   /**
	 * Desc:查询统计员得分记录
	 * @param Integer id
	 * @return  StatisticianScoringRecord
	 * @author zbk
	 * @date 2017-06-19 11:52:16
	 */
	public StatisticianScoringRecord queryById(Integer id) throws Exception;
   /**
	 * Desc:查询统计员得分记录列表
	 * @param StatisticianScoringRecordReq req
	 * @return StatisticianScoringRecordLtResp
	 * @author zbk
	 * @date 2017-06-19 11:52:16
	 */
	public StatisticianScoringRecordLtResp queryList(StatisticianScoringRecordReq req) throws Exception;
   /**
	 * Desc:新增统计员得分记录
	 * @param StatisticianScoringRecord statisticianScoringRecord
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-19 11:52:16
	 */
	public Integer save(StatisticianScoringRecord statisticianScoringRecord) throws Exception;
	/**
	 * Desc:更新统计员得分记录
	 * @param StatisticianScoringRecord statisticianScoringRecord
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-19 11:52:16
	 */
	public Integer update(StatisticianScoringRecord statisticianScoringRecord) throws Exception;
	/**
	 * Desc:删除统计员得分记录
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-19 11:52:16
	 */
	public Integer delete(List<Integer> req) throws Exception;
	/**
	 * 查询考核记录
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public StatisticianReportPointLtResp queryList(StatisticianReportPointReq req) throws Exception;
}
