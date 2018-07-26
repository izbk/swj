package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.TownshipAnnualTask;
import cn.com.yuanwei.center.entity.TownshipAnnualTaskExample;
import cn.com.yuanwei.center.entity.TownshipAnnualTaskExample.Criteria;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.TownshipAnnualTaskMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.TownshipAnnualTaskService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.TownshipAnnualTaskReq;
import cn.com.yuanwei.center.web.response.TownshipAnnualTaskLtResp;

@Service
@Transactional
public class TownshipAnnualTaskServiceImpl implements TownshipAnnualTaskService {
	@Autowired
	private TownshipAnnualTaskMapper townshipAnnualTaskMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(TownshipAnnualTask townshipAnnualTask) throws Exception {
		Integer townshipId = townshipAnnualTask.getTownshipId();
		Integer year = townshipAnnualTask.getYear();
		TownshipAnnualTaskExample example = new TownshipAnnualTaskExample();
		example.createCriteria().andTownshipIdEqualTo(townshipId).andYearEqualTo(year);
		List<TownshipAnnualTask> list = townshipAnnualTaskMapper.selectByExample(example); 
		if(!ValidateUtil.isEmpty(list)){
			throw new Exception("此乡镇已存在本年度数据");
		}
		UserInfo userInfo = LoginUserThread.getUser();
		townshipAnnualTask.setCreateBy(userInfo.getId());
		townshipAnnualTask.setCreateTime(new Date());
		townshipAnnualTask.setTotalTask(townshipAnnualTask.getRetailSalesTask().add(townshipAnnualTask.getSalesTask()));
		townshipAnnualTaskMapper.insert(townshipAnnualTask);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(), "新增乡年度目标任务信息"));
		return townshipAnnualTask.getId();
	}

	@Override
	public Integer update(TownshipAnnualTask townshipAnnualTask) throws Exception {
		Integer townshipId = townshipAnnualTask.getTownshipId();
		Integer year = townshipAnnualTask.getYear();
		TownshipAnnualTaskExample example = new TownshipAnnualTaskExample();
		example.createCriteria().andTownshipIdEqualTo(townshipId).andYearEqualTo(year);
		List<TownshipAnnualTask> list = townshipAnnualTaskMapper.selectByExample(example); 
		for (TownshipAnnualTask task : list) {
			if(townshipAnnualTask.getId().compareTo(task.getId())!=0){
				throw new Exception("此乡镇已存在本年度数据");
			}
		}
		townshipAnnualTask.setTotalTask(townshipAnnualTask.getRetailSalesTask().add(townshipAnnualTask.getSalesTask()));
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(), "更新乡年度目标任务信息"));
		return townshipAnnualTaskMapper.updateByPrimaryKey(townshipAnnualTask);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除镇乡年度目标任务信息"));
		}
		TownshipAnnualTaskExample example = new TownshipAnnualTaskExample();
		example.createCriteria().andIdIn(ids);
		return townshipAnnualTaskMapper.deleteByExample(example);
	}
	
	@Override
	public TownshipAnnualTask queryById(Integer id){
		return townshipAnnualTaskMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public TownshipAnnualTaskLtResp queryList(TownshipAnnualTaskReq req) throws Exception {
		Integer id = req.getId();
		Integer townshipId = req.getTownshipId();
		String townshipName = req.getTownshipName();
		BigDecimal retailSalesTask = req.getRetailSalesTask();
		BigDecimal salesTask = req.getSalesTask();
		BigDecimal totalTask = req.getTotalTask();
		Integer addTask = req.getAddTask();
		Integer totalApply = req.getTotalApply();
		Integer year = req.getYear();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		TownshipAnnualTaskExample example = new TownshipAnnualTaskExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(townshipId)){
			c.andTownshipIdEqualTo(townshipId);
		}
		if(!ValidateUtil.isEmpty(townshipName)){
			c.andTownshipNameLike("%"+townshipName+"%");
		}
		if(!ValidateUtil.isEmpty(retailSalesTask)){
			c.andRetailSalesTaskEqualTo(retailSalesTask);
		}
		if(!ValidateUtil.isEmpty(salesTask)){
			c.andSalesTaskEqualTo(salesTask);
		}
		if(!ValidateUtil.isEmpty(totalTask)){
			c.andTotalTaskEqualTo(totalTask);
		}
		if(!ValidateUtil.isEmpty(addTask)){
			c.andAddTaskEqualTo(addTask);
		}
		if(!ValidateUtil.isEmpty(totalApply)){
			c.andTotalApplyEqualTo(totalApply);
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<TownshipAnnualTask> page = (Page<TownshipAnnualTask>) townshipAnnualTaskMapper.selectByExample(example);
		TownshipAnnualTaskLtResp resp = new TownshipAnnualTaskLtResp();
		resp.setCount(page.getTotal());
		resp.setTownshipAnnualTaskLt(page.getResult());
		return resp;
	}
	
}
