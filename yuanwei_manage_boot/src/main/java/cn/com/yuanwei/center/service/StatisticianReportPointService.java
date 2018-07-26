package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.StatisticianReportPoint;
import cn.com.yuanwei.center.web.request.StatisticianReportPointReq;
import cn.com.yuanwei.center.web.response.StatisticianReportPointLtResp;
/**
 * 统计员直报考核记录表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-20 16:57:34
 */
public interface StatisticianReportPointService {
   /**
	 * Desc:查询统计员直报考核记录表
	 * @param Integer id
	 * @return  StatisticianReportPoint
	 * @author zbk
	 * @date 2017-06-20 16:57:34
	 */
	public StatisticianReportPoint queryById(Integer id) throws Exception;
   /**
	 * Desc:查询统计员直报考核记录表列表
	 * @param StatisticianReportPointReq req
	 * @return StatisticianReportPointLtResp
	 * @author zbk
	 * @date 2017-06-20 16:57:34
	 */
	public StatisticianReportPointLtResp queryList(StatisticianReportPointReq req) throws Exception;
   /**
	 * Desc:新增统计员直报考核记录表
	 * @param StatisticianReportPoint statisticianReportPoint
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-20 16:57:34
	 */
	public Integer save(StatisticianReportPoint statisticianReportPoint) throws Exception;
	/**
	 * Desc:更新统计员直报考核记录表
	 * @param StatisticianReportPoint statisticianReportPoint
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-20 16:57:34
	 */
	public Integer update(StatisticianReportPoint statisticianReportPoint) throws Exception;
	/**
	 * Desc:删除统计员直报考核记录表
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-20 16:57:34
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
