package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.TotalReport;
import cn.com.yuanwei.center.web.request.TotalReportReq;
import cn.com.yuanwei.center.web.response.TotalReportLtResp;
/**
 * 总量数据表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-01 15:57:22
 */
public interface TotalReportService {
   /**
	 * Desc:查询总量数据表
	 * @param Integer id
	 * @return  TotalReport
	 * @author zbk
	 * @date 2017-06-01 15:57:22
	 */
	public TotalReport queryById(Integer id) throws Exception;
   /**
	 * Desc:查询总量数据表列表
	 * @param TotalReportReq req
	 * @return TotalReportLtResp
	 * @author zbk
	 * @date 2017-06-01 15:57:22
	 */
	public TotalReportLtResp queryList(TotalReportReq req) throws Exception;
   /**
	 * Desc:新增总量数据表
	 * @param TotalReport totalReport
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-01 15:57:22
	 */
	public Integer save(TotalReport totalReport) throws Exception;
	/**
	 * Desc:更新总量数据表
	 * @param TotalReport totalReport
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-01 15:57:22
	 */
	public Integer update(TotalReport totalReport) throws Exception;
	/**
	 * Desc:删除总量数据表
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-01 15:57:22
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
