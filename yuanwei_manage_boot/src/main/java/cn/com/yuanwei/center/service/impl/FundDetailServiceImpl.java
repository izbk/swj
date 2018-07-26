package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.Fund;
import cn.com.yuanwei.center.entity.FundDetail;
import cn.com.yuanwei.center.entity.FundDetailExample;
import cn.com.yuanwei.center.entity.FundDetailExample.Criteria;
import cn.com.yuanwei.center.enums.RoleTypeEnum;
import cn.com.yuanwei.center.entity.FundExample;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.FundDetailMapper;
import cn.com.yuanwei.center.mapper.FundMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.FundDetailService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.FundDetailReq;
import cn.com.yuanwei.center.web.response.FundDetailLtResp;

@Service
@Transactional
public class FundDetailServiceImpl implements FundDetailService {
	@Autowired
	private FundMapper fundMapper;
	@Autowired
	private FundDetailMapper fundDetailMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(FundDetail fundDetail) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		fundDetail.setCreateBy(userInfo.getId());
		fundDetail.setCreateTime(currDate);
		fundDetail.setApproDate(currDate);
		Fund fund = fundMapper.selectByPrimaryKey(fundDetail.getFundId());
		if(ValidateUtil.isEmpty(fund)){
			throw new Exception("未获取到资金名称");
		}
		fundDetail.setFundName(fund.getFundName());
		BigDecimal approAmount = fundDetail.getApproAmount();
		BigDecimal realApproAmount = fundDetail.getRealApproAmount();
		if(realApproAmount.compareTo(approAmount)>0){
			throw new Exception("实际拨款金额大于应拨款金额");
		}
		//设置未拨余额
		BigDecimal surplusApproAmount = approAmount.subtract(realApproAmount);
		fundDetail.setSurplusApproAmount(surplusApproAmount);
		//判断资金余额
		BigDecimal surplusAmount = fund.getSurplusAmount();
		if(realApproAmount.compareTo(surplusAmount)>0){
			throw new Exception("实际拨款金额大于资金实际余额");
		}
		fundDetailMapper.insert(fundDetail);
		//更新资金信息
		Integer[] fundIds = fundDetail.getFundIds();
		for (int i = 0; i < fundIds.length; i++) {
			Integer fundId = fundIds[i];
			Fund f = fundMapper.selectByPrimaryKey(fundId);
			BigDecimal surplus = f.getSurplusAmount();
			BigDecimal newSurplusAmount = surplus.subtract(realApproAmount);
			f.setSurplusAmount(newSurplusAmount);
			fundMapper.updateByPrimaryKeySelective(f);
		}
		
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,fundDetail.getId(), "新增项目资金拨付信息"));		
		return fundDetail.getId();
	}

	@Override
	public Integer update(FundDetail fundDetail) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),fundDetail.getId(), "更新项目资金拨付信息"));
		BigDecimal approAmount = fundDetail.getApproAmount();
		BigDecimal realApproAmount = fundDetail.getRealApproAmount();
		if(realApproAmount.compareTo(approAmount)>0){
			throw new Exception("实际拨款金额大于应拨款金额");
		}
		//设置未拨余额
		BigDecimal surplusApproAmount = approAmount.subtract(realApproAmount);
		fundDetail.setSurplusApproAmount(surplusApproAmount);
		
		//判断资金余额
		Fund fund = fundMapper.selectByPrimaryKey(fundDetail.getFundId());
		BigDecimal surplusAmount = fund.getSurplusAmount();
		if(realApproAmount.compareTo(surplusAmount)>0){
			throw new Exception("实际拨款金额大于资金实际余额");
		}
		//更新资金信息
		FundDetail oldFundDetail = fundDetailMapper.selectByPrimaryKey(fundDetail.getId());
		BigDecimal oldRealApproAmount = oldFundDetail.getRealApproAmount();
		BigDecimal diffAmount = realApproAmount.subtract(oldRealApproAmount);
		if(diffAmount.compareTo(new BigDecimal("0"))!=0){
			Integer[] fundIds = fundDetail.getFundIds();
			for (int i = 0; i < fundIds.length; i++) {
				Integer fundId = fundIds[i];
				Fund f = fundMapper.selectByPrimaryKey(fundId);
				BigDecimal surplus = f.getSurplusAmount();
				BigDecimal newSurplusAmount = surplus.subtract(diffAmount);
				f.setSurplusAmount(newSurplusAmount);
				fundMapper.updateByPrimaryKeySelective(f);
			}
		}

		return fundDetailMapper.updateByPrimaryKey(fundDetail);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除项目资金拨付信息"));
		}

		FundDetailExample example = new FundDetailExample();
		example.createCriteria().andIdIn(ids);
		List<FundDetail> list = fundDetailMapper.selectByExample(example);
		//更新资金信息
		for (FundDetail fundDetail : list) {
			Integer fundId = fundDetail.getFundId();
			Fund fund = fundMapper.selectByPrimaryKey(fundId);
			String indexId = fund.getIndexId();
			BigDecimal realAmount = fundDetail.getRealApproAmount();
			fund.setSurplusAmount(fund.getSurplusAmount().add(realAmount));
			fundMapper.updateByPrimaryKeySelective(fund);
			if(!ValidateUtil.isEmpty(indexId)){
				String[] fundIds = indexId.split(",");
				for (String id : fundIds) {
					Fund f = fundMapper.selectByPrimaryKey(Integer.valueOf(id));
					f.setSurplusAmount(f.getSurplusAmount().add(realAmount));
					fundMapper.updateByPrimaryKeySelective(f);
				}
			}
		}
		return fundDetailMapper.deleteByExample(example);
	}
	
	@Override
	public FundDetail queryById(Integer id){
		return fundDetailMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public FundDetailLtResp queryList(FundDetailReq req) throws Exception {
		Integer id = req.getId();
		Date year = req.getYear();
		Integer fundId = req.getFundId();
		String fundName = req.getFundName();
		String projectName = req.getProjectName();
		String enterpiseName = req.getEnterpiseName();
		Date approDate = req.getApproDate();
		BigDecimal approAmount = req.getApproAmount();
		BigDecimal realApproAmount = req.getRealApproAmount();
		BigDecimal surplusApproAmount = req.getSurplusApproAmount();
		Date acceptanceDate = req.getAcceptanceDate();
		String voucherNo = req.getVoucherNo();
		String remark = req.getRemark();
		Integer createBy = req.getCreateBy();
		String createName = req.getCreateName();
		Date createTime = req.getCreateTime();
		FundDetailExample example = new FundDetailExample();
		example.setOrderByClause("id desc");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(fundId)){
			c.andFundIdEqualTo(fundId);
		}
		if(!ValidateUtil.isEmpty(fundName)){
			c.andFundNameLike("%"+fundName+"%");
		}
		if(!ValidateUtil.isEmpty(projectName)){
			c.andProjectNameLike("%"+projectName+"%");
		}
		if(!ValidateUtil.isEmpty(enterpiseName)){
			c.andEnterpiseNameLike("%"+enterpiseName+"%");
		}
		if(!ValidateUtil.isEmpty(approDate)){
			c.andApproDateEqualTo(approDate);
		}
		if(!ValidateUtil.isEmpty(approAmount)){
			c.andApproAmountEqualTo(approAmount);
		}
		if(!ValidateUtil.isEmpty(realApproAmount)){
			c.andRealApproAmountEqualTo(realApproAmount);
		}
		if(!ValidateUtil.isEmpty(surplusApproAmount)){
			c.andSurplusApproAmountEqualTo(surplusApproAmount);
		}
		if(!ValidateUtil.isEmpty(acceptanceDate)){
			c.andAcceptanceDateEqualTo(acceptanceDate);
		}
		if(!ValidateUtil.isEmpty(voucherNo)){
			c.andVoucherNoEqualTo(voucherNo);
		}
		if(!ValidateUtil.isEmpty(remark)){
			c.andRemarkEqualTo(remark);
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
		//机构过滤
		UserInfo userInfo = LoginUserThread.getUser();
		if(!(RoleTypeEnum.admin.getCode().compareTo(userInfo.getRoleId())==0)&&!ValidateUtil.isEmpty(userInfo.getDepartId())){
			FundExample fundExample = new FundExample();
			fundExample.createCriteria().andDepartIdEqualTo(userInfo.getDepartId());
			List<Fund> funds = fundMapper.selectByExample(fundExample);
			List<Integer> fundIds = new ArrayList<Integer>();
			for (Fund fund : funds) {
				fundIds.add(fund.getId());
			}
			if(fundIds.size()==0){
				fundIds.add(0);
			}
			c.andFundIdIn(fundIds);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<FundDetail> page = (Page<FundDetail>) fundDetailMapper.selectByExample(example);
		List<FundDetail> list = page.getResult();
		//构造fundId数组[祖父id,父id,id]
		for (FundDetail fundDetail : list) {
			Fund fund = fundMapper.selectByPrimaryKey(fundDetail.getFundId());
			if(fund != null){
				Integer[] fundIds = null;
				String indexId = fund.getIndexId();
				if(indexId == null || indexId.equals("")){
					fundIds = new Integer[1];
					fundIds[0] = fund.getId();
				}else{
					String[] indexs = indexId.split("_");
					fundIds = new Integer[indexs.length+1];
					for (int i = 0; i < indexs.length; i++) {
						fundIds[i] = Integer.valueOf(indexs[i]);
					}
					fundIds[indexs.length] = fund.getId();
				}
				fundDetail.setFundIds(fundIds);
			}else{
				fundDetail.setFundIds(new Integer[1]);
			}
		}
		FundDetailLtResp resp = new FundDetailLtResp();
		resp.setCount(page.getTotal());
		resp.setFundDetailLt(list);
		return resp;
	}
	
}
