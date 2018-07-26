package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.WeixinTemplateRecord;
import cn.com.yuanwei.center.entity.WeixinTemplateRecordExample;
import cn.com.yuanwei.center.entity.WeixinTemplateRecordExample.Criteria;
import cn.com.yuanwei.center.mapper.WeixinTemplateRecordMapper;
import cn.com.yuanwei.center.service.WeixinTemplateRecordService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.WeixinTemplateRecordReq;
import cn.com.yuanwei.center.web.response.WeixinTemplateRecordLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class WeixinTemplateRecordServiceImpl implements WeixinTemplateRecordService {
	@Autowired
	private WeixinTemplateRecordMapper weixinTemplateRecordMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(WeixinTemplateRecord weixinTemplateRecord) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		weixinTemplateRecord.setCreateBy(userInfo.getId());
		weixinTemplateRecord.setCreateTime(currDate);
		weixinTemplateRecordMapper.insert(weixinTemplateRecord);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,weixinTemplateRecord.getId(), "新增微信模板消息发送记录"));		
		return weixinTemplateRecord.getId();
	}

	@Override
	public Integer update(WeixinTemplateRecord weixinTemplateRecord) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),weixinTemplateRecord.getId(), "更新微信模板消息发送记录"));
		return weixinTemplateRecordMapper.updateByPrimaryKey(weixinTemplateRecord);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除微信模板消息发送记录"));
		}	
		WeixinTemplateRecordExample example = new WeixinTemplateRecordExample();
		example.createCriteria().andIdIn(ids);
		return weixinTemplateRecordMapper.deleteByExample(example);
	}
	
	@Override
	public WeixinTemplateRecord queryById(Integer id){
		return weixinTemplateRecordMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public WeixinTemplateRecordLtResp queryList(WeixinTemplateRecordReq req) throws Exception {
		Integer id = req.getId();
		Integer templateId = req.getTemplateId();
		Integer noticeType = req.getNoticeType();
		String content = req.getContent();
		Integer userId = req.getUserId();
		String openId = req.getOpenId();
		String nickName = req.getNickName();
		Integer createBy = req.getCreateBy();
		String createName = req.getCreateName();
		Date createTime = req.getCreateTime();
		WeixinTemplateRecordExample example = new WeixinTemplateRecordExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(templateId)){
			c.andTemplateIdEqualTo(templateId);
		}
		if(!ValidateUtil.isEmpty(noticeType)){
			c.andNoticeTypeEqualTo(noticeType);
		}
		if(!ValidateUtil.isEmpty(content)){
			c.andContentEqualTo(content);
		}
		if(!ValidateUtil.isEmpty(userId)){
			c.andUserIdEqualTo(userId);
		}
		if(!ValidateUtil.isEmpty(openId)){
			c.andOpenIdEqualTo(openId);
		}
		if(!ValidateUtil.isEmpty(nickName)){
			c.andNickNameLike("%"+nickName+"%");
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createName)){
			c.andCreateNameLike("%"+createName+"%");
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<WeixinTemplateRecord> page = (Page<WeixinTemplateRecord>) weixinTemplateRecordMapper.selectByExample(example);
		WeixinTemplateRecordLtResp resp = new WeixinTemplateRecordLtResp();
		resp.setCount(page.getTotal());
		resp.setWeixinTemplateRecordLt(page.getResult());
		return resp;
	}
	
}
