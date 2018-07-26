package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.Enterprise;
import cn.com.yuanwei.center.entity.EnterpriseExample;
import cn.com.yuanwei.center.entity.EnterpriseRise;
import cn.com.yuanwei.center.entity.EnterpriseRiseExample;
import cn.com.yuanwei.center.entity.Forecast;
import cn.com.yuanwei.center.entity.ForecastDetail;
import cn.com.yuanwei.center.entity.ForecastDetailExample;
import cn.com.yuanwei.center.entity.ForecastDetailExample.Criteria;
import cn.com.yuanwei.center.entity.ForecastExample;
import cn.com.yuanwei.center.entity.RealReport;
import cn.com.yuanwei.center.entity.RealReportExample;
import cn.com.yuanwei.center.entity.RealReportVo;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.enums.EnterpriseTypeEnum;
import cn.com.yuanwei.center.enums.InTypeEnum;
import cn.com.yuanwei.center.mapper.EnterpriseMapper;
import cn.com.yuanwei.center.mapper.EnterpriseRiseMapper;
import cn.com.yuanwei.center.mapper.ForecastDetailMapper;
import cn.com.yuanwei.center.mapper.ForecastMapper;
import cn.com.yuanwei.center.mapper.RealReportMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.ForecastDetailService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ForecastDetailReq;
import cn.com.yuanwei.center.web.response.ForecastDetailLtResp;

