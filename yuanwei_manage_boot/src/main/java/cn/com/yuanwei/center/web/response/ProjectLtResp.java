package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Project;
/**
 * 项目储备表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-01 15:57:22
 */
public class ProjectLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Project> projectLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Project> getProjectLt() {
		return projectLt;
	}
	public void setProjectLt(List<Project> projectLt) {
		this.projectLt = projectLt;
	}
}
