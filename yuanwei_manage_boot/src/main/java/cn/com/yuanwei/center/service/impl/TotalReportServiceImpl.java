package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.TotalReport;
import cn.com.yuanwei.center.entity.TotalReportExample;
import cn.com.yuanwei.center.entity.TotalReportExample.Criteria;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.TotalReportMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.TotalReportService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.TotalReportReq;
import cn.com.yuanwei.center.web.response.TotalReportLtResp;

@Service
@Transactional
public class TotalReportServiceImpl implements TotalReportService {
	@Autowired
	private TotalReportMapper totalReportMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(TotalReport totalReport) throws Exception {
		Integer year = totalReport.getYear();
		Integer month = totalReport.getMonth();
		TotalReportExample example = new TotalReportExample();
		example.createCriteria().andYearEqualTo(year).andMonthEqualTo(month);
		List<TotalReport> list = totalReportMapper.selectByExample(example);
		if(list != null && list.size()>0){
			throw new Exception("该月已存在数据");
		}
		
		totalReportMapper.insert(totalReport);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),totalReport.getId(), "新增总量数据信息"));
		return totalReport.getId();
	}

	@Override
	public Integer update(TotalReport totalReport) throws Exception {
		Integer year = totalReport.getYear();
		Integer month = totalReport.getMonth();
		TotalReportExample example = new TotalReportExample();
		example.createCriteria().andYearEqualTo(year).andMonthEqualTo(month);
		List<TotalReport> list = totalReportMapper.selectByExample(example);
		for (TotalReport report : list) {
			if(totalReport.getId().compareTo(report.getId())!=0){
				throw new Exception("该月已存在数据");
			}
		}
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),totalReport.getId(), "更新总量数据信息"));
		return totalReportMapper.updateByPrimaryKey(totalReport);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除总量数据信息"));
		}
		TotalReportExample de=new TotalReportExample();
		de.createCriteria().andIdIn(ids);
		return totalReportMapper.deleteByExample(de);
	}
	
	@Override
	public TotalReport queryById(Integer id){
		return totalReportMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public TotalReportLtResp queryList(TotalReportReq req) throws Exception {
		Integer id = req.getId();
		BigDecimal totalSales = req.getTotalSales();
		Integer year = req.getYear();
		Integer month = req.getMonth();
		Date createTime = req.getCreateTime();
		TotalReportExample de=new TotalReportExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(totalSales)){
			c.andTotalSalesEqualTo(totalSales);
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
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<TotalReport> page = (Page<TotalReport>) totalReportMapper.selectByExample(de);
		TotalReportLtResp resp = new TotalReportLtResp();
		resp.setCount(page.getTotal());
		resp.setTotalReportLt(page.getResult());
		return resp;
	}
	
}
