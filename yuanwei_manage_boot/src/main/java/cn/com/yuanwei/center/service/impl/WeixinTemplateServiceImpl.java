package cn.com.yuanwei.center.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.riversoft.weixin.mp.template.Data;
import com.riversoft.weixin.mp.template.Templates;

import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.User;
import cn.com.yuanwei.center.entity.UserExample;
import cn.com.yuanwei.center.entity.WeixinTemplate;
import cn.com.yuanwei.center.entity.WeixinTemplateExample;
import cn.com.yuanwei.center.entity.WeixinTemplateExample.Criteria;
import cn.com.yuanwei.center.entity.WeixinTemplateRecord;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.UserMapper;
import cn.com.yuanwei.center.mapper.WeixinTemplateMapper;
import cn.com.yuanwei.center.mapper.WeixinTemplateRecordMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.TypeService;
import cn.com.yuanwei.center.service.WeixinTemplateService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.WeixinTemplateReq;
import cn.com.yuanwei.center.web.response.WeixinTemplateLtResp;

@Service
@Transactional
public class WeixinTemplateServiceImpl implements WeixinTemplateService {
	@Autowired
	private WeixinTemplateMapper weixinTemplateMapper;
	@Autowired
	private WeixinTemplateRecordMapper weixinTemplateRecordMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TypeService typeService;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	 
	@Override
	public Integer save(WeixinTemplate weixinTemplate) throws Exception {
		weixinTemplateMapper.insert(weixinTemplate);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),weixinTemplate.getId(), "新增微信模板消息"));
		return weixinTemplate.getId();
	}

	@Override
	public Integer update(WeixinTemplate weixinTemplate) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),weixinTemplate.getId(), "更新微信模板消息"));
		return weixinTemplateMapper.updateByPrimaryKey(weixinTemplate);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除微信模板消息"));
		}
		WeixinTemplateExample de=new WeixinTemplateExample();
		de.createCriteria().andIdIn(ids);
		return weixinTemplateMapper.deleteByExample(de);
	}
	
	@Override
	public WeixinTemplate queryById(Integer id){
		return weixinTemplateMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public WeixinTemplateLtResp queryList(WeixinTemplateReq req) throws Exception {
		Integer id = req.getId();
		Integer noticeType = req.getNoticeType();
		String content = req.getContent();
		String remark = req.getRemark();
		WeixinTemplateExample de=new WeixinTemplateExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(noticeType)){
			c.andNoticeTypeEqualTo(noticeType);
		}
		if(!ValidateUtil.isEmpty(content)){
			c.andContentEqualTo(content);
		}
		if(!ValidateUtil.isEmpty(remark)){
			c.andRemarkEqualTo(remark);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<WeixinTemplate> page = (Page<WeixinTemplate>) weixinTemplateMapper.selectByExample(de);
		WeixinTemplateLtResp resp = new WeixinTemplateLtResp();
		resp.setCount(page.getTotal());
		resp.setWeixinTemplateLt(page.getResult());
		return resp;
	}
	
	@Override
	public void send(List<Integer> userIds,Integer id) throws Exception {
		WeixinTemplate template = weixinTemplateMapper.selectByPrimaryKey(id);
		if(ValidateUtil.isEmpty(template)){
			throw new Exception("未获取到模板信息");
		}
		if(ValidateUtil.isEmpty(userIds)){
			throw new Exception("待发送的人员信息为空");
		}
		Templates templates = Templates.defaultTemplates();
		//获取微信模板ID
		String templateId = templates.fetch("OPENTM204880112");
		//准备并组装数据
		Integer noticeType = template.getNoticeType();
		String typeName = typeService.getTypeName("noticeType", noticeType.toString());
		Map<String, Data> data = new HashMap<>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String color = "#173177";
		data.put("first", new Data("您有以下工作需要按时完成。", color));
        data.put("keyword1", new Data(typeName, color));
        data.put("keyword2", new Data(format.format(new Date()), color));
        data.put("keyword3", new Data(template.getContent(), color));
        data.put("remark", new Data(template.getRemark(), color));
        
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(userIds);
        List<User> users = userMapper.selectByExample(example);
        
        //批量发送
        for (User user : users) {
        	templates.send(user.getOpenId(), templateId, "", data);
		}
        //记录发送模板日志
        Date currDate = Calendar.getInstance().getTime();
        UserInfo userInfo = LoginUserThread.getUser();
        Integer createBy = userInfo.getId();
        String createName = userInfo.getNickName();
        for (User user : users) {
        	WeixinTemplateRecord weixinTemplateRecord = new WeixinTemplateRecord();
        	weixinTemplateRecord.setTemplateId(id);
        	weixinTemplateRecord.setNoticeType(noticeType);
        	weixinTemplateRecord.setContent(template.getContent());
        	weixinTemplateRecord.setOpenId(user.getOpenId());
        	weixinTemplateRecord.setUserId(user.getId());
        	weixinTemplateRecord.setNickName(user.getNickName());
        	weixinTemplateRecord.setCreateTime(currDate);
        	weixinTemplateRecord.setCreateBy(createBy);
        	weixinTemplateRecord.setCreateName(createName);
        	weixinTemplateRecordMapper.insertSelective(weixinTemplateRecord);
		}
	}
	
}
