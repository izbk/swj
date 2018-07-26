package cn.com.yuanwei.center.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.Type;
import cn.com.yuanwei.center.entity.TypeExample;
import cn.com.yuanwei.center.entity.TypeExample.Criteria;
import cn.com.yuanwei.center.entity.TypeGroup;
import cn.com.yuanwei.center.entity.TypeGroupExample;
import cn.com.yuanwei.center.entity.TypeVo;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.TypeGroupMapper;
import cn.com.yuanwei.center.mapper.TypeMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.TypeService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.CommonTypeReq;
import cn.com.yuanwei.center.web.request.TypeReq;
import cn.com.yuanwei.center.web.response.CommonTypeLtResp;
import cn.com.yuanwei.center.web.response.TypeLtResp;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeMapper typeMapper;
	@Autowired
	private TypeGroupMapper typeGroupMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	
	@Override
	public Integer save(Type type) throws Exception {
		if(ValidateUtil.isEmpty(type.getTypeName())){
			throw new Exception("数据字典名称代码不能为空");
		}
		if(ValidateUtil.isEmpty(type.getTypeCode())){
			throw new Exception("数据字典代码不能为空");
		}
		typeMapper.insert(type);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,type.getId(), "新增数据类型"));
		return type.getId();
	}

	@Override
	public Integer update(Type type) throws Exception {
		if(ValidateUtil.isEmpty(type.getTypeName())){
			throw new Exception("数据字典名称代码不能为空");
		}
		if(ValidateUtil.isEmpty(type.getTypeCode())){
			throw new Exception("数据字典代码不能为空");
		}
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),type.getId(), "更新数据类型"));
		return typeMapper.updateByPrimaryKey(type);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除数据类型"));
		}	
		TypeExample example = new TypeExample();
		example.createCriteria().andIdIn(ids);
		return typeMapper.deleteByExample(example);
	}
	
	@Override
	public Type queryById(Integer id){
		return typeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public TypeLtResp queryList(TypeReq req) throws Exception {
		Integer id = req.getId();
		String typeName = req.getTypeName();
		String typeCode = req.getTypeCode();
		Integer typeGroupId = req.getTypeGroupId();
		Integer status = req.getStatus();
		TypeExample example = new TypeExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(typeName)){
			c.andTypeNameLike("%"+typeName+"%");
		}
		if(!ValidateUtil.isEmpty(typeCode)){
			c.andTypeCodeEqualTo(typeCode);
		}
		if(!ValidateUtil.isEmpty(typeGroupId)){
			c.andTypeGroupIdEqualTo(typeGroupId);
		}
		if(!ValidateUtil.isEmpty(status)){
			c.andStatusEqualTo(status);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Type> page = (Page<Type>) typeMapper.selectByExample(example);
		TypeLtResp resp = new TypeLtResp();
		resp.setCount(page.getTotal());
		resp.setTypeLt(page.getResult());
		return resp;
	}
	
	@Override
	public CommonTypeLtResp queryCommonTypeList(CommonTypeReq req) throws Exception {
		CommonTypeLtResp resp = new CommonTypeLtResp();
		List<TypeVo> typeVos = new ArrayList<TypeVo>();
		//查询数据字典表
		String groupName = req.getGroupName();
		if(groupName != null && !groupName.equals("")){
			TypeGroupExample example = new TypeGroupExample();
			example.createCriteria().andGroupCodeEqualTo(groupName);
			List<TypeGroup> list = typeGroupMapper.selectByExample(example);
			if(list != null && list.size() > 0){
				TypeGroup group = list.get(0);
				TypeExample de=new TypeExample();
				de.createCriteria().andTypeGroupIdEqualTo(group.getId());
				List<Type> types = typeMapper.selectByExample(de);
				for (Type type : types) {
					TypeVo vo = new TypeVo();
					vo.setLabel(type.getTypeName());
					vo.setValue(StringUtils.isNumeric(type.getTypeCode())?Integer.parseInt(type.getTypeCode()):type.getTypeCode());
					typeVos.add(vo);
				}
			}
		}else{//通用查询
			String tableName = req.getTableName();
			String label = req.getLabel();
			String value = req.getValue();
			if(tableName == null || tableName.equals("")){
				return resp;
			}
			if(label == null || label.equals("")){
				return resp;
			}
			if(value == null || value.equals("")){
				return resp;
			}
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("tableName", tableName);
			param.put("label", label);
			param.put("value", value);
			String data = req.getDataList();
			if(!ValidateUtil.isEmpty(data)){
				Map<String,Object> map = JSON.parseObject(data, new TypeReference<HashMap<String,Object>>() {});
				param.put("data", map);
			}
			typeVos = typeMapper.selectCommonTypeList(param);
		}
		resp.setCount(new Long(typeVos.size()));
		resp.setTypeLt(typeVos);
		return resp;
	}
	
	public String getTypeName(String groupCode,String typeCode){
		TypeGroupExample example = new TypeGroupExample();
		example.createCriteria().andGroupCodeEqualTo(groupCode);
		List<TypeGroup> typeGroups = typeGroupMapper.selectByExample(example);
		if(!ValidateUtil.isEmpty(typeGroups)){
			TypeGroup typeGroup = typeGroups.get(0);
			TypeExample de = new TypeExample();
			de.createCriteria().andTypeGroupIdEqualTo(typeGroup.getId()).andTypeCodeEqualTo(typeCode);
			List<Type> types = typeMapper.selectByExample(de);
			if(!ValidateUtil.isEmpty(types)){
				Type type = types.get(0);
				return type.getTypeName();
			}
		}
		return null;
	}
}
