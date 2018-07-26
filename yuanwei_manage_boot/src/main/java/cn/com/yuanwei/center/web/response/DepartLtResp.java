package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Department;

public class DepartLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Department> departLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Department> getDepartLt() {
		return departLt;
	}
	public void setDepartLt(List<Department> departLt) {
		this.departLt = departLt;
	}

	
}
