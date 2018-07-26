package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.ToDoList;
/**
 * 待办事项
 * 
 * @author zbk
 * @email 
 * @date 2017-05-16 11:11:22
 */
public class ToDoListLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<ToDoList> toDoListLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<ToDoList> getToDoListLt() {
		return toDoListLt;
	}
	public void setToDoListLt(List<ToDoList> toDoListLt) {
		this.toDoListLt = toDoListLt;
	}
}
