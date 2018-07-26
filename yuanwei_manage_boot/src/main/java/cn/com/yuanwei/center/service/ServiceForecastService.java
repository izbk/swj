package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.ServiceForecast;
import cn.com.yuanwei.center.web.request.ServiceForecastReq;
import cn.com.yuanwei.center.web.response.ServiceForecastLtResp;
/**
 * 服务业企业数据预测
 * 
 * @author zbk
 * @email 
 * @date 2017-06-09 10:02:26
 */
public interface ServiceForecastService {
   /**
	 * Desc:查询服务业企业数据预测
	 * @param Integer id
	 * @return  ServiceForecast
	 * @author zbk
	 * @date 2017-06-09 10:02:26
	 */
	public ServiceForecast queryById(Integer id) throws Exception;
   /**
	 * Desc:查询服务业企业数据预测列表
	 * @param ServiceForecastReq req
	 * @return ServiceForecastLtResp
	 * @author zbk
	 * @date 2017-06-09 10:02:26
	 */
	public ServiceForecastLtResp queryList(ServiceForecastReq req) throws Exception;
   /**
	 * Desc:新增服务业企业数据预测
	 * @param ServiceForecast serviceForecast
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-09 10:02:26
	 */
	public Integer save(ServiceForecast serviceForecast) throws Exception;
	/**
	 * Desc:更新服务业企业数据预测
	 * @param ServiceForecast serviceForecast
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-09 10:02:26
	 */
	public Integer update(ServiceForecast serviceForecast) throws Exception;
	/**
	 * Desc:删除服务业企业数据预测
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-09 10:02:26
	 */
	public Integer delete(List<Integer> req) throws Exception;
   /**
	 * Desc:查询导出数据
	 * @param ServiceForecastReq req
	 * @return ServiceForecastLtResp
	 * @author zbk
	 * @date 2017-06-09 10:02:26
	 */
	public ServiceForecastLtResp queryExport(ServiceForecastReq req) throws Exception;
}
