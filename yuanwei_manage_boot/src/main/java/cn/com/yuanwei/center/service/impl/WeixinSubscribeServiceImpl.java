package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.WeixinSubscribe;
import cn.com.yuanwei.center.entity.WeixinSubscribeExample;
import cn.com.yuanwei.center.entity.WeixinSubscribeExample.Criteria;
import cn.com.yuanwei.center.mapper.WeixinSubscribeMapper;
import cn.com.yuanwei.center.service.WeixinSubscribeService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.WeixinSubscribeReq;
import cn.com.yuanwei.center.web.response.WeixinSubscribeLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class WeixinSubscribeServiceImpl implements WeixinSubscribeService {
	@Autowired
	private WeixinSubscribeMapper weixinSubscribeMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(WeixinSubscribe weixinSubscribe) throws Exception {
		Date currDate = new Date();
		weixinSubscribe.setCreateTime(currDate);
		weixinSubscribeMapper.insert(weixinSubscribe);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,weixinSubscribe.getId(), "新增欢迎语"));		
		return weixinSubscribe.getId();
	}

	@Override
	public Integer update(WeixinSubscribe weixinSubscribe) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),weixinSubscribe.getId(), "更新欢迎语"));
		return weixinSubscribeMapper.updateByPrimaryKey(weixinSubscribe);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除欢迎语"));
		}	
		WeixinSubscribeExample example = new WeixinSubscribeExample();
		example.createCriteria().andIdIn(ids);
		return weixinSubscribeMapper.deleteByExample(example);
	}
	
	@Override
	public WeixinSubscribe queryById(Integer id){
		return weixinSubscribeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public WeixinSubscribeLtResp queryList(WeixinSubscribeReq req) throws Exception {
		Integer id = req.getId();
		String welcome = req.getWelcome();
		Date createTime = req.getCreateTime();
		WeixinSubscribeExample example = new WeixinSubscribeExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(welcome)){
			c.andWelcomeEqualTo(welcome);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<WeixinSubscribe> page = (Page<WeixinSubscribe>) weixinSubscribeMapper.selectByExample(example);
		WeixinSubscribeLtResp resp = new WeixinSubscribeLtResp();
		resp.setCount(page.getTotal());
		resp.setWeixinSubscribeLt(page.getResult());
		return resp;
	}
	
}
