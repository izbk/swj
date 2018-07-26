package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.WeixinAutoResponse;
import cn.com.yuanwei.center.entity.WeixinAutoResponseExample;
import cn.com.yuanwei.center.entity.WeixinAutoResponseExample.Criteria;
import cn.com.yuanwei.center.mapper.WeixinAutoResponseMapper;
import cn.com.yuanwei.center.service.WeixinAutoResponseService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.WeixinAutoResponseReq;
import cn.com.yuanwei.center.web.response.WeixinAutoResponseLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class WeixinAutoResponseServiceImpl implements WeixinAutoResponseService {
	@Autowired
	private WeixinAutoResponseMapper weixinAutoResponseMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(WeixinAutoResponse weixinAutoResponse) throws Exception {
		Date currDate = new Date();
		weixinAutoResponse.setCreateTime(currDate);
		weixinAutoResponseMapper.insert(weixinAutoResponse);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,weixinAutoResponse.getId(), "新增自动回复"));		
		return weixinAutoResponse.getId();
	}

	@Override
	public Integer update(WeixinAutoResponse weixinAutoResponse) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),weixinAutoResponse.getId(), "更新自动回复"));
		return weixinAutoResponseMapper.updateByPrimaryKey(weixinAutoResponse);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除自动回复"));
		}	
		WeixinAutoResponseExample example = new WeixinAutoResponseExample();
		example.createCriteria().andIdIn(ids);
		return weixinAutoResponseMapper.deleteByExample(example);
	}
	
	@Override
	public WeixinAutoResponse queryById(Integer id){
		return weixinAutoResponseMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public WeixinAutoResponseLtResp queryList(WeixinAutoResponseReq req) throws Exception {
		Integer id = req.getId();
		String keyWord = req.getKeyWord();
		String msgType = req.getMsgType();
		String resContent = req.getResContent();
		Date createTime = req.getCreateTime();
		WeixinAutoResponseExample example = new WeixinAutoResponseExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(keyWord)){
			c.andKeyWordEqualTo(keyWord);
		}
		if(!ValidateUtil.isEmpty(msgType)){
			c.andMsgTypeEqualTo(msgType);
		}
		if(!ValidateUtil.isEmpty(resContent)){
			c.andResContentEqualTo(resContent);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<WeixinAutoResponse> page = (Page<WeixinAutoResponse>) weixinAutoResponseMapper.selectByExample(example);
		WeixinAutoResponseLtResp resp = new WeixinAutoResponseLtResp();
		resp.setCount(page.getTotal());
		resp.setWeixinAutoResponseLt(page.getResult());
		return resp;
	}
	
}
