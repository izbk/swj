package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.Exhibition;
import cn.com.yuanwei.center.entity.ExhibitionExample;
import cn.com.yuanwei.center.entity.ExhibitionExample.Criteria;
import cn.com.yuanwei.center.mapper.ExhibitionMapper;
import cn.com.yuanwei.center.service.ExhibitionService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ExhibitionReq;
import cn.com.yuanwei.center.web.response.ExhibitionLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.enums.IsEnum;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class ExhibitionServiceImpl implements ExhibitionService {
	@Autowired
	private ExhibitionMapper exhibitionMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(Exhibition exhibition) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		exhibition.setCreateBy(userInfo.getId());
		exhibition.setCreateTime(currDate);
		exhibition.setIsValid(IsEnum.yes.getCode());
		exhibitionMapper.insert(exhibition);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,exhibition.getId(), "新增会展信息"));		
		return exhibition.getId();
	}

	@Override
	public Integer update(Exhibition exhibition) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),exhibition.getId(), "更新会展信息"));
		return exhibitionMapper.updateByPrimaryKey(exhibition);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除会展信息"));
		}	
		ExhibitionExample example = new ExhibitionExample();
		example.createCriteria().andIdIn(ids);
		return exhibitionMapper.deleteByExample(example);
	}
	
	@Override
	public Exhibition queryById(Integer id){
		return exhibitionMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ExhibitionLtResp queryList(ExhibitionReq req) throws Exception {
		Integer id = req.getId();
		String exhibitionName = req.getExhibitionName();
		String address = req.getAddress();
		Date startDate = req.getStartDate();
		Date endDate = req.getEndDate();
		Integer exhibitionType = req.getExhibitionType();
		String introduction = req.getIntroduction();
		Integer isValid = req.getIsValid();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		ExhibitionExample example = new ExhibitionExample();
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
		if(!ValidateUtil.isEmpty(exhibitionType)){
			c.andExhibitionTypeEqualTo(exhibitionType);
		}
		if(!ValidateUtil.isEmpty(introduction)){
			c.andIntroductionEqualTo(introduction);
		}
		if(!ValidateUtil.isEmpty(isValid)){
			c.andIsValidEqualTo(isValid);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Exhibition> page = (Page<Exhibition>) exhibitionMapper.selectByExample(example);
		ExhibitionLtResp resp = new ExhibitionLtResp();
		resp.setCount(page.getTotal());
		resp.setExhibitionLt(page.getResult());
		return resp;
	}
	
}
