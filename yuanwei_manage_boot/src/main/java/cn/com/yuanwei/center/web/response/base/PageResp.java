package cn.com.yuanwei.center.web.response.base;

import java.io.Serializable;

import org.springframework.data.domain.Page;


/**
 * 返回的分页类
 * @author hejiadong
 *
 */
public class PageResp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 总记录数
	 */
	protected long total;
	
	/**
	 * 总页数
	 */
	protected int pagecount;
	
	/**
	 * 页号
	 */
	protected int page;
	
	/**
	 * 单页记录总数
	 */
	protected int itemcount;
	
	
	/**
	 * 当前页的记录数
	 */
	protected int currPageSize;
	
	
	

	public int getCurrPageSize() {
		return currPageSize;
	}

	public void setCurrPageSize(int currPageSize) {
		this.currPageSize = currPageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}

	public int getItemcount() {
		return itemcount;
	}

	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public <T> PageResp(Page<T> page){
		this.total = page.getTotalElements();
		this.pagecount = page.getTotalPages();
		this.page = page.getNumber()+1;
		this.itemcount = page.getSize();
		this.currPageSize = page.getNumberOfElements();
	}
	
}
