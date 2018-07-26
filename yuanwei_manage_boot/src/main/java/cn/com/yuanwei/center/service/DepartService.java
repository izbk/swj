package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Department;
import cn.com.yuanwei.center.web.request.UserLtReq;
import cn.com.yuanwei.center.web.response.DepartLtResp;

public interface DepartService {
	public DepartLtResp getDepartLt(UserLtReq req) throws Exception;
	public void updateDepart(Department dep) throws Exception;
	public void createDepart(Department dep) throws Exception;
	public void delDepart(List<Integer> req) throws Exception;
}
