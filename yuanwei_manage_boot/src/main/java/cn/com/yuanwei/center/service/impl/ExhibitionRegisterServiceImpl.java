package cn.com.yuanwei.center.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.Exhibition;
import cn.com.yuanwei.center.entity.ExhibitionRegister;
import cn.com.yuanwei.center.entity.ExhibitionRegisterExample;
import cn.com.yuanwei.center.entity.ExhibitionRegisterExample.Criteria;
import cn.com.yuanwei.center.entity.ExhibitionRegisterVo;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.TypeExample;
import cn.com.yuanwei.center.mapper.ExhibitionMapper;
import cn.com.yuanwei.center.mapper.ExhibitionRegisterMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.TypeMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.ExhibitionRegisterService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ExhibitionRegisterReq;
import cn.com.yuanwei.center.web.response.ExhibitionRegisterLtResp;

@Service
@Transactional
public class ExhibitionRegisterServiceImpl implements ExhibitionRegisterService {
	@Autowired
	private ExhibitionRegisterMapper exhibitionRegisterMapper;
	@Autowired
	private ExhibitionMapper exhibitionMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	@Autowired
	private TypeMapper typeMapper;
	
	@Override
	public Integer save(ExhibitionRegister exhibitionRegister) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		exhibitionRegister.setRegTime(currDate);
		Exhibition exhibition = exhibitionMapper.selectByPrimaryKey(exhibitionRegister.getExhibitionId());
		if(ValidateUtil.isEmpty(exhibition)){
			throw new Exception("未获取到会展名称");
		}
		Date enterDate = exhibitionRegister.getEnterDate();
		Date startDate = exhibition.getStartDate();
		Date endDate = exhibition.getEndDate();
		if(enterDate.compareTo(startDate)<0 || enterDate.compareTo(endDate)>0){
			throw new Exception("参会时间有误");
		}
		Integer[] honors = exhibitionRegister.getHonors();
		String honor = StringUtils.join(honors,",");
		exhibitionRegister.setHonor(honor);
		exhibitionRegister.setExhibitionName(exhibition.getExhibitionName());
		exhibitionRegisterMapper.insert(exhibitionRegister);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,exhibitionRegister.getId(), "新增会展报名信息"));		
		return exhibitionRegister.getId();
	}

	@Override
	public Integer update(ExhibitionRegister exhibitionRegister) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),exhibitionRegister.getId(), "更新会展报名信息"));
		Integer[] honors = exhibitionRegister.getHonors();
		String honor = StringUtils.join(honors,",");
		exhibitionRegister.setHonor(honor);
		return exhibitionRegisterMapper.updateByPrimaryKey(exhibitionRegister);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除会展报名信息"));
		}	
		ExhibitionRegisterExample example = new ExhibitionRegisterExample();
		example.createCriteria().andIdIn(ids);
		return exhibitionRegisterMapper.deleteByExample(example);
	}
	
	@Override
	public ExhibitionRegister queryById(Integer id){
		return exhibitionRegisterMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ExhibitionRegisterLtResp queryList(ExhibitionRegisterReq req) throws Exception {
		Integer id = req.getId();
		Integer exhibitionId = req.getExhibitionId();
		String exhibitionName = req.getExhibitionName();
		String enterpiseName = req.getEnterpiseName();
		String contact = req.getContact();
		Integer participantNum = req.getParticipantNum();
		Integer exhiProductType = req.getExhiProductType();
		Integer boothNum = req.getBoothNum();
		String honor = req.getHonor();
		Date enterDate = req.getEnterDate();
		String feedback = req.getFeedback();
		Date regTime = req.getRegTime();
		Date feedTime = req.getFeedTime();
		ExhibitionRegisterExample example = new ExhibitionRegisterExample();
		example.setOrderByClause("id desc");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(exhibitionId)){
			c.andExhibitionIdEqualTo(exhibitionId);
		}
		if(!ValidateUtil.isEmpty(exhibitionName)){
			c.andExhibitionNameLike("%"+exhibitionName+"%");
		}
		if(!ValidateUtil.isEmpty(enterpiseName)){
			c.andEnterpiseNameLike("%"+enterpiseName+"%");
		}
		if(!ValidateUtil.isEmpty(contact)){
			c.andContactEqualTo(contact);
		}
		if(!ValidateUtil.isEmpty(participantNum)){
			c.andParticipantNumEqualTo(participantNum);
		}
		if(!ValidateUtil.isEmpty(exhiProductType)){
			c.andExhiProductTypeEqualTo(exhiProductType);
		}
		if(!ValidateUtil.isEmpty(boothNum)){
			c.andBoothNumEqualTo(boothNum);
		}
		if(!ValidateUtil.isEmpty(honor)){
			c.andHonorLike("%"+honor+"%");
		}
		if(!ValidateUtil.isEmpty(enterDate)){
			c.andEnterDateEqualTo(enterDate);
		}
		if(!ValidateUtil.isEmpty(feedback)){
			c.andFeedbackEqualTo(feedback);
		}
		if(!ValidateUtil.isEmpty(regTime)){
			c.andRegTimeEqualTo(regTime);
		}
		if(!ValidateUtil.isEmpty(feedTime)){
			c.andFeedTimeEqualTo(feedTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<ExhibitionRegister> page = (Page<ExhibitionRegister>) exhibitionRegisterMapper.selectByExample(example);
		for (int i = 0; i < page.size(); i++) {
			ExhibitionRegister reg = page.get(i);
			String StrHonor = reg.getHonor();
			if(!ValidateUtil.isEmpty(StrHonor)){
				String[] arr = StrHonor.split(",");
				Integer[] iarr = new Integer[arr.length];
				for (int j = 0; j < arr.length; j++) {
					iarr[j] = Integer.parseInt(arr[j]);
				}
				reg.setHonors(iarr);
			}
		}
		ExhibitionRegisterLtResp resp = new ExhibitionRegisterLtResp();
		resp.setCount(page.getTotal());
		resp.setExhibitionRegisterLt(page.getResult());
		return resp;
	}
	@Override
	public List<ExhibitionRegisterVo> queryListForExport(ExhibitionRegisterReq req) throws Exception {
		Integer id = req.getId();
		Integer exhibitionId = req.getExhibitionId();
		String exhibitionName = req.getExhibitionName();
		String enterpiseName = req.getEnterpiseName();
		String contact = req.getContact();
		Integer participantNum = req.getParticipantNum();
		Integer exhiProductType = req.getExhiProductType();
		Integer boothNum = req.getBoothNum();
		String honor = req.getHonor();
		Date enterDate = req.getEnterDate();
		String feedback = req.getFeedback();
		Date regTime = req.getRegTime();
		Date feedTime = req.getFeedTime();
		ExhibitionRegisterExample example = new ExhibitionRegisterExample();
		example.setOrderByClause("id desc");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(exhibitionId)){
			c.andExhibitionIdEqualTo(exhibitionId);
		}
		if(!ValidateUtil.isEmpty(exhibitionName)){
			c.andExhibitionNameLike("%"+exhibitionName+"%");
		}
		if(!ValidateUtil.isEmpty(enterpiseName)){
			c.andEnterpiseNameLike("%"+enterpiseName+"%");
		}
		if(!ValidateUtil.isEmpty(contact)){
			c.andContactEqualTo(contact);
		}
		if(!ValidateUtil.isEmpty(participantNum)){
			c.andParticipantNumEqualTo(participantNum);
		}
		if(!ValidateUtil.isEmpty(exhiProductType)){
			c.andExhiProductTypeEqualTo(exhiProductType);
		}
		if(!ValidateUtil.isEmpty(boothNum)){
			c.andBoothNumEqualTo(boothNum);
		}
		if(!ValidateUtil.isEmpty(honor)){
			c.andHonorLike("%"+honor+"%");
		}
		if(!ValidateUtil.isEmpty(enterDate)){
			c.andEnterDateEqualTo(enterDate);
		}
		if(!ValidateUtil.isEmpty(feedback)){
			c.andFeedbackEqualTo(feedback);
		}
		if(!ValidateUtil.isEmpty(regTime)){
			c.andRegTimeEqualTo(regTime);
		}
		if(!ValidateUtil.isEmpty(feedTime)){
			c.andFeedTimeEqualTo(feedTime);
		}
		List<ExhibitionRegisterVo> list = exhibitionRegisterMapper.selectByExampleForExport(example);
		for (int i = 0; i < list.size(); i++) {
			ExhibitionRegisterVo vo = list.get(i);
			if(!ValidateUtil.isEmpty(vo.getHonor())){
				TypeExample te = new TypeExample();
				te.createCriteria().andTypeGroupIdEqualTo(41).andTypeCodeIn(Arrays.asList(vo.getHonor().split(",")));
				vo.setHonor(typeMapper.selectTypeCodesToString(te));
			}
		}
		return list;
	}
	
}
