package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Forecast;
import cn.com.yuanwei.center.web.request.ForecastReq;
import cn.com.yuanwei.center.web.response.ForecastLtResp;
/**
 * 总量预测结果表
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:45
 */
public interface ForecastService {
   /**
	 * Desc:查询总量预测结果表
	 * @author zbk
	 * @date 2017-04-24 10:29:45
	 */
	public Forecast queryById(Integer id) throws Exception;
   /**
	 * Desc:查询总量预测结果表列表
	 * @author zbk
	 * @date 2017-04-24 10:29:45
	 */
	public ForecastLtResp queryList(ForecastReq req) throws Exception;
   /**
	 * Desc:新增总量预测结果表
	 * @author zbk
	 * @date 2017-04-24 10:29:45
	 */
	public void save(Forecast forecast) throws Exception;
	/**
	 * Desc:更新总量预测结果表
	 * @author zbk
	 * @date 2017-04-24 10:29:45
	 */
	public void update(Forecast forecast) throws Exception;
	/**
	 * Desc:删除总量预测结果表
	 * @author zbk
	 * @date 2017-04-24 10:29:45
	 */
	public void delete(List<Integer> req) throws Exception;
	
   /**
	 * Desc:计算总量预测结果
	 * @author zbk
	 * @date 2017-04-24 10:29:45
	 */
	public ForecastLtResp calc(ForecastReq req) throws Exception;
}
