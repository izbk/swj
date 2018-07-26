package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.RealReport;
import cn.com.yuanwei.center.web.request.RealReportReq;
import cn.com.yuanwei.center.web.response.RealReportLtResp;
/**
 * 统计局导出表
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:22
 */
public interface RealReportService {
   /**
	 * Desc:查询统计局导出表
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public RealReport queryById(Integer id) throws Exception;
   /**
	 * Desc:查询统计局导出表列表
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public RealReportLtResp queryList(RealReportReq req) throws Exception;
   /**
	 * Desc:新增统计局导出表
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public void save(RealReport realReport) throws Exception;
	/**
	 * Desc:更新统计局导出表
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public void update(RealReport realReport) throws Exception;
	/**
	 * Desc:删除统计局导出表
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public void delete(List<Integer> req) throws Exception;
	
   /**
	 * Desc:批量新增统计局导出表
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public void batchSave(List<RealReport> list) throws Exception;
   /**
	 * Desc:批量删除
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public Integer batchDelete(RealReportReq req) throws Exception;
}
