package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.EnterpriseRise;
import cn.com.yuanwei.center.entity.EnterpriseRiseExample;
import cn.com.yuanwei.center.entity.EnterpriseRiseExample.Criteria;
import cn.com.yuanwei.center.mapper.EnterpriseRiseMapper;
import cn.com.yuanwei.center.service.EnterpriseRiseService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.EnterpriseRiseReq;
import cn.com.yuanwei.center.web.response.EnterpriseRiseLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class EnterpriseRiseServiceImpl implements EnterpriseRiseService {
	@Autowired
	private EnterpriseRiseMapper enterpriseRiseMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(EnterpriseRise enterpriseRise) throws Exception {
		Date currDate = new Date();
		enterpriseRiseMapper.insert(enterpriseRise);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,enterpriseRise.getId(), "新增企业预测增幅设置"));		
		return enterpriseRise.getId();
	}

	@Override
	public Integer update(EnterpriseRise enterpriseRise) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),enterpriseRise.getId(), "更新企业预测增幅设置"));
		return enterpriseRiseMapper.updateByPrimaryKey(enterpriseRise);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除企业预测增幅设置"));
		}	
		EnterpriseRiseExample example = new EnterpriseRiseExample();
		example.createCriteria().andIdIn(ids);
		return enterpriseRiseMapper.deleteByExample(example);
	}
	
	@Override
	public EnterpriseRise queryById(Integer id){
		return enterpriseRiseMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public EnterpriseRiseLtResp queryList(EnterpriseRiseReq req) throws Exception {
		Integer id = req.getId();
		BigDecimal enterCompareRise = req.getEnterCompareRise();
		BigDecimal enterRandomRise = req.getEnterRandomRise();
		BigDecimal personCompareRise = req.getPersonCompareRise();
		BigDecimal personRandomRise = req.getPersonRandomRise();
		BigDecimal reportDifference = req.getReportDifference();
		EnterpriseRiseExample example = new EnterpriseRiseExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(enterCompareRise)){
			c.andEnterCompareRiseEqualTo(enterCompareRise);
		}
		if(!ValidateUtil.isEmpty(enterRandomRise)){
			c.andEnterRandomRiseEqualTo(enterRandomRise);
		}
		if(!ValidateUtil.isEmpty(personCompareRise)){
			c.andPersonCompareRiseEqualTo(personCompareRise);
		}
		if(!ValidateUtil.isEmpty(personRandomRise)){
			c.andPersonRandomRiseEqualTo(personRandomRise);
		}
		if(!ValidateUtil.isEmpty(reportDifference)){
			c.andReportDifferenceEqualTo(reportDifference);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<EnterpriseRise> page = (Page<EnterpriseRise>) enterpriseRiseMapper.selectByExample(example);
		EnterpriseRiseLtResp resp = new EnterpriseRiseLtResp();
		resp.setCount(page.getTotal());
		resp.setEnterpriseRiseLt(page.getResult());
		return resp;
	}
	
}
