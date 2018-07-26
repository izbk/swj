package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Project;
import cn.com.yuanwei.center.web.request.ProjectReq;
import cn.com.yuanwei.center.web.response.ProjectLtResp;
/**
 * 项目储备表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-01 15:57:22
 */
public interface ProjectService {
   /**
	 * Desc:查询项目储备表
	 * @param Integer id
	 * @return  Project
	 * @author zbk
	 * @date 2017-06-01 15:57:22
	 */
	public Project queryById(Integer id) throws Exception;
   /**
	 * Desc:查询项目储备表列表
	 * @param ProjectReq req
	 * @return ProjectLtResp
	 * @author zbk
	 * @date 2017-06-01 15:57:22
	 */
	public ProjectLtResp queryList(ProjectReq req) throws Exception;
   /**
	 * Desc:新增项目储备表
	 * @param Project project
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-01 15:57:22
	 */
	public Integer save(Project project) throws Exception;
	/**
	 * Desc:更新项目储备表
	 * @param Project project
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-01 15:57:22
	 */
	public Integer update(Project project) throws Exception;
	/**
	 * Desc:删除项目储备表
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-01 15:57:22
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
