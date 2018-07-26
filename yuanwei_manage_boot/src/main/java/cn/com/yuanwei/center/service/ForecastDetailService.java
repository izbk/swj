package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.ForecastDetail;
import cn.com.yuanwei.center.web.request.ForecastDetailReq;
import cn.com.yuanwei.center.web.response.ForecastDetailLtResp;
/**
 * 企业预测结果表
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:28:06
 */
public interface ForecastDetailService {
   /**
	 * Desc:查询企业预测结果表
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	public ForecastDetail queryById(Integer id) throws Exception;
   /**
	 * Desc:查询企业预测结果表列表
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	public ForecastDetailLtResp queryList(ForecastDetailReq req) throws Exception;
   /**
	 * Desc:新增企业预测结果表
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	public void save(ForecastDetail forecastDetail) throws Exception;
	/**
	 * Desc:更新企业预测结果表
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	public void update(ForecastDetail forecastDetail) throws Exception;
	/**
	 * Desc:删除企业预测结果表
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	public void delete(List<Integer> req) throws Exception;
	
   /**
	 * Desc:计算企业预测结果表
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	public ForecastDetailLtResp calc(ForecastDetailReq req) throws Exception;
	/**
	 * Desc:计算企业预测结果表
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	public ForecastDetailLtResp calc2(ForecastDetailReq req) throws Exception;
   /**
	 * Desc:批量新增企业预测结果表
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	public void batchSave(List<ForecastDetail> list) throws Exception;	
}
