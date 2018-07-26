package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.ToDoList;
import cn.com.yuanwei.center.web.request.ToDoListReq;
import cn.com.yuanwei.center.web.response.ToDoListLtResp;
/**
 * 待办事项
 * 
 * @author zbk
 * @email 
 * @date 2017-05-16 11:11:22
 */
public interface ToDoListService {
   /**
	 * Desc:查询待办事项
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public ToDoList queryById(Integer id) throws Exception;
   /**
	 * Desc:查询待办事项列表
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public ToDoListLtResp queryList(ToDoListReq req) throws Exception;
	/**
	 * Desc:查询待办事项总数
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public ToDoListLtResp queryTotal(ToDoListReq req) throws Exception;
   /**
	 * Desc:新增待办事项
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public Integer save(ToDoList toDoList) throws Exception;
	/**
	 * Desc:更新待办事项
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public Integer update(ToDoList toDoList) throws Exception;
	/**
	 * Desc:删除待办事项
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public Integer delete(List<Integer> req) throws Exception;
	/**
	 * Desc:处理待办事项
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public void deal(ToDoListReq req) throws Exception;
}
