package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.SettleRegister;
import cn.com.yuanwei.center.entity.SettleRegisterExample;
import cn.com.yuanwei.center.entity.SettleRegisterExample.Criteria;
import cn.com.yuanwei.center.mapper.SettleRegisterMapper;
import cn.com.yuanwei.center.service.SettleRegisterService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.SettleRegisterReq;
import cn.com.yuanwei.center.web.response.SettleRegisterLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class SettleRegisterServiceImpl implements SettleRegisterService {
	@Autowired
	private SettleRegisterMapper settleRegisterMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(SettleRegister settleRegister) throws Exception {
		Date currDate = new Date();
		settleRegisterMapper.insert(settleRegister);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,settleRegister.getId(), "新增入园申请登记表"));		
		return settleRegister.getId();
	}

	@Override
	public Integer update(SettleRegister settleRegister) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),settleRegister.getId(), "更新入园申请登记表"));
		return settleRegisterMapper.updateByPrimaryKey(settleRegister);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除入园申请登记表"));
		}	
		SettleRegisterExample example = new SettleRegisterExample();
		example.createCriteria().andIdIn(ids);
		return settleRegisterMapper.deleteByExample(example);
	}
	
	@Override
	public SettleRegister queryById(Integer id){
		return settleRegisterMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SettleRegisterLtResp queryList(SettleRegisterReq req) throws Exception {
		Integer id = req.getId();
		String idNumber = req.getIdNumber();
		String name = req.getName();
		Integer sex = req.getSex();
		Integer age = req.getAge();
		String political = req.getPolitical();
		String nativePlace = req.getNativePlace();
		Integer nation = req.getNation();
		String mobile = req.getMobile();
		String email = req.getEmail();
		String address = req.getAddress();
		String pic = req.getPic();
		String businessSubject = req.getBusinessSubject();
		String legalPerson = req.getLegalPerson();
		String businessLicense = req.getBusinessLicense();
		Integer companyType = req.getCompanyType();
		BigDecimal businessIncome = req.getBusinessIncome();
		String businessPlace = req.getBusinessPlace();
		Integer settledPlatform = req.getSettledPlatform();
		String shopName = req.getShopName();
		String shopUrl = req.getShopUrl();
		String creditRating = req.getCreditRating();
		String companyWebsite = req.getCompanyWebsite();
		String category = req.getCategory();
		String averageMonthlySales = req.getAverageMonthlySales();
		Integer applicationRoom = req.getApplicationRoom();
		String applicationArea = req.getApplicationArea();
		Integer equipmentSource = req.getEquipmentSource();
		String businessScope = req.getBusinessScope();
		Integer teamNumber = req.getTeamNumber();
		Integer joinAssociation = req.getJoinAssociation();
		String projectIntroduction = req.getProjectIntroduction();
		Integer status = req.getStatus();
		String remark = req.getRemark();
		SettleRegisterExample example = new SettleRegisterExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(idNumber)){
			c.andIdNumberEqualTo(idNumber);
		}
		if(!ValidateUtil.isEmpty(name)){
			c.andNameLike("%"+name+"%");
		}
		if(!ValidateUtil.isEmpty(sex)){
			c.andSexEqualTo(sex);
		}
		if(!ValidateUtil.isEmpty(age)){
			c.andAgeEqualTo(age);
		}
		if(!ValidateUtil.isEmpty(political)){
			c.andPoliticalEqualTo(political);
		}
		if(!ValidateUtil.isEmpty(nativePlace)){
			c.andNativePlaceEqualTo(nativePlace);
		}
		if(!ValidateUtil.isEmpty(nation)){
			c.andNationEqualTo(nation);
		}
		if(!ValidateUtil.isEmpty(mobile)){
			c.andMobileEqualTo(mobile);
		}
		if(!ValidateUtil.isEmpty(email)){
			c.andEmailEqualTo(email);
		}
		if(!ValidateUtil.isEmpty(address)){
			c.andAddressEqualTo(address);
		}
		if(!ValidateUtil.isEmpty(pic)){
			c.andPicEqualTo(pic);
		}
		if(!ValidateUtil.isEmpty(businessSubject)){
			c.andBusinessSubjectEqualTo(businessSubject);
		}
		if(!ValidateUtil.isEmpty(legalPerson)){
			c.andLegalPersonEqualTo(legalPerson);
		}
		if(!ValidateUtil.isEmpty(businessLicense)){
			c.andBusinessLicenseEqualTo(businessLicense);
		}
		if(!ValidateUtil.isEmpty(companyType)){
			c.andCompanyTypeEqualTo(companyType);
		}
		if(!ValidateUtil.isEmpty(businessIncome)){
			c.andBusinessIncomeEqualTo(businessIncome);
		}
		if(!ValidateUtil.isEmpty(businessPlace)){
			c.andBusinessPlaceEqualTo(businessPlace);
		}
		if(!ValidateUtil.isEmpty(settledPlatform)){
			c.andSettledPlatformEqualTo(settledPlatform);
		}
		if(!ValidateUtil.isEmpty(shopName)){
			c.andShopNameLike("%"+shopName+"%");
		}
		if(!ValidateUtil.isEmpty(shopUrl)){
			c.andShopUrlEqualTo(shopUrl);
		}
		if(!ValidateUtil.isEmpty(creditRating)){
			c.andCreditRatingEqualTo(creditRating);
		}
		if(!ValidateUtil.isEmpty(companyWebsite)){
			c.andCompanyWebsiteEqualTo(companyWebsite);
		}
		if(!ValidateUtil.isEmpty(category)){
			c.andCategoryEqualTo(category);
		}
		if(!ValidateUtil.isEmpty(averageMonthlySales)){
			c.andAverageMonthlySalesEqualTo(averageMonthlySales);
		}
		if(!ValidateUtil.isEmpty(applicationRoom)){
			c.andApplicationRoomEqualTo(applicationRoom);
		}
		if(!ValidateUtil.isEmpty(applicationArea)){
			c.andApplicationAreaEqualTo(applicationArea);
		}
		if(!ValidateUtil.isEmpty(equipmentSource)){
			c.andEquipmentSourceEqualTo(equipmentSource);
		}
		if(!ValidateUtil.isEmpty(businessScope)){
			c.andBusinessScopeEqualTo(businessScope);
		}
		if(!ValidateUtil.isEmpty(teamNumber)){
			c.andTeamNumberEqualTo(teamNumber);
		}
		if(!ValidateUtil.isEmpty(joinAssociation)){
			c.andJoinAssociationEqualTo(joinAssociation);
		}
		if(!ValidateUtil.isEmpty(projectIntroduction)){
			c.andProjectIntroductionEqualTo(projectIntroduction);
		}
		if(!ValidateUtil.isEmpty(status)){
			c.andStatusEqualTo(status);
		}
		if(!ValidateUtil.isEmpty(remark)){
			c.andRemarkEqualTo(remark);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<SettleRegister> page = (Page<SettleRegister>) settleRegisterMapper.selectByExample(example);
		SettleRegisterLtResp resp = new SettleRegisterLtResp();
		resp.setCount(page.getTotal());
		resp.setSettleRegisterLt(page.getResult());
		return resp;
	}
	
}
