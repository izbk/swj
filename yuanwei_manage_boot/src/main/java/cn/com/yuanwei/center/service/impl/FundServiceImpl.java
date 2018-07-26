package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.Fund;
import cn.com.yuanwei.center.entity.FundExample;
import cn.com.yuanwei.center.entity.FundExample.Criteria;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.enums.IsEnum;
import cn.com.yuanwei.center.enums.RoleTypeEnum;
import cn.com.yuanwei.center.mapper.DepartmentMapper;
import cn.com.yuanwei.center.mapper.FundMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.FundService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.FundReq;
import cn.com.yuanwei.center.web.response.FundLtResp;
import cn.com.yuanwei.center.web.response.FundResp;

@Service
@Transactional
public class FundServiceImpl implements FundService {
	@Autowired
	private FundMapper fundMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(Fund fund) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		fund.setDepartId(userInfo.getDepartId());
		fund.setDepartName(departmentMapper.selectByPrimaryKey(userInfo.getDepartId()).getDepartname());
		fund.setCreateBy(userInfo.getId());
		fund.setCreateTime(currDate);
		//设置indexId
 		if(fund != null && fund.getPid() != null){
 			Integer pId = fund.getPid();
 			String pIndexId = "";
 			if(pId != null){
 				pIndexId = fundMapper.selectByPrimaryKey(pId).getIndexId();
 			}
 			if(pIndexId== null || pIndexId.isEmpty()){
 				fund.setIndexId(pId.toString());
 			}else{
 				fund.setIndexId(pIndexId+"_"+pId);
 			}
 		}
 		fund.setIsValid(IsEnum.yes.getCode());
 		BigDecimal amount = fund.getAmount();
 		BigDecimal realAmount = fund.getRealAmount();
 		if(realAmount.compareTo(amount)>0){
 			throw new Exception("实际拨款金额大于应拨款金额");
 		}
 		BigDecimal noAmount = amount.subtract(realAmount);
 		fund.setNoAmount(noAmount);
 		fund.setSurplusAmount(realAmount);
		fundMapper.insert(fund);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,fund.getId(), "新增项目资金信息"));		
		return fund.getId();
	}

	@Override
	public Integer update(Fund fund) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),fund.getId(), "更新项目资金信息"));
		//设置indexId
 		if(fund != null && fund.getPid() != null){
 			Integer pId = fund.getPid();
 			String pIndexId = "";
 			if(pId != null){
 				pIndexId = fundMapper.selectByPrimaryKey(pId).getIndexId();
 			}
 			if(pIndexId== null || pIndexId.isEmpty()){
 				fund.setIndexId(pId.toString());
 			}else{
 				fund.setIndexId(pIndexId+"_"+pId);
 			}
 		}
 		BigDecimal amount = fund.getAmount();
 		BigDecimal realAmount = fund.getRealAmount();
 		if(realAmount.compareTo(amount)>0){
 			throw new Exception("实际拨款金额大于应拨款金额");
 		}
 		BigDecimal noAmount = amount.subtract(realAmount);
 		fund.setNoAmount(noAmount);
 		fund.setSurplusAmount(realAmount);
		return fundMapper.updateByPrimaryKey(fund);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除项目资金信息"));
		}	
		FundExample example = new FundExample();
		example.createCriteria().andIdIn(ids);
		return fundMapper.deleteByExample(example);
	}
	
	@Override
	public Fund queryById(Integer id){
		return fundMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public FundLtResp queryList(FundReq req) throws Exception {
		Integer id = req.getId();
		Integer departId = req.getDepartId();
		String departName = req.getDepartName();
		String fundName = req.getFundName();
		Date approDate = req.getApproDate();
		BigDecimal amount = req.getAmount();
		BigDecimal realAmount = req.getRealAmount();
		BigDecimal noAmount = req.getNoAmount();
		BigDecimal surplusAmount = req.getSurplusAmount();
		String voucherNo = req.getVoucherNo();
		Integer pid = req.getPid();
		String indexId = req.getIndexId();
		String superiorFile = req.getSuperiorFile();
		String localFile = req.getLocalFile();
		String remark = req.getRemark();
		Integer isValid = req.getIsValid();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		FundExample example = new FundExample();
		example.setOrderByClause("id desc");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(departId)){
			c.andDepartIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(departName)){
			c.andDepartNameLike("%"+departName+"%");
		}
		if(!ValidateUtil.isEmpty(fundName)){
			c.andFundNameLike("%"+fundName+"%");
		}
		if(!ValidateUtil.isEmpty(approDate)){
			c.andApproDateEqualTo(approDate);
		}
		if(!ValidateUtil.isEmpty(amount)){
			c.andAmountEqualTo(amount);
		}
		if(!ValidateUtil.isEmpty(realAmount)){
			c.andRealAmountEqualTo(realAmount);
		}
		if(!ValidateUtil.isEmpty(noAmount)){
			c.andNoAmountEqualTo(noAmount);
		}
		if(!ValidateUtil.isEmpty(surplusAmount)){
			c.andSurplusAmountEqualTo(surplusAmount);
		}
		if(!ValidateUtil.isEmpty(voucherNo)){
			c.andVoucherNoEqualTo(voucherNo);
		}
		if(!ValidateUtil.isEmpty(pid)){
			c.andPidEqualTo(pid);
		}
		if(!ValidateUtil.isEmpty(indexId)){
			c.andIndexIdEqualTo(indexId);
		}
		if(!ValidateUtil.isEmpty(superiorFile)){
			c.andSuperiorFileEqualTo(superiorFile);
		}
		if(!ValidateUtil.isEmpty(localFile)){
			c.andLocalFileEqualTo(localFile);
		}
		if(!ValidateUtil.isEmpty(remark)){
			c.andRemarkEqualTo(remark);
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
		//机构过滤
		UserInfo userInfo = LoginUserThread.getUser();
		if(!(RoleTypeEnum.admin.getCode().compareTo(userInfo.getRoleId())==0)&&!ValidateUtil.isEmpty(userInfo.getDepartId())){
			c.andDepartIdEqualTo(userInfo.getDepartId());
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Fund> page = (Page<Fund>) fundMapper.selectByExample(example);
		FundLtResp resp = new FundLtResp();
		resp.setCount(page.getTotal());
		resp.setFundLt(page.getResult());
		return resp;
	}

	@Override
	public List<FundResp> queryAllList(FundReq req) throws Exception {
		Integer isValid = req.getIsValid();
		FundExample example = new FundExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(isValid)){
			c.andIsValidEqualTo(isValid);
		}
		//机构过滤
		UserInfo userInfo = LoginUserThread.getUser();
		if(!(RoleTypeEnum.admin.getCode().compareTo(userInfo.getRoleId())==0)&&!ValidateUtil.isEmpty(userInfo.getDepartId())){
			c.andDepartIdEqualTo(userInfo.getDepartId());
		}
		List<Fund> funds = fundMapper.selectByExample(example);
		return convertFundLt(funds);
	}
	
	/**
	 * 转换为树形列表
	 * @param funds
	 * @return List<FundResp>
	 * @throws Exception
	 */
	private List<FundResp> convertFundLt(List<Fund> funds) throws Exception {
		List<FundResp> fundTreeList = new ArrayList<FundResp>();
		for(Fund fund:funds){
			if(ValidateUtil.isEmpty(fund.getPid())){
				FundResp item = new FundResp();
				BeanUtils.copyProperties(fund, item);
				item.setChildren(this.tree(funds, fund.getId()));
				fundTreeList.add(item);
			}
		}
		return fundTreeList;
	}
	
	private List<FundResp> tree(List<Fund> funds,Integer id){
		List<FundResp> resp = new ArrayList<>();
		for(Fund sub:funds){
			if(id.equals(sub.getPid())){
				FundResp subitem = new FundResp();
				BeanUtils.copyProperties(sub, subitem);
				List<FundResp> respLt = this.tree(funds, sub.getId());
				if(!ValidateUtil.isEmpty(respLt)){
					subitem.setChildren(respLt);
				}
				resp.add(subitem);
			}
		}
		return resp;
	}
	
}
