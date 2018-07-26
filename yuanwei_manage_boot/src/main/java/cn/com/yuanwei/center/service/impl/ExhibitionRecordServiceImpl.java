package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.ExhibitionRecord;
import cn.com.yuanwei.center.entity.ExhibitionRecordExample;
import cn.com.yuanwei.center.entity.ExhibitionRecordExample.Criteria;
import cn.com.yuanwei.center.mapper.ExhibitionRecordMapper;
import cn.com.yuanwei.center.service.ExhibitionRecordService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ExhibitionRecordReq;
import cn.com.yuanwei.center.web.response.ExhibitionRecordLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class ExhibitionRecordServiceImpl implements ExhibitionRecordService {
	@Autowired
	private ExhibitionRecordMapper exhibitionRecordMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(ExhibitionRecord exhibitionRecord) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		exhibitionRecord.setCreateBy(userInfo.getId());
		exhibitionRecord.setCreateTime(currDate);
		exhibitionRecordMapper.insert(exhibitionRecord);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,exhibitionRecord.getId(), "新增会展备案信息"));		
		return exhibitionRecord.getId();
	}

	@Override
	public Integer update(ExhibitionRecord exhibitionRecord) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),exhibitionRecord.getId(), "更新会展备案信息"));
		return exhibitionRecordMapper.updateByPrimaryKey(exhibitionRecord);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除会展备案信息"));
		}	
		ExhibitionRecordExample example = new ExhibitionRecordExample();
		example.createCriteria().andIdIn(ids);
		return exhibitionRecordMapper.deleteByExample(example);
	}
	
	@Override
	public ExhibitionRecord queryById(Integer id){
		return exhibitionRecordMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ExhibitionRecordLtResp queryList(ExhibitionRecordReq req) throws Exception {
		Integer id = req.getId();
		String exhibitionName = req.getExhibitionName();
		String address = req.getAddress();
		Date startDate = req.getStartDate();
		Date endDate = req.getEndDate();
		String organizer = req.getOrganizer();
		String exhibitor = req.getExhibitor();
		String coorganizer = req.getCoorganizer();
		String exhibitionType = req.getExhibitionType();
		String introduction = req.getIntroduction();
		String charge = req.getCharge();
		String chargeMobile = req.getChargeMobile();
		String contact = req.getContact();
		String contactMobile = req.getContactMobile();
		Integer stands = req.getStands();
		BigDecimal standArea = req.getStandArea();
		Integer numbers = req.getNumbers();
		String applicant = req.getApplicant();
		Date applyTime = req.getApplyTime();
		String recordOpinion = req.getRecordOpinion();
		Date recordTime = req.getRecordTime();
		String remark = req.getRemark();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		ExhibitionRecordExample example = new ExhibitionRecordExample();
		example.setOrderByClause("id desc");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(exhibitionName)){
			c.andExhibitionNameLike("%"+exhibitionName+"%");
		}
		if(!ValidateUtil.isEmpty(address)){
			c.andAddressEqualTo(address);
		}
		if(!ValidateUtil.isEmpty(startDate)){
			c.andStartDateEqualTo(startDate);
		}
		if(!ValidateUtil.isEmpty(endDate)){
			c.andEndDateEqualTo(endDate);
		}
		if(!ValidateUtil.isEmpty(organizer)){
			c.andOrganizerEqualTo(organizer);
		}
		if(!ValidateUtil.isEmpty(exhibitor)){
			c.andExhibitorEqualTo(exhibitor);
		}
		if(!ValidateUtil.isEmpty(coorganizer)){
			c.andCoorganizerEqualTo(coorganizer);
		}
		if(!ValidateUtil.isEmpty(exhibitionType)){
			c.andExhibitionTypeEqualTo(exhibitionType);
		}
		if(!ValidateUtil.isEmpty(introduction)){
			c.andIntroductionEqualTo(introduction);
		}
		if(!ValidateUtil.isEmpty(charge)){
			c.andChargeEqualTo(charge);
		}
		if(!ValidateUtil.isEmpty(chargeMobile)){
			c.andChargeMobileEqualTo(chargeMobile);
		}
		if(!ValidateUtil.isEmpty(contact)){
			c.andContactEqualTo(contact);
		}
		if(!ValidateUtil.isEmpty(contactMobile)){
			c.andContactMobileEqualTo(contactMobile);
		}
		if(!ValidateUtil.isEmpty(stands)){
			c.andStandsEqualTo(stands);
		}
		if(!ValidateUtil.isEmpty(standArea)){
			c.andStandAreaEqualTo(standArea);
		}
		if(!ValidateUtil.isEmpty(numbers)){
			c.andNumbersEqualTo(numbers);
		}
		if(!ValidateUtil.isEmpty(applicant)){
			c.andApplicantEqualTo(applicant);
		}
		if(!ValidateUtil.isEmpty(applyTime)){
			c.andApplyTimeEqualTo(applyTime);
		}
		if(!ValidateUtil.isEmpty(recordOpinion)){
			c.andRecordOpinionEqualTo(recordOpinion);
		}
		if(!ValidateUtil.isEmpty(recordTime)){
			c.andRecordTimeEqualTo(recordTime);
		}
		if(!ValidateUtil.isEmpty(remark)){
			c.andRemarkEqualTo(remark);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<ExhibitionRecord> page = (Page<ExhibitionRecord>) exhibitionRecordMapper.selectByExample(example);
		ExhibitionRecordLtResp resp = new ExhibitionRecordLtResp();
		resp.setCount(page.getTotal());
		resp.setExhibitionRecordLt(page.getResult());
		return resp;
	}
	
}
