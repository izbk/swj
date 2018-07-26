package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.RealReport;
import cn.com.yuanwei.center.entity.RealReportExample;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.RealReportMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.RealReportService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.RealReportReq;
import cn.com.yuanwei.center.web.response.RealReportLtResp;

@Service
@Transactional
public class RealReportServiceImpl implements RealReportService {

	@Autowired
	private RealReportMapper realReportMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public void save(RealReport realReport) throws Exception {
		Integer year = realReport.getYear();
		Integer month = realReport.getMonth();
		String enterpriseCode = realReport.getEnterpriseCode();
		RealReportExample example = new RealReportExample();
		example.createCriteria().andEnterpriseCodeEqualTo(enterpriseCode).andYearEqualTo(year).andMonthEqualTo(month);
		List<RealReport> list = realReportMapper.selectByExample(example);
		if(list != null && list.size()>0){
			throw new Exception("该月已存在数据");
		}
		realReportMapper.insertSelective(realReport);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,realReport.getId(), "新增统计局导出表信息"));		
	}

	@Override
	public void update(RealReport realReport) throws Exception {
		Integer year = realReport.getYear();
		Integer month = realReport.getMonth();
		String enterpriseCode = realReport.getEnterpriseCode();
		RealReportExample example = new RealReportExample();
		example.createCriteria().andEnterpriseCodeEqualTo(enterpriseCode).andYearEqualTo(year).andMonthEqualTo(month);
		List<RealReport> list = realReportMapper.selectByExample(example);
		for (RealReport report : list) {
			if(realReport.getId().compareTo(report.getId())!=0){
				throw new Exception("该月已存在数据");
			}
		}
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,realReport.getId(), "更新统计局导出表信息"));
		realReportMapper.updateByPrimaryKey(realReport);
	}

	@Override
	public void delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除统计局导出表信息"));
		}
		RealReportExample de=new RealReportExample();
		de.createCriteria().andIdIn(ids);
		realReportMapper.deleteByExample(de);
	}
	
	@Override
	public RealReport queryById(Integer id){
		return realReportMapper.selectByPrimaryKey(id);
	}

	@Override
	public void batchSave(List<RealReport> list) throws Exception {
		realReportMapper.batchInsert(list);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate, "导入统计局导出表信息"));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public RealReportLtResp queryList(RealReportReq req) throws Exception {
		Integer id = req.getId();
		String enterpriseCode = req.getEnterpriseCode();
		String enterpriseName = req.getEnterpriseName();
		Integer year = req.getYear();
		Integer month = req.getMonth();
		Integer startMonth = req.getStartMonth();
		Integer endMonth = req.getEndMonth();
		Integer townshipId = req.getTownshipId();
		Integer enterpriseType = req.getEnterpriseType();
		Integer industry = req.getIndustry();
		Integer inType = req.getInType();
		Date createTime = req.getCreateTime();
		Map<String,Object> example = new HashMap<String,Object>();
		example.put("orderByClause"," a.id desc");
		if(!ValidateUtil.isEmpty(id)){
			example.put("id",id);
		}
		if(!ValidateUtil.isEmpty(enterpriseCode)){
			example.put("enterpriseCode",enterpriseCode);
		}
		if(!ValidateUtil.isEmpty(enterpriseName)){
			example.put("enterpriseName","%"+enterpriseName+"%");
		}
		if(!ValidateUtil.isEmpty(year)){
			example.put("year",year);
		}
		if(!ValidateUtil.isEmpty(month)){
			example.put("month",month);
		}
		if(!ValidateUtil.isEmpty(startMonth)){
			example.put("startMonth",startMonth);
		}
		if(!ValidateUtil.isEmpty(endMonth)){
			example.put("endMonth",endMonth);
		}
		if(!ValidateUtil.isEmpty(townshipId)){
			example.put("townshipId",townshipId);
		}
		if(!ValidateUtil.isEmpty(enterpriseType)){
			example.put("enterpriseType",enterpriseType);
		}
		if(!ValidateUtil.isEmpty(industry)){
			example.put("industry",industry);
		}
		if(!ValidateUtil.isEmpty(inType)){
			example.put("inType",inType);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			example.put("createTime",createTime);
		}
		if(!ValidateUtil.isEmpty(year)&&!ValidateUtil.isEmpty(startMonth)&&!ValidateUtil.isEmpty(endMonth)&&startMonth.compareTo(1)==0){
			List<Integer> enterpriseIds = realReportMapper.selectCheckData(example);
			if(!ValidateUtil.isEmpty(enterpriseIds)){
				example.put("enterpriseIds", enterpriseIds);
			}
		}
		
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page page = (Page) realReportMapper.selectByMap(example);
		RealReport sum = realReportMapper.selectSumByMap(example);
		RealReportLtResp resp = new RealReportLtResp();
		resp.setCount(page.getTotal());
		resp.setRealReportLt(page.getResult());
		resp.setSum(sum);
		return resp;
	}

	@Override
	public Integer batchDelete(RealReportReq req) throws Exception {
		Integer id = req.getId();
		String enterpriseCode = req.getEnterpriseCode();
		String enterpriseName = req.getEnterpriseName();
		Integer year = req.getYear();
		Integer month = req.getMonth();
		Integer startMonth = req.getStartMonth();
		Integer endMonth = req.getEndMonth();
		Integer townshipId = req.getTownshipId();
		Integer enterpriseType = req.getEnterpriseType();
		Integer industry = req.getIndustry();
		Integer inType = req.getInType();
		Date createTime = req.getCreateTime();
		Map<String,Object> example = new HashMap<String,Object>();
		example.put("orderByClause"," a.id desc");
		if(!ValidateUtil.isEmpty(id)){
			example.put("id",id);
		}
		if(!ValidateUtil.isEmpty(enterpriseCode)){
			example.put("enterpriseCode",enterpriseCode);
		}
		if(!ValidateUtil.isEmpty(enterpriseName)){
			example.put("enterpriseName","%"+enterpriseName+"%");
		}
		if(!ValidateUtil.isEmpty(year)){
			example.put("year",year);
		}
		if(!ValidateUtil.isEmpty(month)){
			example.put("month",month);
		}
		if(!ValidateUtil.isEmpty(startMonth)){
			example.put("startMonth",startMonth);
		}
		if(!ValidateUtil.isEmpty(endMonth)){
			example.put("endMonth",endMonth);
		}
		if(!ValidateUtil.isEmpty(townshipId)){
			example.put("townshipId",townshipId);
		}
		if(!ValidateUtil.isEmpty(enterpriseType)){
			example.put("enterpriseType",enterpriseType);
		}
		if(!ValidateUtil.isEmpty(industry)){
			example.put("industry",industry);
		}
		if(!ValidateUtil.isEmpty(inType)){
			example.put("inType",inType);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			example.put("createTime",createTime);
		}
		return realReportMapper.deleteByMap(example);
	}

	
}
