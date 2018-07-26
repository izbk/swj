package cn.com.yuanwei.center.web.request;

import javax.validation.constraints.Min;

import cn.com.yuanwei.center.web.request.base.PageReq;

public class UserLtReq extends PageReq {
	private static final long serialVersionUID = -7649763865978440230L;
	@Min(value=1, message="id必须为整数并且大于0")
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