@Service
@Transactional
public class ForecastDetailServiceImpl implements ForecastDetailService {
	@Autowired
	private ForecastDetailMapper forecastDetailMapper;
	@Autowired
	private ForecastMapper forecastMapper;
	@Autowired
	private RealReportMapper realReportMapper;
	@Autowired
	private EnterpriseRiseMapper enterpriseRiseMapper;
	@Autowired
	private EnterpriseMapper enterpriseMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	 
	@Override
	public void save(ForecastDetail forecastDetail) throws Exception {
		forecastDetailMapper.insert(forecastDetail);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,forecastDetail.getId(), "新增企业预测结果"));
	}

	@Override
	public void update(ForecastDetail forecastDetail) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,forecastDetail.getId(), "更新企业预测结果"));
		forecastDetailMapper.updateByPrimaryKey(forecastDetail);
	}

	@Override
	public void delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除企业预测结果"));
		}
		ForecastDetailExample de=new ForecastDetailExample();
		de.createCriteria().andIdIn(ids);
		forecastDetailMapper.deleteByExample(de);
	}
	
	@Override
	public ForecastDetail queryById(Integer id){
		return forecastDetailMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public void batchSave(List<ForecastDetail> list) throws Exception {
		forecastDetailMapper.batchInsert(list);
	}
	@Override
	public ForecastDetailLtResp queryList(ForecastDetailReq req) throws Exception {
		Integer id = req.getId();
		String enterpriseCode = req.getEnterpriseCode();
		String enterpriseName = req.getEnterpriseName();
		BigDecimal sntqRetailSales = req.getSntqRetailSales();
		BigDecimal compareRise = req.getCompareRise();
		BigDecimal currRetailSales = req.getCurrRetailSales();
		Integer enterpriseType = req.getEnterpriseType();
		Integer inType = req.getInType();
		Integer year = req.getYear();
		Integer month = req.getMonth();
		Date createDate = req.getCreateDate();
		ForecastDetailExample de=new ForecastDetailExample();
		de.setOrderByClause(" curr_retail_sales");
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(enterpriseCode)){
			c.andEnterpriseCodeEqualTo(enterpriseCode);
		}
		if(!ValidateUtil.isEmpty(enterpriseName)){
			c.andEnterpriseNameLike("%"+enterpriseName+"%");
		}
		if(!ValidateUtil.isEmpty(sntqRetailSales)){
			c.andSntqRetailSalesEqualTo(sntqRetailSales);
		}
		if(!ValidateUtil.isEmpty(compareRise)){
			c.andCompareRiseEqualTo(compareRise);
		}
		if(!ValidateUtil.isEmpty(currRetailSales)){
			c.andCurrRetailSalesEqualTo(currRetailSales);
		}
		if(!ValidateUtil.isEmpty(enterpriseType)){
			c.andEnterpriseTypeEqualTo(enterpriseType);
		}
		if(!ValidateUtil.isEmpty(inType)){
			c.andInTypeEqualTo(inType);
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(month)){
			c.andMonthEqualTo(month);
		}
		if(!ValidateUtil.isEmpty(createDate)){
			c.andCreateDateEqualTo(createDate);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<ForecastDetail> page = (Page<ForecastDetail>) forecastDetailMapper.selectByExample(de);
		List<ForecastDetail> list = page.getResult();
		//计算单月同比增幅
		BigDecimal zero = new BigDecimal("0");
		BigDecimal one = new BigDecimal("1");
		BigDecimal hundred = new BigDecimal("100");
		for (int i = 0; i < list.size(); i++) {
			ForecastDetail detail = list.get(i);
			BigDecimal sntq = detail.getSntqRetailSales();
			BigDecimal compareMonthRise = zero;
			if(!ValidateUtil.isEmpty(sntq)&&sntq.compareTo(zero)>0){
				compareMonthRise = detail.getCurrRetailSales().divide(sntq, 4, BigDecimal.ROUND_HALF_UP).subtract(one).multiply(hundred);
			}
			detail.setCompareMonthRise(compareMonthRise);
		}
		ForecastDetailLtResp resp = new ForecastDetailLtResp();
		resp.setCount(page.getTotal());
		resp.setForecastDetailLt(list);
		return resp;
	}
	@Override
	public ForecastDetailLtResp calc(ForecastDetailReq req) throws Exception {

		/*
		 * 公用参数
		 */
		BigDecimal zero = new BigDecimal("0");
		BigDecimal one = new BigDecimal("1");
		BigDecimal hundred = new BigDecimal("100");
		/*
		 * 企业明细预测录入:年月，同比增幅
		 */
		Integer year = req.getYear();
		Integer month = req.getMonth();
		/*
		 * 删除本月存在的预测数据
		 */
		ForecastDetailExample detailExample = new ForecastDetailExample();
		detailExample.createCriteria().andYearEqualTo(year).andMonthEqualTo(month);
		forecastDetailMapper.deleteByExample(detailExample);
		
		/*
		 * 获取总量预测数据
		 */
		ForecastExample forecastExample = new ForecastExample();
		forecastExample.createCriteria().andYearEqualTo(year).andMonthEqualTo(month);
		List<Forecast> forecasts = forecastMapper.selectByExample(forecastExample);
		BigDecimal currMonth = zero;
		BigDecimal currRise = zero;
		if(forecasts != null && forecasts.size()>0){
			Forecast forecast = forecasts.get(0);
			currMonth = forecast.getCurrMonth();
			currRise = forecast.getCurrRise();
		}
		if(currMonth.compareTo(zero)==0){
			throw new Exception("本月总量预测数为0！");
		}
		//获取企业预测比例限额
		EnterpriseRiseExample example = new EnterpriseRiseExample();
		List<EnterpriseRise> list = enterpriseRiseMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			throw new Exception("未获取到企业预测比例限额！");
		}
		EnterpriseRise rise = list.get(0);
		//获取法人企业预测比例限额
		BigDecimal compareRiseLimit = rise.getEnterCompareRise().divide(hundred);
		////获取个体企业预测比例限额
		BigDecimal gtCompareRiseLimit = rise.getPersonCompareRise().divide(hundred);
		
		//限上同期数据
		RealReport lastReport = new RealReport();
		lastReport.setYear(year-1);
		lastReport.setMonth(month);
		lastReport.setStartMonth(month);
		List<Integer> inTypes_1 = new ArrayList<Integer>();
		inTypes_1.add(0);
		inTypes_1.add(1);
		
		List<RealReportVo> lastRealReports = realReportMapper.selectByExampleWithInTypes(inTypes_1,lastReport);
		//获取新增入库企业
		EnterpriseExample eexample = new EnterpriseExample();
		eexample.createCriteria().andInTypeEqualTo(InTypeEnum.xinzengruku.getCode());
		List<Enterprise> enterprises = enterpriseMapper.selectByExample(eexample);
		for (Enterprise enterprise : enterprises) {
			RealReportVo vo = new RealReportVo();
			BeanUtils.copyProperties(vo, enterprise);
			vo.setYear(year-1);
			vo.setMonth(month);
			if(!ValidateUtil.isEmpty(enterprise.getThreshold())){
				vo.setRetailSales(enterprise.getThreshold().multiply(new BigDecimal(month.toString())));
			}else{
				vo.setRetailSales(zero);
			}
			lastRealReports.add(vo);
		}
		
		//预测企业数据
		List<ForecastDetail> details = new ArrayList<ForecastDetail>();
		Date date = new Date();
		BigDecimal amount = zero;
		for (int i = 0; i < lastRealReports.size(); i++) {
			RealReportVo realReport = lastRealReports.get(i);
			BigDecimal sntqRetailSales = realReport.getRetailSales();
			Integer enterpriseType = realReport.getEnterpriseType();
			BigDecimal randomRatio = getRandomRatio(rise.getEnterRandomRise().intValue(),i);
			//计算比例
			BigDecimal calcRatio = currRise.add(randomRatio);
			//个体总数增长单月同比不超过15%
			if(enterpriseType!=null&&enterpriseType.compareTo(1)==0){
				if(calcRatio.compareTo(gtCompareRiseLimit) >= 0){
					currRise = gtCompareRiseLimit;
					randomRatio = getRandomRatio(rise.getPersonRandomRise().intValue(),1);
					calcRatio = currRise.add(randomRatio);
					if(calcRatio.compareTo(new BigDecimal("0")) <= 0){
						calcRatio = gtCompareRiseLimit;
					}
				}
			}else{
				if(calcRatio.compareTo(compareRiseLimit) >= 0){
					currRise = compareRiseLimit;
					randomRatio = getRandomRatio(rise.getEnterRandomRise().intValue(),1);
					calcRatio = currRise.add(randomRatio);
					if(calcRatio.compareTo(new BigDecimal("0")) <= 0){
						calcRatio = compareRiseLimit;
					}
				}
			}
			BigDecimal curr = sntqRetailSales.multiply(calcRatio.add(one));
			amount = amount.add(curr);
			//设置增幅
			ForecastDetail detail = new ForecastDetail(realReport.getEnterpriseCode(), realReport.getEnterpriseName(),
					sntqRetailSales, calcRatio.multiply(hundred), curr, realReport.getEnterpriseType(), realReport.getInType(), year, month,date);
			details.add(detail);
		}
		BigDecimal diff = currMonth.subtract(amount).abs();
		for (int i = 0; i < details.size(); i++) {
			ForecastDetail detail = details.get(i);
			BigDecimal last = detail.getSntqRetailSales();
			BigDecimal curr = detail.getCurrRetailSales();
			BigDecimal ratio = curr.divide(amount,6,BigDecimal.ROUND_HALF_UP);
			if(currMonth.compareTo(amount)>0){
				curr = curr.add(diff.multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
				detail.setCurrRetailSales(curr);
			}else{
				curr = curr.subtract(diff.multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
				detail.setCurrRetailSales(curr);
			}
			if(detail.getSntqRetailSales().compareTo(zero)>0){
				BigDecimal compareRise = curr.divide(last, 4, BigDecimal.ROUND_HALF_UP).subtract(one).multiply(hundred);
				detail.setCompareRise(compareRise);
			}
		}
		forecastDetailMapper.batchInsert(details);
		ForecastDetailLtResp resp = new ForecastDetailLtResp();
		resp.setCount(new Long(details.size()));
		resp.setForecastDetailLt(details);
		return resp;
	}
	
	public ForecastDetailLtResp calc3(ForecastDetailReq req) throws Exception {

		/*
		 * 公用参数
		 */
		BigDecimal zero = new BigDecimal("0");
		BigDecimal one = new BigDecimal("1");
		BigDecimal hundred = new BigDecimal("100");
		/*
		 * 企业明细预测录入:年月，同比增幅
		 */
		Integer year = req.getYear();
		Integer month = req.getMonth();
		/*
		 * 删除本月存在的预测数据
		 */
		ForecastDetailExample detailExample = new ForecastDetailExample();
		detailExample.createCriteria().andYearEqualTo(year).andMonthEqualTo(month);
		forecastDetailMapper.deleteByExample(detailExample);
		
		/*
		 * 获取总量预测数据
		 */
		ForecastExample forecastExample = new ForecastExample();
		forecastExample.createCriteria().andYearEqualTo(year).andMonthEqualTo(month);
		List<Forecast> forecasts = forecastMapper.selectByExample(forecastExample);
		BigDecimal currMonth = zero;
		BigDecimal currRise = zero;
		if(forecasts != null && forecasts.size()>0){
			Forecast forecast = forecasts.get(0);
			currMonth = forecast.getCurrMonth();
			currRise = forecast.getCurrRise();
		}
		if(currMonth.compareTo(zero)==0){
			throw new Exception("本月总量预测数为0！");
		}
		//获取企业预测比例限额
		EnterpriseRiseExample example = new EnterpriseRiseExample();
		List<EnterpriseRise> list = enterpriseRiseMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			throw new Exception("未获取到企业预测比例限额！");
		}
		EnterpriseRise rise = list.get(0);
		//预测总量误差
//		int forecastDifference = rise.getForecastDifference().intValue();
		//限上同期累计数据
		RealReport lastReport = new RealReport();
		lastReport.setYear(year-1);
		lastReport.setMonth(month);
		List<Integer> inTypes_1 = new ArrayList<Integer>();
		inTypes_1.add(0);
		List<RealReportVo> lastAmounts = realReportMapper.selectByExampleWithInTypes(inTypes_1,lastReport);
		
		//限上上期累计数据
		lastReport = new RealReport();
		lastReport.setYear(year);
		lastReport.setMonth(month-1);
		List<RealReportVo> amounts = realReportMapper.selectByExampleWithInTypes(inTypes_1,lastReport);
		
		//上年同期数据
		RealReportExample rexample = new RealReportExample();
		rexample.createCriteria().andYearEqualTo(year-1).andMonthEqualTo(month);
		List<RealReport> realReports = realReportMapper.selectByExample(rexample);
		
		//获取新增入库企业
		EnterpriseExample eexample = new EnterpriseExample();
		eexample.createCriteria().andInTypeEqualTo(InTypeEnum.xinzengruku.getCode());
		List<Enterprise> enterprises = enterpriseMapper.selectByExample(eexample);
		for (Enterprise enterprise : enterprises) {
			RealReportVo vo = new RealReportVo();
			BeanUtils.copyProperties(vo, enterprise);
			vo.setYear(year-1);
			vo.setMonth(month);
			if(!ValidateUtil.isEmpty(enterprise.getThreshold())){
				vo.setRetailSales(enterprise.getThreshold().multiply(new BigDecimal(month.toString())));
			}else{
				vo.setRetailSales(zero);
			}
			lastAmounts.add(vo);
		}
		//设置初值
//		int forecastDifference = 10000;
//		int calcDiff = forecastDifference + 1;
		List<ForecastDetail> details = new ArrayList<ForecastDetail>();
//		int calcCount=0;
		BigDecimal currRetailSales = zero;
//		while(calcDiff > forecastDifference){
			details = preCalc(year, month,currRise.divide(hundred), rise, lastAmounts,amounts,realReports);
//			currRetailSales = zero;
			for (int i = 0; i < details.size(); i++) {
				ForecastDetail detail = details.get(i);
				currRetailSales = currRetailSales.add(detail.getCurrRetailSales());
			}
//			calcDiff = Math.abs(currRetailSales.subtract(currMonth).intValue());
//			if(++calcCount>10000){
//				throw new Exception("预测超时，请重新预测");
//			}
		adjust(zero, one, hundred, currMonth, currRise,rise, lastAmounts, amounts, details, currRetailSales);
		forecastDetailMapper.batchInsert(details);
		ForecastDetailLtResp resp = new ForecastDetailLtResp();
		resp.setCount(new Long(details.size()));
		resp.setForecastDetailLt(details);
		return resp;
	}

	public void adjust(BigDecimal zero, BigDecimal one, BigDecimal hundred, BigDecimal currMonth, BigDecimal currRise,EnterpriseRise rise,
			List<RealReportVo> lastAmounts, List<RealReportVo> amounts, List<ForecastDetail> details,
			BigDecimal currRetailSales) {
		BigDecimal diff = currRetailSales.subtract(currMonth);
		System.out.println("总额差值："+currRetailSales.subtract(currMonth).intValue());
		//获取法人企业预测比例限额
		BigDecimal compareRiseLimit = currRise.subtract(rise.getEnterRandomRise().divide(hundred)).add(rise.getEnterCompareRise()).divide(new BigDecimal("2"));
		//获取个体企业预测比例限额
//		BigDecimal gtCompareRiseLimit = rise.getPersonCompareRise().subtract(rise.getPersonRandomRise().divide(new BigDecimal("2"))).divide(hundred);		
		if(diff.compareTo(zero)>0){
			List<ForecastDetail> gtDetails = new ArrayList<ForecastDetail>();
			BigDecimal amt = zero;
			for (int i = 0; i < details.size(); i++) {
				ForecastDetail detail = details.get(i);
				Integer type = detail.getEnterpriseType();
				BigDecimal compareRise = detail.getCompareRise().divide(hundred);
				if ((type.compareTo(EnterpriseTypeEnum.faren.getCode()) == 0
						&& compareRise.compareTo(compareRiseLimit) > 0)
						/*|| (type.compareTo(EnterpriseTypeEnum.geti.getCode()) == 0
								&& compareRise.compareTo(gtCompareRiseLimit) > 0)*/) {
					gtDetails.add(detail);
					amt = amt.add(detail.getCurrRetailSales());
				}
			}
			for (int i = 0; i < gtDetails.size(); i++) {
				ForecastDetail detail = gtDetails.get(i);
				String enterpriseCode = detail.getEnterpriseCode();
				//企业占比
				BigDecimal ratio = detail.getCurrRetailSales().divide(amt, 6,BigDecimal.ROUND_HALF_UP);
				detail.setCurrRetailSales(detail.getCurrRetailSales().subtract(diff.multiply(ratio)));
				//获取今年1-上月数据
				BigDecimal amountRetailSales = zero;
				for (int j = 0; j < amounts.size(); j++) {
					RealReportVo amount = amounts.get(j);
					if(enterpriseCode.equals(amount.getEnterpriseCode())){
						amountRetailSales = amount.getRetailSales();
					}
				}
				//今年1-本月 = 今年1-上月数据 + 本月预测数据
				amountRetailSales = amountRetailSales.add(detail.getCurrRetailSales());
				//获取去年1-本月
				BigDecimal lastRs = zero;
				for (int k = 0; k < lastAmounts.size(); k++) {
					RealReportVo lastAmount = lastAmounts.get(k);
					if(enterpriseCode.equals(lastAmount.getEnterpriseCode())){
						lastRs = lastAmount.getRetailSales();
					}
				}
				//计算累比增幅 今年1-本月/去年1-本月
				BigDecimal compareRise = zero;
				if(!ValidateUtil.isEmpty(lastRs) && lastRs.compareTo(zero)>0){
					compareRise = amountRetailSales.divide(lastRs,4,BigDecimal.ROUND_HALF_UP).subtract(one).multiply(hundred);
				}
				detail.setCompareRise(compareRise);
			}
		}else{
			List<ForecastDetail> lsDetails = new ArrayList<ForecastDetail>();
			BigDecimal amt = zero;
			for (int i = 0; i < details.size(); i++) {
				ForecastDetail detail = details.get(i);
				Integer type = detail.getEnterpriseType();
				BigDecimal compareRise = detail.getCompareRise().divide(hundred);
				if ((type.compareTo(EnterpriseTypeEnum.faren.getCode()) == 0 && compareRise.compareTo(zero) > 0
						&& compareRise.compareTo(compareRiseLimit) < 0 && detail.getCurrRetailSales().compareTo(zero)>0)
						/*|| (type.compareTo(EnterpriseTypeEnum.geti.getCode()) == 0 && compareRise.compareTo(zero) > 0
								&& compareRise.compareTo(gtCompareRiseLimit) < 0)*/) {
					lsDetails.add(detail);
					amt = amt.add(detail.getCurrRetailSales());
				}
			}
			diff = diff.abs();
			for (int i = 0; i < lsDetails.size(); i++) {
				ForecastDetail detail = lsDetails.get(i);
				String enterpriseCode = detail.getEnterpriseCode();
				//企业占比
				BigDecimal ratio = detail.getCurrRetailSales().divide(amt, 6,BigDecimal.ROUND_HALF_UP);
				detail.setCurrRetailSales(detail.getCurrRetailSales().add(diff.multiply(ratio)));
				//获取今年1-上月数据
				BigDecimal amountRetailSales = zero;
				for (int j = 0; j < amounts.size(); j++) {
					RealReportVo amount = amounts.get(j);
					if(enterpriseCode.equals(amount.getEnterpriseCode())){
						amountRetailSales = amount.getRetailSales();
					}
				}
				//今年1-本月 = 今年1-上月数据 + 本月预测数据
				amountRetailSales = amountRetailSales.add(detail.getCurrRetailSales());
				//获取去年1-本月
				BigDecimal lastRs = zero;
				for (int k = 0; k < lastAmounts.size(); k++) {
					RealReportVo lastAmount = lastAmounts.get(k);
					if(enterpriseCode.equals(lastAmount.getEnterpriseCode())){
						lastRs = lastAmount.getRetailSales();
					}
				}
				//计算累比增幅 今年1-本月/去年1-本月
				BigDecimal compareRise = zero;
				if(!ValidateUtil.isEmpty(lastRs) && lastRs.compareTo(zero)>0){
					compareRise = amountRetailSales.divide(lastRs,4,BigDecimal.ROUND_HALF_UP).subtract(one).multiply(hundred);
				}
				detail.setCompareRise(compareRise);
			}
		}
	}

	public List<ForecastDetail> preCalc(Integer year, Integer month,
			BigDecimal currRise, EnterpriseRise rise,List<RealReportVo> lastAmounts,List<RealReportVo> amounts,List<RealReport> realReports) {
		//预测企业数据
		List<ForecastDetail> details = new ArrayList<ForecastDetail>();
		Date date = new Date();
		BigDecimal zero = new BigDecimal("0");
		BigDecimal one = new BigDecimal("1");
		BigDecimal hundred = new BigDecimal("100");
		
		//获取法人企业预测比例限额
		BigDecimal compareRiseLimit = rise.getEnterCompareRise().divide(hundred);
		//获取个体企业预测比例限额
		BigDecimal gtCompareRiseLimit = rise.getPersonCompareRise().divide(hundred);
		Random random = new Random();
		for (int i = 0; i < lastAmounts.size(); i++) {
			RealReportVo lastAmount = lastAmounts.get(i);
			BigDecimal sntqAmountRetailSales = lastAmount.getRetailSales();
			Integer enterpriseType = lastAmount.getEnterpriseType();
			BigDecimal randomRatio = getRandomRatio(rise.getEnterRandomRise().intValue(),random.nextInt(100));
			BigDecimal gtRandomRatio = getRandomRatio(rise.getPersonRandomRise().intValue(),1);
			//计算比例
			BigDecimal calcRatio = zero;
			BigDecimal gtCalcRatio = zero;
			//个体总数增长单月同比不超过15%
			if(enterpriseType!=null&&enterpriseType.compareTo(1)==0){
				gtCalcRatio = gtCompareRiseLimit.add(gtRandomRatio);
			}else{
				calcRatio = currRise.add(randomRatio);
				if(calcRatio.compareTo(compareRiseLimit) > 0){
						calcRatio = compareRiseLimit;
				}
			}
			
			if(calcRatio.compareTo(zero)==0){
				calcRatio = gtCalcRatio;
			}
			//限上本期数据
			BigDecimal lastMonthAmountRetailSales = zero;
			for (int j = 0; j < amounts.size(); j++) {
				RealReportVo amount = amounts.get(j);
				if(lastAmount.getEnterpriseCode().equals(amount.getEnterpriseCode())){
					lastMonthAmountRetailSales = amount.getRetailSales();
					break;
				}
			}
			//本月预测数据 = 去年1-本月累计*(1+本期限上增幅)-今年1-上月累计
			BigDecimal currRetailSales = sntqAmountRetailSales.multiply(calcRatio.add(one)).subtract(lastMonthAmountRetailSales);
			
			//上年同期数据
			BigDecimal sntqRetailSales = zero;
			for (int k = 0; k < realReports.size(); k++) {
				RealReport realRepost = realReports.get(k);
				if(lastAmount.getEnterpriseCode().equals(realRepost.getEnterpriseCode())){
					String strRetailSales =realRepost.getRetailSales();
					if(!ValidateUtil.isEmpty(strRetailSales)){
						sntqRetailSales = new BigDecimal(strRetailSales);
						break;
					}
				}
			}

			ForecastDetail detail = new ForecastDetail(lastAmount.getEnterpriseCode(), lastAmount.getEnterpriseName(),
					sntqRetailSales, calcRatio.multiply(hundred), currRetailSales, lastAmount.getEnterpriseType(), lastAmount.getInType(), year, month,date);
			details.add(detail);
		}
		return details;
	}
	
	private static BigDecimal getRandomRatio(Integer range,Integer index) {
		Integer max=range*100;
		Integer min=100;
        Random random = new Random();
        Integer data = random.nextInt(max)%(max-min+1) + min;
        BigDecimal signBit = new BigDecimal((index%2==0?1:-1));
        BigDecimal result = new BigDecimal(data.toString()).divide(new BigDecimal("10000"), 4, BigDecimal.ROUND_HALF_UP).multiply(signBit);
        return result;
	}
	
	@Override
	public ForecastDetailLtResp calc2(ForecastDetailReq req) throws Exception {

		/*
		 * 公用参数
		 */
		BigDecimal zero = new BigDecimal("0");
		BigDecimal one = new BigDecimal("1");
		BigDecimal hundred = new BigDecimal("100");
		/*
		 * 企业明细预测录入:年月，同比增幅
		 */
		Integer year = req.getYear();
		Integer month = req.getMonth();
		/*
		 * 删除本月存在的预测数据
		 */
		ForecastDetailExample detailExample = new ForecastDetailExample();
		detailExample.createCriteria().andYearEqualTo(year).andMonthEqualTo(month);
		forecastDetailMapper.deleteByExample(detailExample);
		
		/*
		 * 获取总量预测数据
		 */
		ForecastExample forecastExample = new ForecastExample();
		forecastExample.createCriteria().andYearEqualTo(year).andMonthEqualTo(month);
		List<Forecast> forecasts = forecastMapper.selectByExample(forecastExample);
		BigDecimal currMonth = zero;
		if(forecasts != null && forecasts.size()>0){
			Forecast forecast = forecasts.get(0);
			currMonth = forecast.getCurrMonth();
		}
		if(currMonth.compareTo(zero)==0){
			throw new Exception("本月总量预测数为0！");
		}
		List<Integer> inTypes_1 = new ArrayList<Integer>();
		inTypes_1.add(0);
		
		//限上按企业累计去年数据
		RealReport lastReport = new RealReport();
		lastReport.setYear(year-1);
		lastReport.setMonth(12);
		List<RealReportVo> lastYear = realReportMapper.selectByExampleWithInTypes(inTypes_1,lastReport);
		
		//限上按企业累计去年1-本月数据
		lastReport = new RealReport();
		lastReport.setYear(year-1);
		lastReport.setMonth(month);
		List<RealReportVo> lastAmounts = realReportMapper.selectByExampleWithInTypes(inTypes_1,lastReport);
		
		//限上按企业累计今年1-上月数据
		lastReport = new RealReport();
		lastReport.setYear(year);
		lastReport.setMonth(month-1);
		List<RealReportVo> amounts = realReportMapper.selectByExampleWithInTypes(inTypes_1,lastReport);
		
		//限上累计去年数据
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("year", year-1);
		data.put("month", 12);
		data.put("inTypes", inTypes_1);
		List<RealReportVo> vos = realReportMapper.selectRetailSalesForSum(data);
		BigDecimal amountSum = zero;
		if(!ValidateUtil.isEmpty(vos)){
			amountSum = vos.get(0).getRetailSales();
		}
		if(amountSum.compareTo(zero)==0){
			throw new Exception("去年累计数据为0");
		}
		
		//上年同期按企业数据
		RealReportExample rexample = new RealReportExample();
		rexample.createCriteria().andYearEqualTo(year-1).andMonthEqualTo(month);
		List<RealReport> realReports = realReportMapper.selectByExample(rexample);
		
		//获取新增入库企业
		EnterpriseExample eexample = new EnterpriseExample();
		eexample.createCriteria().andInTypeEqualTo(InTypeEnum.xinzengruku.getCode());
		List<Enterprise> enterprises = enterpriseMapper.selectByExample(eexample);
		for (Enterprise enterprise : enterprises) {
			RealReportVo vo = new RealReportVo();
			BeanUtils.copyProperties(vo, enterprise);
			vo.setYear(year-1);
			BigDecimal rs = zero;
			if(!ValidateUtil.isEmpty(enterprise.getThreshold())){
				rs = enterprise.getThreshold().multiply(new BigDecimal("12"));
			}
			vo.setRetailSales(rs);
			lastYear.add(vo);
			amountSum = amountSum.add(rs);
		}
		Date date = new Date();
		
		//预测企业数据
		List<ForecastDetail> details = new ArrayList<ForecastDetail>();
		for (int i = 0; i < amounts.size(); i++) {
			RealReportVo amount = amounts.get(i);
			String enterpriseCode = amount.getEnterpriseCode();
			//今年1-上月数据
			BigDecimal amountRetailSales = amount.getRetailSales();
			
			//计算企业占比 企业去年累计/去年总累计
			BigDecimal ratio = zero;
			for (int j = 0; j < lastYear.size(); j++) {
				RealReportVo lastVo = lastYear.get(j);
				BigDecimal last = lastVo.getRetailSales();
				if(lastVo.getEnterpriseCode().equals(enterpriseCode)){
					ratio = last.divide(amountSum, 8, BigDecimal.ROUND_HALF_UP);
					break;
				}
				
			}
			//本月预测数据 = 本月预测总数*（企业去年累计占比）
			BigDecimal currRetailSales = currMonth.multiply(ratio);
			
			//上年同期数据
			BigDecimal sntqRetailSales = zero;
			for (int k = 0; k < realReports.size(); k++) {
				RealReport realRepost = realReports.get(k);
				if(enterpriseCode.equals(realRepost.getEnterpriseCode())){
					String strRetailSales = realRepost.getRetailSales();
					if(!ValidateUtil.isEmpty(strRetailSales)){
						sntqRetailSales = new BigDecimal(strRetailSales);
						break;
					}
				}
			}
			
			//计算累比增幅 今年1-本月/去年1-本月
			BigDecimal compareRise = zero;
			for (int m = 0; m < lastAmounts.size(); m++) {
				RealReportVo lastAmount = lastAmounts.get(m);
				BigDecimal lastRs = lastAmount.getRetailSales();
				if(enterpriseCode.equals(lastAmount.getEnterpriseCode())){
					//今年1-本月 = 今年1-上月数据 + 本月预测数据
					amountRetailSales = amountRetailSales.add(currRetailSales);
					if(!ValidateUtil.isEmpty(lastRs) && lastRs.compareTo(zero)>0){
						compareRise = amountRetailSales.divide(lastRs,4,BigDecimal.ROUND_HALF_UP).subtract(one).multiply(hundred);
					}
				}
			}

			ForecastDetail detail = new ForecastDetail(amount.getEnterpriseCode(), amount.getEnterpriseName(),
					sntqRetailSales, compareRise, currRetailSales, amount.getEnterpriseType(), amount.getInType(), year, month,date);
			details.add(detail);
		}
		
		forecastDetailMapper.batchInsert(details);
		ForecastDetailLtResp resp = new ForecastDetailLtResp();
		resp.setCount(new Long(details.size()));
		resp.setForecastDetailLt(details);
		return resp;
	}
}
