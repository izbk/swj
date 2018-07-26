package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.Department;
import cn.com.yuanwei.center.entity.DepartmentExample;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.DepartmentExample.Criteria;
import cn.com.yuanwei.center.mapper.DepartmentMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.DepartService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.UserLtReq;
import cn.com.yuanwei.center.web.response.DepartLtResp;

@Service
@Transactional
public class DepartServiceImpl implements DepartService {

	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	/**
	 * Desc:更新部门
	 * @author sky
	 * @date 2017年4月14日  下午2:27:58
	 */
	@Override
	public void updateDepart(Department dep) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),dep.getId(), "更新部门信息"));
		departmentMapper.updateByPrimaryKeyWithBLOBs(dep);
	}
	/**
	 * Desc:创建部门
	 * @author sky
	 * @date 2017年4月14日  下午2:28:11
	 */
	@Override
	public void createDepart(Department dep) throws Exception {
		departmentMapper.insert(dep);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),dep.getId(), "新增部门信息"));
	}
	/**
	 * Desc:删除部门
	 * @author sky
	 * @date 2017年4月14日  下午2:28:23
	 */
	@Override
	public void delDepart(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除部门信息"));
		}
		DepartmentExample de=new DepartmentExample();
		de.createCriteria().andIdIn(ids);
		departmentMapper.deleteByExample(de);
	}
	/**
	 * Desc:获取部门列表
	 * @author sky
	 * @date 2017年4月14日  下午2:28:32
	 */
	@Override
	public DepartLtResp getDepartLt(UserLtReq req) throws Exception {
		Integer id = req.getId();
		String name = req.getName();
		DepartmentExample de=new DepartmentExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(name)){
			c.andDepartnameLike("%"+name+"%");
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Department> page = (Page<Department>) departmentMapper.selectByExample(de);
		DepartLtResp resp = new DepartLtResp();
		resp.setCount(page.getTotal());
		resp.setDepartLt(page.getResult());
		return resp;
	}
	
}
