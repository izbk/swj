package cn.com.yuanwei.center.web.request.base;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PageReq implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 页号
	 */
	@Min(value=1, message="page必须为整数并且大于0")
	@Max(value=99999999, message="page不能大于99999999")
	private Integer page = 1;
	/**
	 * 每页数
	 */
	@Min(value=1, message="itemcount必须为整数并且大于0")
	@Max(value=99999999, message="itemcount不能大于99999")
	private Integer itemcount = 10;
	
	/**
	 * 排序字段
	 */
	protected String orderby;
	
	/**
	 * 排序方式
	 */
	protected String sort = "desc";
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getItemcount() {
		return itemcount;
	}

	public void setItemcount(Integer itemcount) {
		this.itemcount = itemcount;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public PageReq() {
		
	}
	
	
	
	
}
