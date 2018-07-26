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

import cn.com.yuanwei.center.entity.Enterprise;
import cn.com.yuanwei.center.entity.EnterpriseExample;
import cn.com.yuanwei.center.entity.EnterpriseReport;
import cn.com.yuanwei.center.entity.EnterpriseReportExample;
import cn.com.yuanwei.center.entity.EnterpriseReportExample.Criteria;
import cn.com.yuanwei.center.entity.EnterpriseReportVo;
import cn.com.yuanwei.center.entity.RealReport;
import cn.com.yuanwei.center.entity.RealReportExample;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.enums.RoleTypeEnum;
import cn.com.yuanwei.center.mapper.EnterpriseMapper;
import cn.com.yuanwei.center.mapper.EnterpriseReportMapper;
import cn.com.yuanwei.center.mapper.RealReportMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.EnterpriseReportService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.EnterpriseReportReq;
import cn.com.yuanwei.center.web.response.EnterpriseReportLtResp;

@Service
@Transactional
public class EnterpriseReportServiceImpl implements EnterpriseReportService {

	@Autowired
	private EnterpriseMapper enterpriseMapper;
	@Autowired
	private RealReportMapper realReportMapper;
	@Autowired
	private EnterpriseReportMapper enterpriseReportMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public void save(EnterpriseReport enterpriseReport) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		EnterpriseExample example = new EnterpriseExample();
		example.createCriteria().andUserIdEqualTo(userInfo.getId());
		List<Enterprise> enterprises = enterpriseMapper.selectByExample(example);
		if(enterprises  == null || enterprises.size() == 0){
			throw new Exception("您无权限上报此企业的数据");
		}else{
			Enterprise enterprise = enterprises.get(0);
			enterpriseReport.setEnterpriseType(enterprise.getEnterpriseType());
		}
		Integer year = enterpriseReport.getYear();
		Integer month = enterpriseReport.getMonth();
		String enterpriseCode = enterpriseReport.getEnterpriseCode();
		EnterpriseReportExample de=new EnterpriseReportExample();
		de.createCriteria().andEnterpriseCodeEqualTo(enterpriseCode).andYearEqualTo(year).andMonthEqualTo(month);
		List<EnterpriseReport> list = enterpriseReportMapper.selectByExample(de);
		if(list != null && list.size()>0){
			throw new Exception("该月已存在数据");
		}
		enterpriseReport.setCreateTime(new Date());
		enterpriseReportMapper.insert(enterpriseReport);
	}

	@Override
	public void update(EnterpriseReport enterpriseReport) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),enterpriseReport.getId(), "更新企业数据上报"));		
		enterpriseReportMapper.updateByPrimaryKey(enterpriseReport);
	}

	@Override
	public void delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除企业数据上报"));
		}
		EnterpriseReportExample de=new EnterpriseReportExample();
		de.createCriteria().andIdIn(ids);
		enterpriseReportMapper.deleteByExample(de);
	}
	
	@Override
	public EnterpriseReport queryById(Integer id){
		return enterpriseReportMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public EnterpriseReportLtResp queryList(EnterpriseReportReq req) throws Exception {
		Integer id = req.getId();
		String enterpriseCode = req.getEnterpriseCode();
		String enterpriseName = req.getEnterpriseName();
		Integer enterpriseType = req.getEnterpriseType();
		BigDecimal sales = req.getSales();
		BigDecimal retailSales = req.getRetailSales();
		Integer year = req.getYear();
		Integer month = req.getMonth();
		Date createTime = req.getCreateTime();
		
		EnterpriseReportExample de=new EnterpriseReportExample();
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
		if(!ValidateUtil.isEmpty(enterpriseType)){
			c.andEnterpriseTypeEqualTo(enterpriseType);
		}
		if(!ValidateUtil.isEmpty(sales)){
			c.andSalesEqualTo(sales);
		}
		if(!ValidateUtil.isEmpty(retailSales)){
			c.andRetailSalesEqualTo(retailSales);
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(month)){
			c.andMonthEqualTo(month);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		//根据角色查询
		UserInfo userInfo = LoginUserThread.getUser();
		//统计员角色
		if(RoleTypeEnum.statistician.getCode().compareTo(userInfo.getRoleId())==0){
			EnterpriseExample example = new EnterpriseExample();
			example.createCriteria().andUserIdEqualTo(userInfo.getId());
			List<Enterprise> enterprises = enterpriseMapper.selectByExample(example);
			List<String> enterpriseCodes = new ArrayList<String>();
			for (Enterprise enterprise : enterprises) {
				enterpriseCodes.add(enterprise.getEnterpriseCode());
			}
			//未获取到企业编号，设置null条件过滤数据
			if(ValidateUtil.isEmpty(enterpriseCodes)){
				enterpriseCodes.add("null");
			}
			c.andEnterpriseCodeIn(enterpriseCodes);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<?> page = (Page<?>) enterpriseReportMapper.selectEnterpriseVoByExample(de);
		List<?> list = page.getResult();
		List<EnterpriseReportVo> result = new ArrayList<EnterpriseReportVo>();
		for (Object object : list) {
			result.add((EnterpriseReportVo)object);
		}
		
		EnterpriseReportLtResp resp = new EnterpriseReportLtResp();
		resp.setCount(page.getTotal());
		resp.setEnterpriseReportLt(result);
		//年度和月份不为空，则计算同期总量增幅
		if(!ValidateUtil.isEmpty(year)&&!ValidateUtil.isEmpty(month)){
			EnterpriseReport param = new EnterpriseReport();
			param.setYear(year);
			param.setMonth(month);
			List<EnterpriseReportVo> sumVos = enterpriseReportMapper.selectSumRetailSales(param);
			if(!ValidateUtil.isEmpty(sumVos)){
				EnterpriseReportVo vo = sumVos.get(0);
				BigDecimal zero = new BigDecimal("0");
				BigDecimal one = new BigDecimal("1");
				BigDecimal hundred = new BigDecimal("100");
				BigDecimal totalRetailSales = vo.getRetailSales();
				BigDecimal totalSnqtRetailSales = vo.getSntqRetailSales();
				BigDecimal gtRetailSales = vo.getGtRetailSales();
				BigDecimal gtSnqtRetailSales = vo.getGtSntqRetailSales();
				BigDecimal totalRise = zero;
				BigDecimal gtRise = zero;
				//同比总量增幅
				if(totalSnqtRetailSales.compareTo(zero)>=0&&totalSnqtRetailSales.compareTo(zero)>0){
					totalRise = totalRetailSales.divide(totalSnqtRetailSales, 4, BigDecimal.ROUND_HALF_UP).subtract(one).multiply(hundred);
				}
				//同比个体总量增幅
				if(gtRetailSales.compareTo(zero)>=0&&gtSnqtRetailSales.compareTo(zero)>0){
					gtRise = gtRetailSales.divide(gtSnqtRetailSales, 4, BigDecimal.ROUND_HALF_UP).subtract(one).multiply(hundred);
				}
				Map<String,Object> data = new HashMap<String,Object>();
				data.put("totalRise", totalRise);
				data.put("gtRise", gtRise);
				resp.setRise(data);
			}
		}

		return resp;
	}

	@Override
	public Map<String,Object> queryTqs(EnterpriseReportReq req) throws Exception {
		RealReportExample example = new RealReportExample();
		example.createCriteria().andEnterpriseCodeEqualTo(req.getEnterpriseCode()).andYearEqualTo(req.getYear()-1).andMonthEqualTo(req.getMonth());
		List<RealReport> list = realReportMapper.selectByExample(example);
		if(!ValidateUtil.isEmpty(list)){
			RealReport report = list.get(0);
			Map<String,Object> data = new HashMap<String,Object>(); 
			data.put("sntqRetailSales", report.getRetailSales());
			data.put("sntqSales", report.getSales());
			return data;
		}
		return null;
	}
	
	@Override
	public List<EnterpriseReport> queryExport(EnterpriseReportReq req) throws Exception {
		Integer id = req.getId();
		String enterpriseCode = req.getEnterpriseCode();
		String enterpriseName = req.getEnterpriseName();
		Integer enterpriseType = req.getEnterpriseType();
		BigDecimal sales = req.getSales();
		BigDecimal retailSales = req.getRetailSales();
		Integer year = req.getYear();
		Integer month = req.getMonth();
		Date createTime = req.getCreateTime();
		
		EnterpriseReportExample de=new EnterpriseReportExample();
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
		if(!ValidateUtil.isEmpty(enterpriseType)){
			c.andEnterpriseTypeEqualTo(enterpriseType);
		}
		if(!ValidateUtil.isEmpty(sales)){
			c.andSalesEqualTo(sales);
		}
		if(!ValidateUtil.isEmpty(retailSales)){
			c.andRetailSalesEqualTo(retailSales);
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(month)){
			c.andMonthEqualTo(month);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}

		return enterpriseReportMapper.selectByExample(de);
	}
	
}
