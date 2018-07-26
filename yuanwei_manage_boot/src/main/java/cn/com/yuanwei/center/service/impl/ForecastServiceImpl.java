package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.Forecast;
import cn.com.yuanwei.center.entity.ForecastDetailExample;
import cn.com.yuanwei.center.entity.ForecastExample;
import cn.com.yuanwei.center.entity.ForecastExample.Criteria;
import cn.com.yuanwei.center.entity.RealReportVo;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.TotalReport;
import cn.com.yuanwei.center.entity.TotalReportExample;
import cn.com.yuanwei.center.mapper.ForecastDetailMapper;
import cn.com.yuanwei.center.mapper.ForecastMapper;
import cn.com.yuanwei.center.mapper.RealReportMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.TotalReportMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.ForecastDetailService;
import cn.com.yuanwei.center.service.ForecastService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ForecastDetailReq;
import cn.com.yuanwei.center.web.request.ForecastReq;
import cn.com.yuanwei.center.web.response.ForecastLtResp;

@Service
@Transactional
public class ForecastServiceImpl implements ForecastService {
	@Autowired
	private ForecastMapper forecastMapper;
	@Autowired
	private ForecastDetailMapper forecastDetailMapper;
	@Autowired
	private RealReportMapper realReportMapper;
	@Autowired
	private TotalReportMapper totalReportMapper;
	@Autowired
	ForecastDetailService forecastDetailService;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public void save(Forecast forecast) throws Exception {
		Integer year = forecast.getYear();
		Integer month = forecast.getMonth();
		if(year == null || year.compareTo(0) <= 0){
			throw new Exception("年度数据错误");
		}
		if(month == null || month.compareTo(0) <= 0){
			throw new Exception("月份数据错误");
		}
		//删除当月数据
		ForecastExample de=new ForecastExample();
		de.createCriteria().andYearEqualTo(year).andMonthEqualTo(month);
		forecastMapper.deleteByExample(de);
		//保存总量数据
		forecastMapper.insert(forecast);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),forecast.getId(), "新增总量预测"));
		//保存预测明细数据
		ForecastDetailReq req = new ForecastDetailReq();
		req.setYear(year);
		req.setMonth(month);
		forecastDetailService.calc(req);
	}

	@Override
	public void update(Forecast forecast) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),forecast.getId(), "更新总量预测"));
		forecastMapper.updateByPrimaryKey(forecast);
		//保存预测明细数据
		ForecastDetailReq req = new ForecastDetailReq();
		req.setYear(forecast.getYear());
		req.setMonth(forecast.getMonth());
		forecastDetailService.calc(req);
	}

	@Override
	public void delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除总量预测"));
		}
		//删除明细
		for (Integer id : ids) {
			Forecast forecast = forecastMapper.selectByPrimaryKey(id);
			ForecastDetailExample example = new ForecastDetailExample();
			example.createCriteria().andYearEqualTo(forecast.getYear()).andMonthEqualTo(forecast.getMonth());
			forecastDetailMapper.deleteByExample(example);
		}
		//删除总量
		ForecastExample de=new ForecastExample();
		de.createCriteria().andIdIn(ids);
		forecastMapper.deleteByExample(de);
	}
	
	@Override
	public Forecast queryById(Integer id){
		return forecastMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ForecastLtResp queryList(ForecastReq req) throws Exception {
		Integer id = req.getId();
		Integer year = req.getYear();
		Integer month = req.getMonth();
		BigDecimal lastAdd = req.getLastAdd();
		BigDecimal lastAmount = req.getLastAmount();
		BigDecimal currRise = req.getCurrRise();
		BigDecimal currUnderRise = req.getCurrUnderRise();
		BigDecimal currMonthAmount = req.getCurrMonthAmount();
		BigDecimal currMonth = req.getCurrMonth();
		BigDecimal currAmountRise = req.getCurrAmountRise();
		BigDecimal currAmount = req.getCurrAmount();
		BigDecimal lastRatio = req.getLastRatio();
		BigDecimal lastUnderRatio = req.getLastUnderRatio();
		BigDecimal lastNoAdjust = req.getLastNoAdjust();
		BigDecimal lastAdjusted = req.getLastAdjusted();
		ForecastExample de=new ForecastExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(month)){
			c.andMonthEqualTo(month);
		}
		if(!ValidateUtil.isEmpty(lastAdd)){
			c.andLastAddEqualTo(lastAdd);
		}
		if(!ValidateUtil.isEmpty(lastAmount)){
			c.andLastAmountEqualTo(lastAmount);
		}
		if(!ValidateUtil.isEmpty(currRise)){
			c.andCurrRiseEqualTo(currRise);
		}
		if(!ValidateUtil.isEmpty(currUnderRise)){
			c.andCurrUnderRiseEqualTo(currUnderRise);
		}
		if(!ValidateUtil.isEmpty(currMonthAmount)){
			c.andCurrMonthAmountEqualTo(currMonthAmount);
		}
		if(!ValidateUtil.isEmpty(currMonth)){
			c.andCurrMonthEqualTo(currMonth);
		}
		if(!ValidateUtil.isEmpty(currAmountRise)){
			c.andCurrAmountRiseEqualTo(currAmountRise);
		}
		if(!ValidateUtil.isEmpty(currAmount)){
			c.andCurrAmountEqualTo(currAmount);
		}
		if(!ValidateUtil.isEmpty(lastRatio)){
			c.andLastRatioEqualTo(lastRatio);
		}
		if(!ValidateUtil.isEmpty(lastUnderRatio)){
			c.andLastUnderRatioEqualTo(lastUnderRatio);
		}
		if(!ValidateUtil.isEmpty(lastNoAdjust)){
			c.andLastNoAdjustEqualTo(lastNoAdjust);
		}
		if(!ValidateUtil.isEmpty(lastAdjusted)){
			c.andLastAdjustedEqualTo(lastAdjusted);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Forecast> page = (Page<Forecast>) forecastMapper.selectByExample(de);
		ForecastLtResp resp = new ForecastLtResp();
		resp.setCount(page.getTotal());
		resp.setForecastLt(page.getResult());
		return resp;
	}

	@Override
	public ForecastLtResp calc(ForecastReq req) throws Exception {
		/*
		 * 公用参数
		 */
		BigDecimal zero = new BigDecimal("0");
		BigDecimal one = new BigDecimal("1");
		BigDecimal hundred = new BigDecimal("100");
		
		/*
		 * 总量预测录入:年月，本期新增限上同期数，限上累比增幅预测数，限下累比增幅预测数
		 */
		Integer year = req.getYear();
		Integer month = req.getMonth();
		BigDecimal lastAdd = req.getLastAdd();
		BigDecimal currRise = req.getCurrRise().divide(hundred);
		BigDecimal currUnderRise = req.getCurrUnderRise().divide(hundred);
		if(ValidateUtil.isEmpty(lastAdd)){
			lastAdd = zero;
		}
		/*
		 * 预测输出:
		 * 实际限上同期数=限上同期数+限上新增同期数-限上减少同期数(正常退库)
		 * 实际同期数=同期总量
		 * 同期限上数据占比=实际限上同期数/实际同期数
		 * 总量类比增幅:(同期限上数据占比*当期限上增幅)+(同期线下数据占比*当期限下增幅)
		 * 当期累计总量:实际同期数+(实际同期数*总量比增幅)
		 * 当期限上累计数:实际限上同期数+(实际限上同期数*限上增幅预测比)
		 * 本月限上预测数:当期限上累计数-上月当期累计数
		 */
		
		//数据校验
		Map<String,Object> chkParam = new HashMap<String,Object>();
		chkParam.put("year", year-1);
		chkParam.put("start_month", 1);
		chkParam.put("end_month", month);
		List<Integer> months = realReportMapper.selectDistinctMonths(chkParam);
		if(ValidateUtil.isEmpty(months) || months.size() !=(month-1)){
			throw new Exception("统计局导入表中同期1至"+month+"月数据不完整");
		}
		
		TotalReportExample chkExample = new TotalReportExample();
		chkExample.createCriteria().andYearEqualTo(year-1).andMonthEqualTo(month);
		List<TotalReport> totals = totalReportMapper.selectByExample(chkExample);
		if(ValidateUtil.isEmpty(totals)){
			throw new Exception("总量数据表中同期"+month+"月数据不完整");
		}
		
		//限上同期数
		Map<String,Object> query = new HashMap<String,Object>();
		query.put("year",year-1);
//		query.put("start_month",1);
//		query.put("end_month",month);
		query.put("month", month);
		// 入库类型 0:已入库 1:新增入库 2:未入库 3:已出库 4:破产吊销出库
		List<Integer> inTypes = new ArrayList<Integer>();
		inTypes.add(0);
		inTypes.add(1);
		inTypes.add(4);
		query.put("inTypes", inTypes);
		List<RealReportVo> realReports = realReportMapper.selectRetailSalesForSum(query);
		BigDecimal retailAmount = zero;
		if(!ValidateUtil.isEmpty(realReports)){
			RealReportVo vo = realReports.get(0);
			retailAmount = vo.getRetailSales();
		}
		
		//限上截止上月当期数
		query.put("year",year);
		List<RealReportVo> currRealReports = realReportMapper.selectRetailSalesForSum(query);
		BigDecimal currRetailAmount = zero;
		if(!ValidateUtil.isEmpty(currRealReports)){
			RealReportVo vo = currRealReports.get(0);
			currRetailAmount = vo.getRetailSales();
		}
		
		//扣除不可比的数据
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("year",year);
		param.put("last_year",year-1);
		param.put("start_month",1);
		param.put("end_month",month);
		List<RealReportVo> reduceRetailSaleList = realReportMapper.selectRetailSalesForReduce(param);
		BigDecimal reduceRetailSales  = zero;
		if(reduceRetailSaleList != null && reduceRetailSaleList.size() > 0){
			reduceRetailSales = reduceRetailSaleList.get(0).getRetailSales();
		}
		
		//实际同期总量
		BigDecimal lastAmount = zero;
		for (TotalReport totalReport : totals) {
			lastAmount = lastAmount.add(totalReport.getTotalSales());
		}

		//实际限上同期数
		BigDecimal realLast = retailAmount.add(new BigDecimal(lastAdd.toString()));
		
		//同期限上数据占比
		BigDecimal lastRatio = realLast.divide(lastAmount,4, BigDecimal.ROUND_HALF_UP);
		
		//同期限下数据占比
		BigDecimal lastUnderRatio = one.subtract(lastRatio);
		
		//总量类比增幅
		BigDecimal currAmountRise = lastRatio.multiply(currRise).add(lastUnderRatio.multiply(currUnderRise)).setScale(4, BigDecimal.ROUND_HALF_UP);
		
		//当期累计总量
		BigDecimal currAmount = lastAmount.multiply((one.add(currAmountRise)));
		
		//当期限上累计数
		BigDecimal currMonthAmount = realLast.multiply((one.add(currRise)));
		
		//上月当期累计数
		BigDecimal currLast = currRetailAmount.subtract(reduceRetailSales);
		
		//本月限上预测数
		BigDecimal currMonth = currMonthAmount.subtract(currLast);
		
		Forecast forecast = new Forecast(year, month, lastAdd, lastAmount, currRise.multiply(hundred), currUnderRise.multiply(hundred), currMonthAmount, currMonth, currAmountRise.multiply(hundred), currAmount, lastRatio.multiply(hundred), lastUnderRatio.multiply(hundred), retailAmount, realLast);
		
		ForecastLtResp resp = new ForecastLtResp();
		resp.setCount(1L);
		List<Forecast> forecastList = new ArrayList<Forecast>();
		forecastList.add(forecast);
		resp.setForecastLt(forecastList);
		return resp;
	}

}
