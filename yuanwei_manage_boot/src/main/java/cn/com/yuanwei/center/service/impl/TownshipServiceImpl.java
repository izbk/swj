package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.Township;
import cn.com.yuanwei.center.entity.TownshipExample;
import cn.com.yuanwei.center.entity.TownshipExample.Criteria;
import cn.com.yuanwei.center.mapper.TownshipMapper;
import cn.com.yuanwei.center.service.TownshipService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.TownshipReq;
import cn.com.yuanwei.center.web.response.TownshipLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class TownshipServiceImpl implements TownshipService {
	@Autowired
	private TownshipMapper townshipMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(Township township) throws Exception {
		Date currDate = new Date();
		townshipMapper.insert(township);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,township.getId(), "新增乡镇信息"));		
		return township.getId();
	}

	@Override
	public Integer update(Township township) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),township.getId(), "更新乡镇信息"));
		return townshipMapper.updateByPrimaryKey(township);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除乡镇信息"));
		}	
		TownshipExample example = new TownshipExample();
		example.createCriteria().andIdIn(ids);
		return townshipMapper.deleteByExample(example);
	}
	
	@Override
	public Township queryById(Integer id){
		return townshipMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public TownshipLtResp queryList(TownshipReq req) throws Exception {
		Integer id = req.getId();
		String name = req.getName();
		String leaderName = req.getLeaderName();
		String leaderMobile = req.getLeaderMobile();
		TownshipExample example = new TownshipExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(name)){
			c.andNameLike("%"+name+"%");
		}
		if(!ValidateUtil.isEmpty(leaderName)){
			c.andLeaderNameLike("%"+leaderName+"%");
		}
		if(!ValidateUtil.isEmpty(leaderMobile)){
			c.andLeaderMobileEqualTo(leaderMobile);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Township> page = (Page<Township>) townshipMapper.selectByExample(example);
		TownshipLtResp resp = new TownshipLtResp();
		resp.setCount(page.getTotal());
		resp.setTownshipLt(page.getResult());
		return resp;
	}
	
}
